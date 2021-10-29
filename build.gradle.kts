import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    java
    id("com.github.johnrengelman.shadow") version ("7.0.0")
}

val versionNum = "2.0"

group = "me.cxmilo"
version = "$versionNum-SNAPSHOT"

repositories {
    mavenCentral()
    mavenLocal()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven("https://oss.sonatype.org/content/groups/public/")
    maven("https://repo.unnamed.team/repository/unnamed-public/")
}

apply(plugin = "java")
apply(plugin = "com.github.johnrengelman.shadow")

dependencies {
    compileOnly("org.spigotmc:spigot-api:1.8.8-R0.1-SNAPSHOT")

    implementation("me.fixeddev:commandflow-bukkit:0.4.0")
    implementation("team.unnamed.gui:core:2.3.1-SNAPSHOT")
    implementation("redis.clients:jedis:3.6.0")
}

tasks.withType<ShadowJar> {
    // relocations
    relocate("me.fixeddev.commandflow", "me.cxmilo.staff.libs.commandflow")
    relocate("team.unnamed", "me.cxmilo.staff.libs.unnamed")
    relocate("team.unnamed.gui", "me.cxmilo.staff.libs.gui")
    relocate("redis.clients", "me.cxmilo.staff.libs.clients")

    // set .jar name
    archiveFileName.set("Staff-$versionNum.jar")
}