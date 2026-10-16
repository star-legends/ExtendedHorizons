plugins {
  `java-library`
}

group = rootProject.group
version = rootProject.version

java {
  toolchain {
    languageVersion.set(JavaLanguageVersion.of(25))
  }
}

dependencies {
  compileOnlyApi(libs.core)
  annotationProcessor(libs.core)
  compileOnlyApi(libs.paper.api)
}

tasks.withType<JavaCompile>().configureEach {
  options.encoding = "UTF-8"
  options.release.set(25)
  options.compilerArgs.addAll(
    listOf(
      "-parameters",
      "-Aplugin.package=me.mapacheee.extendedhorizons",
      "-Aplugin.name=ExtendedHorizonsPlugin",
      "-Aplugin.type=API"
    )
  )
}
