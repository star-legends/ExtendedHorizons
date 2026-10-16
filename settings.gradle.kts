rootProject.name = "ExtendedHorizons"

include("${rootProject.name}-api")
project(":${rootProject.name}-api").projectDir = file("api")
