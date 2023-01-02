import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins{
    java
    kotlin("jvm") version "1.8.0-RC2" apply false
}

val apiRelease by rootProject.extra { "9.9.9" }

subprojects {
    group = "meteor"
    apply<JavaPlugin>()
    apply(plugin = "kotlin")
    repositories {
        mavenCentral()
        mavenLocal()
    }

    dependencies {
        compileOnly(group ="meteor" ,name = "eventbus", version =apiRelease)
        compileOnly(group = "meteor", name = "client", version = apiRelease)
        compileOnly(group = "meteor", name = "api", version = apiRelease)
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