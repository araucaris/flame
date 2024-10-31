import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    `flame-java`
    `flame-application`
    `flame-repositories`
    `flame-publish`
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

application {
    mainClass.set("dev.varion.flame.FlameLauncher")
}

dependencies {
    implementation(project(":flame-frontend"))
}

tasks.withType<ShadowJar> {
    archiveFileName.set("flame-${archiveVersion.get()}.jar")
    mergeServiceFiles()
}