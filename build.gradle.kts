import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
buildscript {
    repositories {
        gradlePluginPortal()
        jcenter()
    }

}
plugins{
    java
    kotlin("jvm") version "1.8.0-RC2" apply false
}


val apiRelease by rootProject.extra { "9.9.9" }

project.extra["GithubUrl"] = "https://github.com/JagexCompliant/meteor-externals"
apply<BootstrapPlugin>()
subprojects {
    group = "meteor"
    project.extra["ProjectSupportUrl"] = "https://discord.gg/mhJpd9yc"

    apply<JavaPlugin>()
    apply(plugin = "kotlin")
    repositories {
        mavenCentral()
        mavenLocal()
    }
    dependencies {
        implementation(group = "com.squareup.okhttp3", name = "okhttp", version = "5.0.0-alpha.10")
    }
    dependencies {
        compileOnly(group ="meteor" ,name = "eventbus", version =apiRelease)
        compileOnly(group = "meteor", name = "client", version = apiRelease)
        compileOnly(group = "meteor", name = "api", version = apiRelease)
        implementation(gradleApi())
        implementation(group = "org.json", name = "json", version = "20220924")
        implementation(group = "com.savvasdalkitsis", name = "json-merge", version = "0.0.6")
    }

    tasks {

        withType<KotlinCompile>().all {
            kotlinOptions {
                apiVersion = "1.8"
                languageVersion = "1.8"
                jvmTarget = "17"
                // We can't use K2 yet due to using some kotlin compiler plugins which aren't supported yet.
                freeCompilerArgs = listOf( //"-Xuse-k2",
                    "-Xjvm-default=all",
                    "-Xbackend-threads=4"
                )
            }
        }
        withType<JavaCompile> {
            sourceCompatibility = JavaVersion.VERSION_17.toString()
            targetCompatibility = JavaVersion.VERSION_17.toString()
            options.encoding = "UTF-8"
        }

        withType<Jar> {
            doLast {
                copy {
                    from("./build/libs/")
                    into( "${System.getProperty("user.home")}/.meteor/externalplugins/")
                }
            }
        }
    }
}