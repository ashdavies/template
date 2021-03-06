object ProjectDependencies {

    object AndroidX : DependencyGroup("androidx") {

        val activityKtx by artifact("$group.activity", "1.2.0-beta01")
        val annotation by artifact("$group.annotation", "1.2.0-alpha01")

        object Compose : DependencyGroup("androidx.compose", "1.0.0-SNAPSHOT") {

            val composeCompiler by artifact("$group-compiler")
            val foundation by artifact("$group.foundation")
            val material by artifact("$group.material")
            val navigation by artifact("$group.navigation")
            val runtime by artifact("$group.runtime")
            val ui by artifact("$group.ui")
        }

        val coreKtx by artifact("$group.core", "1.5.0-alpha04")
        val datastoreCore by artifact("$group.datastore", "1.0.0-SNAPSHOT")
        val fragmentKtx by artifact("$group.fragment", "1.3.0-beta01")

        object Lifecycle : DependencyGroup("androidx.lifecycle", "2.3.0-beta01") {

            val lifecycleCommonJava8 by artifact()
            val lifecycleLivedataKtx by artifact()
            val lifecycleViewmodelKtx by artifact()
        }

        object Navigation : DependencyGroup("androidx.navigation", "2.3.1") {

            val navigationFragmentKtx by artifact()
            val navigationRuntimeKtx by artifact()
            val navigationUiKtx by artifact()
        }

        val pagingRuntime by artifact("$group.paging", "3.0.0-alpha07")

        object Ui : DependencyGroup("androidx.ui", Compose.version) {

            val uiTooling by artifact()
            val uiTest by artifact()
        }
    }

    object Dropbox : DependencyGroup("com.dropbox.mobile") {

        val store4 by artifact("$group.store", "4.0.0-beta01")
    }

    object Google : DependencyGroup("com.google") {

        object Firebase : DependencyGroup("$group.firebase") {

            val firebaseCommonKtx by artifact(version = "19.3.1")
            val firebaseAnalytics by artifact(version = "17.6.0")
        }

        object Android : DependencyGroup("$group.android") {

            val material by artifact("$group.material", "1.3.0-alpha03")
            val playServicesOssLicenses by artifact("$group.gms", "17.0.0")
        }

        val truth by artifact("$group.truth", "1.0.1")
    }

    object JetBrains : DependencyGroup("org.jetbrains") {

        object Kotlin : DependencyGroup("$group.kotlin", "1.4.20-RC") {

            val kotlinTest by artifact()
            val kotlinTestCommon by artifact()
            val kotlinTestJunit by artifact()
            val kotlinTestAnnotationsCommon by artifact()
        }

        object KotlinX : DependencyGroup("$group.kotlinx", "1.4.0-M1") {

            val kotlinxCoroutinesAndroid by artifact()
            val kotlinxCoroutinesCore by artifact()
            val kotlinxCoroutinesTest by artifact()
            val kotlinxDatetime by artifact(version = "0.1.0")
            val kotlinxSerializationJson by artifact(version = "1.0.0")
        }
    }

    const val jUnit = "junit:junit:4.13.1"

    object Ktor : DependencyGroup("io.ktor", "1.4.1") {

        val ktorClientAndroid by artifact()
        val ktorClientCore by artifact()
        val ktorClientCurl by artifact()
        val ktorClientIos by artifact()
        val ktorClientJson by artifact()
        val ktorClientLogging by artifact()
        val ktorClientSerialization by artifact()
    }

    object Pinterest : DependencyGroup("com.pinterest") {

        val ktlint by artifact(version = "0.39.0")
    }

    object Square : DependencyGroup("com.squareup") {

        object SqlDelight : DependencyGroup("$group.sqldelight", "1.4.4") {

            val androidDriver by artifact()
            val coroutinesExtensions by artifact()
            val nativeDriver by artifact()
            val sqliteDriver by artifact()
            val runtime by artifact()
        }
    }
}
