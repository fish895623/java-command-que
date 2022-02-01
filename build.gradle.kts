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

configurations {
  all {
    exclude(
      group = "org.springframework.boot",
      module = "spring-boot-starter-logging"
    )
  }
}

dependencies {
  implementation("org.springframework.boot:spring-boot-starter-web:2.6.3")
  implementation("org.xerial:sqlite-jdbc:3.36.0.2")
  implementation(
    group = "org.apache.logging.log4j",
    name = "log4j-core",
    version = "2.17.0"
  )
  implementation(
    group = "org.apache.logging.log4j",
    name = "log4j-api",
    version = "2.17.0"
  )
  implementation(
    group = "org.springframework.boot",
    name = "spring-boot-starter-log4j2"
  )
  implementation(
    group = "com.fasterxml.jackson.dataformat",
    name = "jackson-dataformat-yaml",
    version = "2.9.8"
  )
  implementation(
    group = "com.fasterxml.jackson.core",
    name = "jackson-databind",
    version = "2.9.8"
  )
  developmentOnly("org.springframework.boot:spring-boot-devtools:2.6.3")
  testImplementation("org.springframework.boot:spring-boot-starter-test:2.6.3")
}

tasks.test {
  useJUnitPlatform()
}
