<h1>CatoGenerator Multiplatform</h1>

<strong>Генератор случайных изображений котов на Compose Multiplatform</strong>

<div align="center">
    <img src="docs/apps_screenshot.png">
</div>

- Tech stack
    - [Compose Multiplatform](https://github.com/JetBrains/compose-jb) - UI (Android, iOS, Desktop)
    - [Lifecycle Viewmodel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Viewmodel
    - [Coil](https://github.com/coil-kt/coil) - Image Loading
    - [Ktor](https://ktor.io/) - Network communication
    - [Koin](https://insert-koin.io/) - Dependency injection

## Before running!
 - check your system with [KDoctor](https://github.com/Kotlin/kdoctor)
 - install JDK 17 or higher on your machine
 - add `local.properties` file to the project root and set a path to Android SDK there

### Android
To run the application on android device/emulator:  
 - open project in Android Studio and run imported android run configuration

To build the application bundle:
 - run `./gradlew :app:androidApp:assembleDebug`
 - find `.apk` file in `app/androidApp/build/outputs/apk/debug/composeApp-debug.apk`

### Desktop
Run the desktop application: `./gradlew :app:build-common:run`
Run desktop UI tests: `./gradlew :app:build-common:jvmTest`

### iOS
To run the application on iPhone device/simulator:
 - Open `app/iosApp/iosApp.xcproject` in Xcode and run standard configuration
 - Or use [Kotlin Multiplatform Mobile plugin](https://plugins.jetbrains.com/plugin/14936-kotlin-multiplatform-mobile) for Android Studio
Run iOS simulator UI tests: `./gradlew :app:build-common:iosSimulatorArm64Test`