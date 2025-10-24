🇵🇪 Portal Ciudadano Electoral – Transparencia Electoral Ciudadana
Aplicación móvil desarrollada en Kotlin con Jetpack Compose que busca promover la transparencia electoral en el Perú.
Permite a los ciudadanos consultar información pública sobre candidatos al Congreso y la Presidencia , incluyendo historial político, denuncias, proyectos presentados y enlaces a fuentes oficiales como JNE, ONPE y el Congreso de la República .

El objetivo es fortalecer la confianza ciudadana y fomentar el voto informado , mediante una plataforma moderna, accesible y basada en datos verificables.

🎯 Objetivo General
Desarrollar una aplicación móvil que permita a los ciudadanos acceder a información pública y confiable sobre los candidatos, brindando una herramienta útil para fomentar la participación electoral consciente .

🎯 Objetivos específicos
Investigador y organizador de fuentes de datos oficiales (JNE, ONPE, Congreso, Poder Judicial).
Diseñar una interfaz atractiva y accesible en Figma .
Implementar la aplicación en Android Studio usando Kotlin + Jetpack Compose .
Simular o integrar datos reales de candidatos, denuncias y proyectos legislativos.
Permitir búsquedas y comparaciones entre candidatos.
👥 Equipo de Desarrollo
Rol	Nombre	Responsabilidades
👨‍💻 Líder Técnico	Emerson Flores Quispe	Estructura del proyecto, navegación y gestión de versiones.
🎨 Diseñadora UI/UX	Sunmi Casaño Suárez	Diseño visual en Figma, experiencia de usuario.
📄 Documentador / Tester	David Chumbile Tinco	Documentación técnica, pruebas funcionales.
🧰 Tecnologías utilizadas
Kotlin
Jetpack Compose
Estudio Android
Navegación Redactar
Figma
Git y GitHub
🛠️Funcionalidades Planeadas
🔍 Búsqueda de candidatos por nombre, partido o región.
👤 Perfil del candidato con historial político, denuncias y proyectos presentados.
📄 Detalle de denuncias o documentos , con fecha, institución y enlaces oficiales.
⚖️ Comparación entre candidatos (función adicional).
🔗 Enlaces directos a fuentes oficiales (JNE, Congreso, ONPE, etc).
🖼️ Prototipo en Figma
🔗 Ver prototipo en Figma

Incluye las siguientes pantallas:

Pantalla de Inicio
Búsqueda de Candidatos
Detalle del Candidato
Comparación
DÍA 2: Estructura Base del Proyecto y Navegación
El objetivo del Día 2 fue crear la base funcional del proyecto en Android Studio, establecer la estructura de carpetas (paquetes) y la navegación inicial, preparando el terreno para el desarrollo de funcionalidades.

✅ Requerimientos Funcionales Completos
IDENTIFICACIÓN	Requerimiento	Estado
RF06	Creación del proyecto en Android Studio (Kotlin + Jetpack Compose).	✔️
RF07	Definición de estructura por paquetes (modelo, datos, navegación, presentación).	✔️
RF08	Implementación de base de navegación (NavHost) entre Inicio, Detalle y Comparación.	✔️
RF09	Configuración de ramas de trabajo en GitHub para la colaboración.	✔️
RF10	Documentación de commits con mensajes claros.	✔️
📁 Estructura del Proyecto (RF07)
Se adoptó una estructura organizada, utilizando presentacionpara la capa de UI. ├── 📊 data/ ← Repositorios y lógica de datos (a desarrollar) ├── 🏛️ model/ ← Clases de datos (Candidato, Denuncia) (a desarrollar) ├── 🧭 navigation/ ← Lógica de NavHost y rutas (AppNavHost, AppScreen) ├── 📱 presentacion/ ← Capa de Interfaz de Usuario (UI) │ ├── 🧩 components/ ← Componentes reutilizables │ └── 🖥️ screens/ ← Pantallas principales (Inicio, Detalle, Comparación) └── 🎨 ui.theme/ ← Configuración de temas, colores y tipografía de Compose

🧭 Navegación Implementada (RF08)
Se configuró Navigation Compose y se agregaron las dependencias de Gradle necesarias para asegurar un flujo de navegación funcional entre las pantallas principales.

Ruta	Descripción
home	Pantalla principal.
candidate_detail	Muestra el perfil detallado.
comparison	Pantalla para la comparación directa entre candidatos.
🌳 Configuración de Git y Flujo Colaborativo (RF09)
Se ha realizado el commit final del Día 2 en mainy se han creado las ramas de características para que el equipo comience a trabajar en paralelo de cara al Día 3.

Rama de Trabajo	Rol Principal	Tareas Asignadas (Día 3)
main	Base estable	Contiene la estructura y la navegación funcional.
feature/ui-design-sunmi	🎨 Sunmi (Diseñadora UI/UX)	Implementación de los componentes de Jetpack Compose y el diseño visual basado en Figma.
feature/data-model-david	📄 David (Documentador / Tester)	Definición y creación de las clases de datos necesarias en el paquete model.
feature/refactor-emerson	👨‍💻 Emerson (Líder Técnico)	Tareas de limpieza de código y gestión de dependencias/configuraciones avanzadas.
📁 Estructura del Repositorio
Avances en la Ramadavid-home-screen
🧩 Implementaciones realizadas
Se creó la pantalla de Inicio (HomeScreen) según el diseño de Figma.
Se agregó una barra de búsqueda en la parte superior (aún sin funcionalidad completa).
Se implementaron íconos circulares de funciones destacadas :
Comparar candidatos (comparar perfiles y propuestas lado a lado).
Noticias.
Fuentes oficiales.
Se configuró la navegación en AppNavHost.ktcon rutas básicas hacia las vistas principales.
Se dejó preparado el espacio para la futura lista de candidatos.
Documentación y presentación final

✅ Entregables:

README.md completo con objetivos, equipo, tecnologías y estructura.
Prototipo en Figma vinculado al repositorio.
Aplicación funcional (v1.0) ejecutable en Android Studio.
Capturas de pantalla incluidas en el README.
Etiqueta de versión final creada en GitHub (v1.0).

🗣️ En la presentación se mostrará:
Búsqueda y visualización de candidatos.
Comparación entre candidatos, mostrando propuestas y denuncias.
Enlaces a fuentes oficiales simuladas (JNE, ONPE, Congreso).
Valor social de la aplicación: cómo fomenta un voto informado y transparente
