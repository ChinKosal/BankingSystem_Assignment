plugins {
	java
	id("org.springframework.boot") version "3.5.5"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "com.bank"
version = "0.0.1-SNAPSHOT"
description = "Demo project for Spring Boot"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	// -----------------------------
	// Spring Boot Starters
	// -----------------------------
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-mail")
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-aop")

	// -----------------------------
	// Swagger / OpenAPI (Springdoc)
	// -----------------------------
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.6.0")

	// -----------------------------
	// ModelMapper
	// -----------------------------
	implementation("org.modelmapper:modelmapper:3.2.1")

	// -----------------------------
	// JWT
	// -----------------------------
	implementation("io.jsonwebtoken:jjwt-api:0.11.5")
	implementation("io.jsonwebtoken:jjwt-impl:0.11.5")
	implementation("io.jsonwebtoken:jjwt-jackson:0.11.5")

	// -----------------------------
	// Redis session (optional)
	// -----------------------------
	implementation("org.springframework.session:spring-session-data-redis")

	// -----------------------------
	// Database Driver (choose one)
	// -----------------------------
	runtimeOnly("org.postgresql:postgresql")

	// -----------------------------
	// Lombok
	// -----------------------------
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")

	// -----------------------------
	// Test
	// -----------------------------
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.security:spring-security-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
