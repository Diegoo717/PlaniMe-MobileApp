# PlaniMe MobileApp 📱

Una aplicación Android nativa desarrollada en Kotlin con Jetpack Compose para la gestión de planes nutricionales personalizados, con arquitectura MVVM y rendimiento optimizado.

📦 **[Descargar APK](https://planime.diecode.lat/assets/downloads/PlaniMe_v1.0.apk)**

## 📋 Descripción

PlaniMe MobileApp es una aplicación Android nativa desarrollada en Kotlin con Jetpack Compose, diseñada para gestionar planes nutricionales personalizados mediante nuestra API RESTful. Implementa arquitectura MVVM, navegación entre pantallas, consumo de servicios con Retrofit y asincronía con Corrutinas, ofreciendo un rendimiento muy optimizado.

## 🚀 Características Principales

- ✅ **Planes Nutricionales**: Creación y gestión de planes alimenticios personalizados
- 📊 **Seguimiento de Progreso**: Monitoreo de peso y objetivos nutricionales
- 🔐 **Autenticación Segura**: Sistema de login y registro con JWT
- 📱 **UI Moderna**: Interfaz nativa con Jetpack Compose
- ⚡ **Alto Rendimiento**: Arquitectura MVVM con Corrutinas
- 🔄 **Sincronización**: Integración completa con API RESTful
- 🎨 **Experiencia Fluida**: Navegación intuitiva y animaciones suaves

## 🛠️ Tecnologías

### Desarrollo Android
- **Kotlin**: Lenguaje principal de desarrollo
- **Jetpack Compose**: UI toolkit moderno y declarativo
- **Material Design 3**: Sistema de diseño de Google

### Arquitectura
- **MVVM**: Model-View-ViewModel pattern
- **Clean Architecture**: Separación de responsabilidades
- **Repository Pattern**: Abstracción de fuentes de datos

### Librerías y Frameworks
- **Retrofit**: Cliente HTTP para consumo de API
- **Corrutinas**: Programación asíncrona
- **Navigation Component**: Navegación entre pantallas
- **ViewModel & LiveData**: Gestión de estado
- **SharedPreferences**: Almacenamiento local

## 📁 Estructura del Proyecto

```
PLANIME-MOBILEAPP/
│
├── manifests/                    # Configuración de la app
├── kotlin+java/
│
├── com.example.planime_mobileapp/
│   │
│   ├── data/                     # Capa de datos
│   │   ├── local/               # Almacenamiento local
│   │   ├── remote/              # Cliente API
│   │   └── repository/          # Repositorios
│   │
│   ├── domain/                   # Lógica de negocio
│   ├── model/                    # Modelos de datos
│   │   ├── auth/                # Modelos de autenticación
│   │   ├── plans/               # Modelos de planes
│   │   ├── profile/             # Modelos de perfil
│   │   └── progress/            # Modelos de progreso
│   │
│   ├── usecase/                  # Casos de uso
│   │   ├── auth/                # Casos de uso de auth
│   │   └── user/                # Casos de uso de usuario
│   │
│   ├── navigation/               # Navegación
│   │   ├── NavGraph.kt
│   │   └── routes/
│   │
│   └── ui/                       # Interfaz de usuario
│       ├── screens/             # Pantallas
│       │   ├── auth/            # Autenticación
│       │   ├── dashboard/       # Dashboard principal
│       │   ├── homescreen/      # Pantalla de inicio
│       │   ├── createplanscreen/ # Crear planes
│       │   ├── progressscreen/  # Seguimiento
│       │   └── userprofile/     # Perfil de usuario
│       │
│       ├── components/          # Componentes reutilizables
│       │   ├── cards/           # Tarjetas
│       │   ├── charts/          # Gráficos
│       │   ├── inputs/          # Campos de entrada
│       │   └── navigation/      # Navegación
│       │
│       └── theme/               # Tema y estilos
│
└── MainActivity.kt               # Actividad principal
```

## 🎯 Nuestra Misión

Empoderar a las personas para que alcancen sus objetivos de salud y bienestar a través de planes de nutrición personalizados que sean accesibles, efectivos y disfrutables.

## 🔮 Nuestra Visión

Revolucionar la forma en que las personas abordan la nutrición combinando tecnología de vanguardia con ciencia nutricional.

## 💎 Nuestros Valores

### Personalización
Creemos que no hay dos personas iguales, y sus planes de nutrición tampoco deberían serlo.

### Adaptabilidad
Aprendemos y nos ajustamos continuamente para ofrecerte las soluciones más efectivas.

### Simplicidad
Hacemos que la nutrición sea sencilla y accesible, eliminando la complejidad.

## 📱 Instalación

### Prerrequisitos
- Dispositivo Android con API nivel 24+ (Android 7.0)
- Espacio de almacenamiento: ~15 MB

### Instalación desde APK

1. **Descarga el APK**
   ```
   https://planime.diecode.lat/assets/downloads/PlaniMe_v1.0.apk
   ```

2. **Habilita fuentes desconocidas**
   - Ve a Configuración > Seguridad
   - Activa "Fuentes desconocidas" o "Instalar apps desconocidas"

3. **Instala la aplicación**
   - Abre el archivo APK descargado
   - Sigue las instrucciones de instalación

### Desarrollo

#### Prerrequisitos para desarrollo
- Android Studio Arctic Fox o superior
- JDK 11 o superior
- Android SDK API 33+
- Kotlin 1.8+

#### Configuración del proyecto

1. **Clona el repositorio**
   ```bash
   git clone https://github.com/tu-usuario/planime-mobileapp.git
   cd planime-mobileapp
   ```

2. **Abre en Android Studio**
   - File > Open > Selecciona la carpeta del proyecto

3. **Sincroniza dependencias**
   ```bash
   ./gradlew build
   ```

4. **Ejecuta la aplicación**
   - Conecta un dispositivo Android o usa un emulador
   - Click en "Run" o `Shift + F10`

## 🌐 Integración con Backend

La aplicación se conecta con la API RESTful de PlaniMe:
- **Autenticación**: JWT para sesiones seguras
- **Planes**: CRUD completo de planes nutricionales
- **Progreso**: Seguimiento de peso y objetivos
- **Perfil**: Gestión de información personal

## ⚡ Rendimiento

### Optimizaciones implementadas
- **Lazy Loading**: Carga perezosa de contenido
- **Cacheo Local**: Almacenamiento temporal de datos
- **Corrutinas**: Operaciones asíncronas eficientes
- **Compose**: Renderizado optimizado de UI

## 🔧 Arquitectura MVVM

```kotlin
View (Compose) ↔ ViewModel ↔ Repository ↔ API/Local Storage
```

- **View**: Composables de Jetpack Compose
- **ViewModel**: Lógica de presentación y estado
- **Repository**: Abstracción de fuentes de datos
- **Data Sources**: API remota y almacenamiento local

## 👨‍💻 Desarrollador

**Ing. Diego Magaña Álvarez**
- **Rol**: Arquitecto y Desarrollador Full-Stack
- **Experiencia**: 3+ años en el ciclo completo de desarrollo de aplicaciones web/móviles y sistemas escalables
- **Enfoque en el proyecto**: 
  - Desarrollo Android nativo con Kotlin
  - Arquitectura MVVM y Clean Architecture
  - Jetpack Compose y Material Design
  - Integración de APIs RESTful
  - Optimización de rendimiento móvil
- **Contacto**: [soydiegoo71@gmail.com](mailto:soydiegoo71@gmail.com)

## 🌐 Más Información

- **Versión Web**: [https://planime.diecode.lat/index.html](https://planime.diecode.lat/index.html)
- **Contacto**: [https://planime.diecode.lat/pages/contact/contactUs.html](https://planime.diecode.lat/pages/contact/contactUs.html)

## 🆘 Soporte

¿Necesitas ayuda? Puedes:
- Crear un [issue](https://github.com/tu-usuario/planime-mobileapp/issues) en GitHub
- Contactar al desarrollador: [soydiegoo71@gmail.com](mailto:soydiegoo71@gmail.com)
- Visitar nuestra página de [contacto](https://planime.diecode.lat/pages/contact/contactUs.html)

---

⭐ Si te gusta este proyecto, ¡no olvides darle una estrella!

**PlaniMe** - Revolucionando la nutrición personalizada con tecnología móvil 🚀
