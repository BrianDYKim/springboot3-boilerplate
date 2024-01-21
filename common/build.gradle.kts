import org.springframework.boot.gradle.tasks.bundling.BootJar

dependencies {
}

tasks.withType<Jar> {
    enabled = true
}

tasks.withType<BootJar> {
    enabled = false
}
