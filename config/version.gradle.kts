extra.apply {
    set("newCompileSdk", 34)
    set("newMinSdk", 24)
    set("newTargetSdk", 34)

    // Version code
    set("verCode", 1)

    // Semantic Versioning
    val MAJOR = 1
    val MINOR = 0
    val PATCH = 0

    set("verName", "$MAJOR.$MINOR.$PATCH")

    // Java version
    set("compileVersion", JavaVersion.VERSION_11)

    // 3rd Party libraries
    set("sdp", "1.0.6")
    set("ssp", "1.0.6")
    set("hilt", "2.51.1")
    set("hilt_navigation_compose", "1.2.0")
    set("vico", "2.0.0-alpha.21")
    set("appCenterSdkVersion", "5.0.4")
    set("dotenv", "6.4.1")
    set("retrofit_version", "2.11.0")
    set("gson_version", "2.11.0")


//    set("kapt", "2.0.0")
//    set("retrofit_version", "2.11.0")
//    set("gson_version", "2.11.0")
//    set("glide", "4.12.0")
//    set("shimmer", "0.5.0")

}