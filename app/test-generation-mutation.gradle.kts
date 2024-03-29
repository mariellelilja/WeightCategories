// test-generation-mutation.gradle.kts
plugins {
    id("java")
}

repositories {
    mavenCentral()
}

dependencies {
    //Dependencies for test generation and mutation testing tools
    testImplementation(libs.evosuiteRuntime)
    testImplementation("randoop:randoop:4.3.2")
    testImplementation("net.sourceforge.javydreamercsw:randoop:1.3.2")
    //Mujava
}

// You can define custom tasks for running evosuite, randoop, and mujava here
