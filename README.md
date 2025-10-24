# 🇵🇪 Portal Ciudadano Electoral – Transparencia Electoral Ciudadana  

Aplicación móvil desarrollada en **Kotlin con Jetpack Compose** que busca promover la transparencia electoral en el Perú.  
Permite a los ciudadanos consultar información pública sobre candidatos al Congreso y la Presidencia, incluyendo historial político, denuncias, proyectos presentados y enlaces a fuentes oficiales como **JNE, ONPE y el Congreso de la República**.

El objetivo es fortalecer la confianza ciudadana y fomentar el voto informado, mediante una plataforma moderna, accesible y basada en datos verificables.

---

## 🎯 Objetivo General  
Desarrollar una aplicación móvil que permita a los ciudadanos acceder a información pública y confiable sobre los candidatos, brindando una herramienta útil para fomentar la participación electoral consciente.

---

## 🎯 Objetivos Específicos  
- Investigar y organizar fuentes de datos oficiales (JNE, ONPE, Congreso, Poder Judicial).  
- Diseñar una interfaz atractiva y accesible en Figma.  
- Implementar la aplicación en Android Studio usando **Kotlin + Jetpack Compose**.  
- Simular o integrar datos reales de candidatos, denuncias y proyectos legislativos.  
- Permitir búsquedas y comparaciones entre candidatos.

---

## 👥 Equipo de Desarrollo  

| Rol | Nombre | Responsabilidades |
|------|---------|------------------|
| 👨‍💻 **Líder Técnico** | Emerson Flores Quispe | Estructura del proyecto, navegación y gestión de versiones |
| 🎨 **Diseñadora UI/UX** | Sunmi Casaño Suárez | Diseño visual en Figma, experiencia de usuario |
| 📄 **Documentador / Tester** | David Chumbile Tinco | Documentación técnica, pruebas funcionales |

---

## 🧰 Tecnologías utilizadas  
- **Kotlin**  
- **Jetpack Compose**  
- **Android Studio**  
- **Navegación Compose**  
- **Figma**  
- **Git y GitHub**

---

## 🛠️ Funcionalidades Planeadas  
- 🔍 **Búsqueda de candidatos** por nombre, partido o región.  
- 👤 **Perfil del candidato** con historial político, denuncias y proyectos presentados.  
- 📄 **Detalle de denuncias o documentos**, con fecha, institución y enlaces oficiales.  
- ⚖️ **Comparación entre candidatos** (función adicional).  
- 🔗 **Enlaces directos** a fuentes oficiales (JNE, Congreso, ONPE, etc.).  

---

## 🎨 Prototipo en Figma  
<!-- 🧩 Primer diseño -->
[🎨 Ver primer diseño en Figma](https://www.figma.com/make/C0julpMVtw3s3yjY2ijKE3/Pantallas-de-Candidatos?node-id=0-1&p=f&t=HyVoKzs0t08fjIJc-0&fullscreen=1)

<!-- 🧪 Segundo diseño -->
[🚀 Ver segundo diseño en Figma](https://www.figma.com/design/K1EjueCz6jtLO8emF0Gim8/ProyectoLAB_Grupal?node-id=0-1&t=IwwdivRk3ZXAnIw4-1)


Incluye las siguientes pantallas:
- Pantalla de Inicio  
- Búsqueda de Candidatos  
- Detalle del Candidato  
- Comparación  

---

##  Estructura Base del Proyecto y Navegación  

El objetivo del Día 2 fue crear la base funcional del proyecto en Android Studio, establecer la estructura de carpetas (paquetes) y la navegación inicial, preparando el terreno para el desarrollo de funcionalidades.

---

## ✅ Requerimientos Funcionales Completos  

| Identificación | Requerimiento | Estado |
|----------------|----------------|--------|
| RF06 | Creación del proyecto en Android Studio (Kotlin + Jetpack Compose) | ✔️ |
| RF07 | Definición de estructura por paquetes (modelo, datos, navegación, presentación) | ✔️ |
| RF08 | Implementación de base de navegación (NavHost) entre Inicio, Detalle y Comparación | ✔️ |
| RF09 | Configuración de ramas de trabajo en GitHub para la colaboración | ✔️ |
| RF10 | Documentación de commits con mensajes claros | ✔️ |

---

## 📁 Estructura del Proyecto (RF07)

Se adoptó una estructura organizada, utilizando **presentacion** para la capa de UI.  
├── 📊 data/ ← Repositorios y lógica de datos (a desarrollar)
├── 🏛️ model/ ← Clases de datos (Candidato, Denuncia) (a desarrollar)
├── 🧭 navigation/ ← Lógica de NavHost y rutas (AppNavHost, AppScreen)
├── 📱 presentacion/ ← Capa de Interfaz de Usuario (UI)
│ ├── 🧩 components/ ← Componentes reutilizables
│ └── 🖥️ screens/ ← Pantallas principales (Inicio, Detalle, Comparación)
└── 🎨 ui.theme/ ← Configuración de temas, colores y tipografía de Compose


---

## 🧭 Navegación Implementada (RF08)

Se configuró **Navigation Compose** y se agregaron las dependencias de Gradle necesarias para asegurar un flujo de navegación funcional entre las pantallas principales.

| Ruta | Descripción |
|------|--------------|
| `home` | Pantalla principal |
| `candidate_detail` | Muestra el perfil detallado |
| `comparison` | Pantalla para la comparación directa entre candidatos |

---

## 🌳 Configuración de Git y Flujo Colaborativo (RF09)


| Rama de Trabajo | Rol Principal | Tareas Asignadas (Día 3) |
|-----------------|----------------|---------------------------|
| `main` | Base estable | Contiene la estructura y la navegación funcional |
| `feature/ui-design-sunmi` | 🎨 Sunmi (Diseñadora UI/UX) | Implementación de componentes de Jetpack Compose y diseño visual basado en Figma |
| `feature/data-model-david` | 📄 David (Documentador / Tester) | Definición y creación de las clases de datos necesarias en el paquete `model` |
| `feature/refactor-emerson` | 👨‍💻 Emerson (Líder Técnico) | Limpieza de código y gestión de dependencias/configuraciones avanzadas |

---

## 📁 Estructura del Repositorio  

### Avances en la Rama `david-home-screen`

#### 🧩 Implementaciones realizadas  
- Se creó la **pantalla de Inicio (HomeScreen)** según el diseño de Figma.  
- Se agregó una **barra de búsqueda** en la parte superior (aún sin funcionalidad completa).  
- Se implementaron **íconos circulares** de funciones destacadas:  
  - Comparar candidatos (comparar perfiles y propuestas lado a lado).  
  - Noticias.  
  - Fuentes oficiales.  
- Se configuró la **navegación en `AppNavHost.kt`** con rutas básicas hacia las vistas principales.  
- Se dejó preparado el espacio para la futura lista de candidatos.  
---

## Resultados del Día 3
- Se completó la navegación total entre las pantallas principales.  
- Se finalizó la conexión de la barra de búsqueda con la navegación.  
- Se ajustaron las rutas de `AppScreen` y la estructura del paquete `navigation`.  
- El proyecto se encuentra **completamente sincronizado entre ramas**.  
- Se realizaron pruebas funcionales básicas confirmando la correcta interacción entre vistas.

## 🚀 Avances del Día 4 – Lógica y Manejo de Datos

**Objetivo:** Integrar datos simulados o reales en la aplicación.

### ✅ Requerimientos cumplidos
- **RF16:** Se crearon los modelos de datos: `Candidate`, `Project`, y `Complaint`.
- **RF17:** Se implementó una **fuente de datos local simulada (JSON / lista estática)**.
- **RF18:** La **pantalla de detalle** muestra correctamente los proyectos y denuncias del candidato.
- **RF19:** Se agregaron **enlaces oficiales** (Congreso, ONPE, JNE) dentro de los detalles del perfil.
- **RF20:** La **lógica de datos** se maneja a través del `ViewModel` y repositorios, garantizando separación de capas.

### 🧠 Resultado
El sistema ahora carga información realista de candidatos, sus proyectos y denuncias, permitiendo una navegación dinámica y fluida entre pantallas.


---

## ⚙️ Avances del Día 5 – Funcionalidades Finales e Integración

**Objetivo:** Agregar funciones avanzadas de búsqueda y comparación de candidatos.

### ✅ Requerimientos cumplidos
- **RF21:** Implementada la **búsqueda por nombre, partido o región.**
- **RF22:** Creada la **pantalla de comparación** entre dos candidatos, mostrando datos en paralelo.
- **RF23:** Se muestran **indicadores visuales** de denuncias y proyectos activos.
- **RF24:** Se gestionan **mensajes de error** y estados vacíos con componentes de Compose.
- **RF25:** Pruebas funcionales y corrección de bugs antes de la entrega final.

### 🧩 Resultado
La app permite comparar perfiles, navegar entre candidatos y consultar datos de forma estable, cumpliendo todos los objetivos funcionales.


---

## 🏁 Día 6 – Documentación y Presentación Final

**Objetivo:** Entregar la versión final funcional y documentada del proyecto.

### ✅ Requerimientos cumplidos
- **RF26:** Se completó el `README.md` con descripción, integrantes, capturas y fuentes de datos.
- **RF27:** Verificación de ejecución en emulador y dispositivo físico.
- **RF28:** Etiquetado de versión **v1.0 (Release)** en GitHub.
- **RF29:** Preparada la presentación mostrando las funcionalidades principales.
- **RF30:** Aplicación entregada sin errores de compilación.

---

## 🏆 Estado Final del Proyecto

**Versión:** v1.0  
**Estado:** ✅ Completamente funcional  
**Características principales:**
- Navegación dinámica entre pantallas.
- Integración de datos simulados.
- Comparador de candidatos.
- Enlaces oficiales activos.
- Interfaz fiel al diseño Figma (Material 3).  

---

## 🎥 Presentación Final

Durante la exposición se mostró:
- La búsqueda y visualización de candidatos.
- El detalle con historial político y denuncias.
- La comparación entre dos candidatos.
- La relevancia social del proyecto como herramienta de voto informado.

##  📑 Documentación

Toda la documentación completa del proyecto, incluyendo planificación, estructura, capturas de pantalla y presentación final, se encuentra en el siguiente documento:

📎 https://docs.google.com/document/d/1we3Xm8klt0M5By51S4AmOgkYlhNUYYGnnTD52eeluCM/edit?usp=sharing
