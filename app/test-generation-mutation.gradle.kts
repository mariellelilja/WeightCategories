// test-generation-mutation.gradle.kts

import org.gradle.process.ExecSpec
task runRandoop(type: Exec) {
    commandLine("java", "-jar", "../lib/randoop-4.3.2.jar", "gentests", "--classlist=../targetclasses.txt", "--output-tests=../out")
}
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
