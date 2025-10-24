# 🇵🇪 Portal Ciudadano Electoral – Transparencia Electoral Ciudadana

## 👥 Integrantes del Equipo

 **Emerson Flores Quispe**  
 **Sunmi Casaño Suarez**  
 **David Chumbile Tinco**

 
## 🧩 Descripción General del Proyecto

Aplicación móvil desarrollada en **Kotlin** con **Jetpack Compose** que busca promover la **transparencia electoral** en el Perú.  
Permite a los ciudadanos consultar información pública sobre **candidatos al Congreso y la Presidencia**, incluyendo historial político, denuncias, proyectos presentados y enlaces a fuentes oficiales como **JNE, ONPE** y el **Congreso de la República**.

El objetivo es **fortalecer la confianza ciudadana** y fomentar el **voto informado**, mediante una plataforma moderna, accesible y basada en datos verificables.

---

## 🎯 Objetivo General

Desarrollar una aplicación móvil que permita a los ciudadanos acceder a información pública y confiable sobre los candidatos, brindando una herramienta útil para fomentar la **participación electoral consciente**.

---

## 🎯 Objetivos Específicos

- Investigar y organizar fuentes de datos oficiales (JNE, ONPE, Congreso, Poder Judicial).
- Diseñar una interfaz atractiva y accesible en **Figma**.
- Implementar la app en **Android Studio** usando **Kotlin + Jetpack Compose**.
- Simular o integrar datos reales de candidatos, denuncias y proyectos legislativos.
- Permitir búsquedas y comparaciones entre candidatos.

---

## 👥 Equipo de Desarrollo

| Rol                  | Nombre                     | Responsabilidades                                           |
|----------------------|----------------------------|-------------------------------------------------------------|
| 👨‍💻 Líder Técnico       | Emerson Flores Quispe       | Estructura del proyecto, navegación y gestión de versiones. |
| 🎨 Diseñadora UI/UX     | Sunmi Casaño Suarez         | Diseño visual en Figma, experiencia de usuario.             |
| 📄 Documentador / Tester | David Chumbile Tinco         | Documentación técnica, pruebas funcionales.                 |

---

## 🧰 Tecnologías Utilizadas

- **Kotlin**
- **Jetpack Compose**
- **Android Studio**
- **Navigation Compose**
- **Figma**
- **Git & GitHub**

---

## 🛠️ Funcionalidades Planeadas

- 🔍 **Búsqueda de candidatos** por nombre, partido o región.
- 👤 **Perfil del candidato** con historial político, denuncias y proyectos presentados.
- 📄 **Detalle de denuncias o documentos**, con fecha, institución y enlaces oficiales.
- ⚖️ **Comparación entre candidatos** (función adicional).
- 🔗 **Enlaces directos** a fuentes oficiales (JNE, Congreso, ONPE, etc).

---

## 🖼️ Prototipo en Figma

> 🔗 [Ver prototipo en Figma](https://www.figma.com/make/C0julpMVtw3s3yjY2ijKE3/Pantallas-de-Candidatos?node-id=0-1&p=f&t=9W26pQYKPRslRZhG-0&fullscreen=1)

Incluye las siguientes pantallas:
- Pantalla de Inicio
- Búsqueda de Candidatos
- Detalle del Candidato
- Comparación

---
# DÍA 2: Estructura Base del Proyecto y Navegación

El objetivo del Día 2 fue crear la base funcional del proyecto en Android Studio, establecer la estructura de carpetas (paquetes) y la navegación inicial, preparando el terreno para el desarrollo de funcionalidades.

## ✅ Requerimientos Funcionales Completados

| ID | Requerimiento | Estado |
|----|---------------|---------|
| RF06 | Creación del proyecto en Android Studio (Kotlin + Jetpack Compose). | ✔️ |
| RF07 | Definición de estructura por paquetes (model, data, navigation, presentacion). | ✔️ |
| RF08 | Implementación de navegación base (NavHost) entre Home, Detail y Comparison. | ✔️ |
| RF09 | Configuración de ramas de trabajo en GitHub para la colaboración. | ✔️ |
| RF10 | Documentación de commits con mensajes claros. | ✔️ |

## 📁 Estructura del Proyecto (RF07)

Se adoptó una estructura organizada, utilizando `presentacion` para la capa de UI.
├── 📊 `data/`               *← Repositorios y lógica de datos (a desarrollar)*
├── 🏛️ `model/`              *← Clases de datos (Candidato, Denuncia) (a desarrollar)*
├── 🧭 `navigation/`         *← Lógica de NavHost y rutas (AppNavHost, AppScreen)*
├── 📱 `presentacion/`       *← Capa de Interfaz de Usuario (UI)*
│   ├── 🧩 `components/`     *← Componentes reutilizables*
│   └── 🖥️ `screens/`        *← Pantallas principales (Home, Detail, Comparison)*
└── 🎨 `ui.theme/`           *← Configuración de temas, colores y tipografía de Compose*

## 🧭 Navegación Implementada (RF08)

Se configuró Navigation Compose y se añadieron las dependencias de Gradle necesarias para asegurar un flujo de navegación funcional entre las pantallas principales.

| Ruta | Descripción |
|------|-------------|
| `home` | Pantalla principal. |
| `candidate_detail` | Muestra el perfil detallado. |
| `comparison` | Pantalla para la comparación directa entre candidatos. |


## 🌳 Configuración de Git y Flujo Colaborativo (RF09)

Se ha realizado el commit final del Día 2 en `main` y se han creado las ramas de features para que el equipo comience a trabajar en paralelo de cara al Día 3.

| Rama de Trabajo | Rol Principal | Tareas Asignadas (Día 3) |
|-----------------|---------------|--------------------------|
| `main` | Base Estable | Contiene la estructura y la navegación funcional. |
| `feature/ui-design-sunmi` | 🎨 Sunmi (Diseñadora UI/UX) | Implementación de los componentes de Jetpack Compose y el diseño visual basado en Figma. |
| `feature/data-model-david` | 📄 David (Documentador / Tester) | Definición y creación de las data classes necesarias en el paquete `model`. |
| `feature/refactor-emerson` | 👨‍💻 Emerson (Líder Técnico) | Tareas de limpieza de código y gestión de dependencias/configuraciones avanzadas. |

## 🖌️ DÍA 3 – Interfaz de Usuario (UI)  

##  Avances en la Rama `david-home-screen`

### 🧩 Implementaciones realizadas
- Se creó la **pantalla de Inicio (HomeScreen)** según el diseño del Figma.
- Se añadió una **barra de búsqueda** en la parte superior (aún sin funcionalidad completa).
- Se implementaron **íconos circulares de funciones destacadas**:
    - Comparar candidatos (comparar perfiles y propuestas lado a lado).
    -  Noticias.
    -  Fuentes oficiales.
- Se configuró la navegación en `AppNavHost.kt` con rutas básicas hacia las vistas principales.
- Se dejó preparado el espacio para la futura lista de candidatos.

### 🚀 Próximos pasos
- Implementar la pantalla **Búsqueda de Candidatos**.
- Conectar la barra de búsqueda con la navegación.
- Añadir navegación funcional a los íconos de “Funciones destacadas”.


Durante este día se trasladó el diseño del prototipo en Figma al entorno de desarrollo, implementando las pantallas principales con **Material Design 3**.  
Se creó la **pantalla de inicio**, la **lista de candidatos** y la **vista de detalle**, asegurando coherencia visual y navegación fluida.  

✅ **Requerimientos completados:**
- RF11: Pantalla de inicio con barra de búsqueda.  
- RF12: Lista de candidatos (nombre, partido, foto, cargo).  
- RF13: Detalle del candidato con información estructurada.  
- RF14: Aplicación de Material 3.  
- RF15: Navegación lista → detalle.  

---

## 🧩 DÍA 4 – Lógica y Manejo de Datos

Se implementó la lógica de datos bajo el patrón **MVVM**, incorporando modelos como `Candidato`, `Proyecto` y `Denuncia`.  
Los datos se cargan desde una **fuente local (JSON/lista simulada)**, mostrando en pantalla información de proyectos y denuncias vinculadas a cada candidato.  

✅ **Requerimientos completados:**
- RF16: Creación de modelos de datos.  
- RF17: Fuente local de datos simulados.  
- RF18: Mostrar proyectos y denuncias en detalle.  
- RF19: Enlaces a fuentes oficiales.  
- RF20: Lógica dentro del ViewModel.  

---

## ⚙️ DÍA 5 – Funcionalidades Complementarias e Integración

En esta etapa se añadieron las funcionalidades avanzadas: **búsqueda por nombre, partido o región**, y la **comparación de candidatos**.  
También se implementaron **indicadores visuales de denuncias y proyectos activos**, así como manejo de errores y pruebas de integración.  

✅ **Requerimientos completados:**
- RF21: Búsqueda avanzada.  
- RF22: Comparador de candidatos.  
- RF23: Indicadores visuales.  
- RF24: Manejo de errores (sin conexión o datos vacíos).  
- RF25: Pruebas e integración final.  

---

## 📘 DÍA 6 – Documentación y Presentación Final

Se completó la documentación del proyecto, el archivo **README.md**, las pruebas finales en emulador y la **etiqueta de versión v1.0** en GitHub.  
Se preparó la presentación final del producto sin errores de compilación.  

✅ **Requerimientos completados:**
- RF26: README completo con descripción, integrantes y fuentes.  
- RF27: Ejecución validada en emulador/dispositivo.  
- RF28: Versión v1.0 en GitHub.  
- RF29: Presentación lista.  
- RF30: App funcional y sin errores.  

---

## 🧾 Fuentes de Datos Oficiales
- [Jurado Nacional de Elecciones (JNE)](https://www.jne.gob.pe)  
- [Oficina Nacional de Procesos Electorales (ONPE)](https://www.onpe.gob.pe)  
- [Congreso de la República del Perú](https://www.congreso.gob.pe)  
- [Poder Judicial del Perú](https://www.pj.gob.pe)

## 🖼️ Galería de Funcionalidades

*(Imágenes ilustrativas del prototipo y la app en ejecución)*  

---

### 🏠 Pantalla de Inicio
![Pantalla de Inicio](./images/app_home.png)

---

### 🔎 Búsqueda de Candidatos
![Búsqueda de Candidatos](./images/app_search.png)

---

### 👤 Detalle del Candidato
![Detalle del Candidato](./images/app_detail.png)

---

### ⚖️ Comparación de Candidatos
![Comparación de Candidatos](./images/app_comparison.png)

---

