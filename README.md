# Heloha - Real-time Chat Application

Heloha is a simple, real-time group chat application for Android. It allows users to sign up, log in, and communicate with each other in a shared chat room.

## Features

*   **User Authentication:** Secure sign-up and login using Firebase Authentication (Email & Password).
*   **Real-time Group Chat:** A single chat room where all users can send and receive messages instantly.
*   **Simple UI:** A clean and intuitive user interface built with Jetpack Compose.
*   **Splash Screen:** A welcoming splash screen when the app starts.
*   **Logout:** Users can easily log out of their account.

## Tech Stack

*   **Language:** [Kotlin](https://kotlinlang.org/)
*   **UI Toolkit:** [Jetpack Compose](https://developer.android.com/jetpack/compose)
*   **Backend & Real-time Sync:** [Firebase Realtime Database](https://firebase.google.com/products/realtime-database)
*   **Authentication:** [Firebase Authentication](https://firebase.google.com/products/auth)
*   **Navigation:** [Jetpack Navigation for Compose](https://developer.android.com/jetpack/compose/navigation)

## Setup and Installation

To build and run this project, you will need to have Android Studio set up.

1.  **Clone the repository:**
    ```bash
    git clone <repository-url>
    ```

2.  **Set up Firebase:**
    *   Go to the [Firebase Console](https://console.firebase.google.com/) and create a new project.
    *   Add an Android app to your Firebase project with the package name `com.example.heloha`.
    *   Follow the instructions to download the `google-services.json` configuration file.
    *   Place the `google-services.json` file in the project's app module directory (usually `app/`).
    *   In the Firebase Console, enable **Authentication** with the "Email/Password" sign-in method.
    *   Set up **Realtime Database**. You can start in test mode for initial development.

3.  **Build and Run:**
    *   Open the project in Android Studio.
    *   Let Gradle sync the dependencies.
    *   Run the app on an Android emulator or a physical device.
