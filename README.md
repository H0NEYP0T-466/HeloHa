# HeloHa 💬

![GitHub License](https://img.shields.io/github/license/H0NEYP0T-466/HeloHa?style=for-the-badge&color=brightgreen)
![GitHub Stars](https://img.shields.io/github/stars/H0NEYP0T-466/HeloHa?style=for-the-badge&color=yellow)
![GitHub Forks](https://img.shields.io/github/forks/H0NEYP0T-466/HeloHa?style=for-the-badge&color=blue)
![Contributions Welcome](https://img.shields.io/badge/Contributions-Welcome-brightgreen?style=for-the-badge)
![GitHub Issues](https://img.shields.io/github/issues/H0NEYP0T-466/HeloHa?style=for-the-badge&color=red)

A modern, real-time chat application built with Kotlin and Jetpack Compose, featuring Firebase integration for seamless communication experience. HeloHa provides a beautiful Material Design 3 interface for group messaging with secure user authentication.

## 🔗 Links

- [🚀 Demo](#-usage) | [📚 Documentation](#-table-of-contents) | [🐛 Issues](https://github.com/H0NEYP0T-466/HeloHa/issues) | [🤝 Contributing](CONTRIBUTING.md)

## 📋 Table of Contents

- [✨ Features](#-features)
- [🛠️ Built With](#️-built-with)
- [📦 Installation](#-installation)
- [🚀 Usage](#-usage)
- [📁 Project Structure](#-project-structure)
- [🗺️ Roadmap](#️-roadmap)
- [🤝 Contributing](#-contributing)
- [📄 License](#-license)
- [🙏 Acknowledgments](#-acknowledgments)

## ✨ Features

- 🔐 **Secure Authentication** - Firebase Authentication with email/password
- 💬 **Real-time Messaging** - Instant group chat with Firebase Realtime Database
- 👥 **User Management** - Unique username system with validation
- 🎨 **Modern UI** - Beautiful Material Design 3 interface with Jetpack Compose
- 📱 **Responsive Design** - Optimized for various screen sizes
- 🚀 **Fast Navigation** - Smooth navigation with Jetpack Navigation Component
- 🔔 **Push Notifications** - Firebase Cloud Messaging integration
- 💾 **Auto-save** - Real-time message synchronization

## 🛠️ Built With

- [Kotlin](https://kotlinlang.org/) - Modern programming language for Android development
- [Jetpack Compose](https://developer.android.com/jetpack/compose) - Android's modern toolkit for building native UI
- [Firebase Authentication](https://firebase.google.com/products/auth) - User authentication and management
- [Firebase Realtime Database](https://firebase.google.com/products/realtime-database) - Real-time data synchronization
- [Firebase Cloud Messaging](https://firebase.google.com/products/cloud-messaging) - Push notifications
- [Material Design 3](https://m3.material.io/) - Google's latest design system
- [Navigation Component](https://developer.android.com/guide/navigation) - App navigation framework
- [Coroutines](https://kotlinlang.org/docs/coroutines-overview.html) - Asynchronous programming

## 📦 Installation

### Prerequisites

- Android Studio Arctic Fox or later
- Android SDK API level 21+
- Kotlin 1.8.0+
- Firebase project setup

### Setup Steps

1. **Clone the repository**
   ```bash
   git clone https://github.com/H0NEYP0T-466/HeloHa.git
   cd HeloHa
   ```

2. **Open in Android Studio**
   - Launch Android Studio
   - Select "Open an existing project"
   - Navigate to the cloned directory

3. **Firebase Configuration**
   - Create a new Firebase project at [Firebase Console](https://console.firebase.google.com/)
   - Enable Authentication (Email/Password)
   - Enable Realtime Database
   - Enable Cloud Messaging
   - Download `google-services.json` and place it in the `app/` directory

4. **Build and Run**
   ```bash
   ./gradlew assembleDebug
   # Or use Android Studio's run button
   ```

## 🚀 Usage

### Getting Started

1. **Launch the App**
   - Open HeloHa on your Android device
   - You'll see the splash screen with authentication check

2. **Create Account**
   - Tap "Sign Up" if you're a new user
   - Enter your name, email, and password
   - Unique usernames are validated in real-time

3. **Login**
   - Use your registered email and password
   - Authentication is handled securely via Firebase

4. **Start Chatting**
   - Join the group chat called "Pookies"
   - Send messages in real-time
   - See other users' messages instantly

### Key Interactions

- **Send Message**: Type in the text field and tap the send button
- **Auto-scroll**: Messages automatically scroll to the latest
- **Logout**: Use the logout button in the top bar
- **User Identification**: Your messages appear on the right, others on the left

## 📁 Project Structure

```
HeloHa/
├── 📄 Data.kt                    # Message data class definition
├── 📄 Home_Screen.kt             # Main chat interface screen
├── 📄 Login.kt                   # User login screen
├── 📄 MainActivity.kt            # Main activity with navigation setup
├── 📄 Sign_Up.kt                 # User registration screen
├── 📄 Splash_Screen.kt           # Splash screen with auth check
├── 📄 README.md                  # Project documentation
├── 📄 LICENSE                    # MIT License
└── 📄 CONTRIBUTING.md            # Contribution guidelines
```

## 🗺️ Roadmap

### ✅ Current Features
- [x] User authentication and registration
- [x] Real-time group messaging
- [x] Material Design 3 UI
- [x] Firebase integration
- [x] Unique username validation

### 🚧 In Progress
- [ ] Private messaging between users
- [ ] Message reactions and emojis
- [ ] Image and file sharing

### 🔮 Future Vision
- [ ] Voice messages
- [ ] Video calling integration
- [ ] Dark mode support
- [ ] Message encryption
- [ ] Multi-language support
- [ ] Custom themes and personalization
- [ ] Message search functionality
- [ ] User profiles with avatars

## 🤝 Contributing

We welcome contributions from the community! Please read our [Contributing Guidelines](CONTRIBUTING.md) for details on:

- 🍴 How to fork and contribute
- 📝 Code style and conventions
- 🐛 Bug reports and feature requests
- ✅ Testing requirements

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🙏 Acknowledgments

- **Firebase Team** - For providing excellent backend services
- **Google** - For Jetpack Compose and Material Design
- **Kotlin Team** - For the amazing programming language
- **Open Source Community** - For inspiration and resources

---

<div align="center">
<p><strong>Made with ❤️ by <a href="https://github.com/H0NEYP0T-466">H0NEYP0T-466</a></strong></p>
</div>