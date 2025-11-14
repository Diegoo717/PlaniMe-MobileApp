<div align="center">

# 📱 PlaniMe Mobile

**Your personalized nutrition assistant: smart plans and progress tracking**

[![Kotlin](https://img.shields.io/badge/Kotlin-1.8+-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white)](https://kotlinlang.org/)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-1.5+-4285F4?style=for-the-badge&logo=jetpackcompose&logoColor=white)](https://developer.android.com/jetpack/compose)
[![Android](https://img.shields.io/badge/Android-7.0+-3DDC84?style=for-the-badge&logo=android&logoColor=white)](https://www.android.com/)

📦 **[Download APK](https://planime.diecode.lat/assets/downloads/PlaniMe_v1.0.apk)**

</div>

---

## 🎯 About The Project

**PlaniMe Mobile** is a native Android application developed with Kotlin and Jetpack Compose, designed to manage personalized nutrition plans through our RESTful API. It implements MVVM architecture, screen navigation, service consumption with Retrofit, and asynchronous operations with Coroutines, offering highly optimized performance.

### What Makes PlaniMe Special?

- 🍎 **Personalized Plans**: Custom meal plans tailored to your goals
- 📊 **Progress Tracking**: Monitor weight and nutritional objectives
- 🎯 **Goal-Oriented**: Designed to help you achieve your health targets
- 🔐 **Secure Authentication**: JWT-based login and registration
- ⚡ **High Performance**: Optimized MVVM architecture
- 🔄 **Real-time Sync**: Full integration with RESTful API

---

## ✨ Key Features

### 🥗 Nutrition Management

- Create and customize personalized meal plans
- Daily and weekly nutrition planning
- Calorie and macronutrient tracking
- Meal recommendations based on your goals

### 📈 Progress Monitoring

- Weight tracking over time
- Visual charts and statistics
- Goal achievement monitoring
- Progress history

### 👤 User Profile

- Personal information management
- Health metrics configuration
- Dietary preferences and restrictions
- Activity level settings

### 🎨 User Experience

- Modern UI with Material Design 3
- Smooth animations and transitions
- Intuitive navigation
- Responsive and fluid interface

---

## 🛠️ Tech Stack

### Core

- **[Kotlin](https://kotlinlang.org/)** - Main development language
- **[Jetpack Compose](https://developer.android.com/jetpack/compose)** - Modern UI toolkit
- **[Material Design 3](https://m3.material.io/)** - Google's design system

### Architecture

- **MVVM** - Model-View-ViewModel pattern
- **Clean Architecture** - Separation of concerns
- **Repository Pattern** - Data source abstraction

### Libraries & Frameworks

- **[Retrofit](https://square.github.io/retrofit/)** - HTTP client for API consumption
- **[Coroutines](https://kotlinlang.org/docs/coroutines-overview.html)** - Asynchronous programming
- **[Navigation Component](https://developer.android.com/guide/navigation)** - Screen navigation
- **[ViewModel & LiveData](https://developer.android.com/topic/libraries/architecture/viewmodel)** - State management
- **[SharedPreferences](https://developer.android.com/training/data-storage/shared-preferences)** - Local storage

---

## 📂 Project Structure

The project follows Clean Architecture principles with clear separation of layers:

- **Data Layer**: Manages data sources (API, local storage) and repositories
- **Domain Layer**: Contains business logic and use cases
- **Presentation Layer**: UI screens and ViewModels built with Jetpack Compose

### Main Components

- **Authentication Module**: Login, registration, and session management
- **Plans Module**: Create, view, and edit nutrition plans
- **Progress Module**: Track weight and goal achievement
- **Profile Module**: User information and preferences management
- **Navigation**: Type-safe navigation between screens
- **UI Components**: Reusable cards, charts, inputs, and navigation elements
- **Theme**: Consistent styling and theming system

---

## 📦 Prerequisites

### For Installation

- Android device with API level 24+ (Android 7.0 or higher)
- Storage space: ~30 MB

### For Development

- **Android Studio** Arctic Fox or newer
- **JDK** 11 or higher
- **Android SDK** API 33+
- **Kotlin** 1.8+

---

## 🚀 Installation

### From APK (End Users)

1. **Download the APK**

   ```
   https://planime.diecode.lat/assets/downloads/PlaniMe_v1.0.apk
   ```

2. **Enable Unknown Sources**

   - Go to Settings > Security
   - Enable "Unknown sources" or "Install unknown apps"

3. **Install the Application**
   - Open the downloaded APK file
   - Follow the installation instructions

### From Source (Developers)

1. **Clone the repository**

   ```bash
   git clone https://github.com/your-username/planime-mobileapp.git
   cd planime-mobileapp
   ```

2. **Open in Android Studio**

   - File > Open > Select project folder

3. **Sync dependencies**

   ```bash
   ./gradlew build
   ```

4. **Run the application**
   - Connect an Android device or use an emulator
   - Click "Run" or press `Shift + F10`

---

## 🌐 API Integration

The application connects to PlaniMe's RESTful API:

- **Authentication**: JWT for secure sessions
- **Plans**: Complete CRUD for nutrition plans
- **Progress**: Weight tracking and goal monitoring
- **Profile**: Personal information management

---

## ⚡ Performance Optimizations

- **Lazy Loading**: Deferred content loading
- **Local Caching**: Temporary data storage
- **Coroutines**: Efficient asynchronous operations
- **Compose**: Optimized UI rendering

---

## 📜 Available Scripts

```bash
# Build
./gradlew build              # Build the project
./gradlew assembleDebug      # Generate debug APK
./gradlew assembleRelease    # Generate release APK

# Testing
./gradlew test               # Run unit tests
./gradlew connectedAndroidTest  # Run instrumented tests

# Code Quality
./gradlew lint               # Run lint checks
./gradlew ktlintCheck        # Check Kotlin code style
```

---

## 📞 Contact

**Diego Magaña Álvarez**  
_Full-Stack Developer_

soydiegoo71@gmail.com | +52 445 105 9192

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/diego-magana-dev)

---

## 🌐 More Information

- **Web Version**: [https://planime.diecode.lat](https://planime.diecode.lat/index.html)
- **Contact**: [Contact Us](https://planime.diecode.lat/pages/contact/contactUs.html)

---

## 📄 License

© 2025 PlaniMe. All rights reserved.

This project is a personal portfolio project and is not licensed for public use, modification, or distribution.

---

## 🙏 Acknowledgments

- [Kotlin Documentation](https://kotlinlang.org/docs/home.html)
- [Jetpack Compose](https://developer.android.com/jetpack/compose)
- [Android Developers](https://developer.android.com/)
- [Material Design 3](https://m3.material.io/)
- [Retrofit](https://square.github.io/retrofit/)

---

<div align="center">

**Made with ❤️ and ☕**

⭐ Don't forget to give the project a star if you liked it! ⭐

**PlaniMe** - Revolutionizing personalized nutrition with mobile technology 🚀

</div>
