import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
  id("org.springframework.boot") version "2.6.1"
  id("io.spring.dependency-management") version "1.0.11.RELEASE" apply true
  id("java")
}

group = "com.github.fish895623"
version = "0.0.102"

tasks {
  withType<BootJar> {
    archiveBaseName.set("command")
    archiveVersion.set("")
  }
}

repositories {
  mavenCentral()
}

dependencies {
  implementation("org.springframework.boot:spring-boot-starter-web:2.6.3")
  implementation("org.xerial:sqlite-jdbc:3.36.0.2")
  developmentOnly("org.springframework.boot:spring-boot-devtools:2.6.3")
  testImplementation("org.springframework.boot:spring-boot-starter-test:2.6.3")
}

tasks.test {
  useJUnitPlatform()
}
