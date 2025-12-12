plugins {
    id("java")
    id("java-library")
}

repositories{
    mavenCentral()
}

dependencies {
    api("com.formdev:flatlaf:3.7")
    api("com.formdev:flatlaf-intellij-themes:3.7")
    api("com.formdev:flatlaf-fonts-inter:4.1")
}