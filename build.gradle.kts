buildscript {
    dependencies {
        classpath(libs.google.services)
    }
}
plugins {
    id("com.google.gms.google-services") version "4.4.1" apply false
    alias(libs.plugins.androidApplication) apply false
}