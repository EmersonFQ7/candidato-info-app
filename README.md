# 🇵🇪 Portal Ciudadano Electoral – Transparencia Electoral Ciudadana

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

## 📁 Estructura del Repositorio
---

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

---


