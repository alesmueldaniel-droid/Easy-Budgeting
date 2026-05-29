# Easy Budgeting

Android app untuk tracking pengeluaran harian, bulanan, dan tahunan dengan mudah.

## Fitur
- 📊 Track pengeluaran harian, bulanan, dan tahunan
- 💰 Bandingkan budget vs actual spending
- 📈 Visualisasi data dengan chart
- 🏷️ Kategori pengeluaran
- 📱 UI modern dengan Material 3
- 💾 Penyimpanan data lokal dengan Room Database

## Tech Stack
- **Language**: Kotlin
- **UI Framework**: Jetpack Compose + Material 3
- **Database**: Room Database (SQLite)
- **Architecture**: MVVM
- **Dependency Injection**: Hilt
- **Async**: Kotlin Coroutines

## Project Structure
```
app/
├── src/main/
│   ├── java/com/example/easybudgeting/
│   │   ├── data/
│   │   │   ├── database/
│   │   │   ├── repository/
│   │   │   └── model/
│   │   ├── ui/
│   │   │   ├── screens/
│   │   │   ├── components/
│   │   │   └── theme/
│   │   ├── viewmodel/
│   │   └── MainActivity.kt
│   └── res/
├── build.gradle.kts
└── AndroidManifest.xml
```

## Getting Started
1. Clone repository
2. Buka dengan Android Studio
3. Sync Gradle
4. Run di emulator atau device

## Development
- Main branch: production-ready code
- Feature branches: untuk fitur baru
- Pull requests: untuk code review
