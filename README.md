Candidato-Info – Portal Ciudadano Electoral del Perú
Aplicación móvil desarrollada en Kotlin con Jetpack Compose que busca promover la transparencia electoral en el Perú.
 Permite a los ciudadanos consultar información pública sobre candidatos al Congreso y la Presidencia, incluyendo historial político, denuncias, proyectos presentados y enlaces a fuentes oficiales como JNE, ONPE y el Congreso de la República.
Valor social: La app fortalece la confianza ciudadana y fomenta el voto informado mediante una plataforma moderna, accesible y basada en datos verificables.
🎯 Objetivo General
Desarrollar una aplicación móvil que permita a los ciudadanos acceder a información pública y confiable sobre los candidatos, brindando una herramienta útil para fomentar la participación electoral consciente.
🎯 Objetivos específicos
Investigar y organizar fuentes de datos oficiales (JNE, ONPE, Congreso, Poder Judicial).


Diseñar una interfaz atractiva y accesible en Figma.


Implementar la aplicación en Android Studio usando Kotlin + Jetpack Compose.


Simular o integrar datos reales de candidatos, denuncias y proyectos legislativos.


Permitir búsquedas y comparaciones entre candidatos.










👥 Equipo de Desarrollo:

Rol
Nombre
Responsabilida
Líder Técnico
Emerson Flores Quispe
Estructura del proyecto, navegación y gestión de versiones.
Diseñadora UI/UX
Sunmi Casaño Suárez
Diseño visual en Figma y maquetado de la interfaz.
Documentador / Tester
David Chumbile Tinco 
Documentación técnica, pruebas funcionales, apoyo en las presentación de la app 


🧰 Tecnologías utilizadas
Kotlin


Jetpack Compose


Android Studio


Navigation Compose


Figma


Git y GitHub
🛠️ Funcionalidades implementadas
🔍 Búsqueda de candidatos por nombre, partido o región.


👤 Perfil detallado del candidato con historial político, denuncias y proyectos.


📄 Detalle de denuncias y documentos con fecha, institución y enlaces oficiales.


⚖️ Comparación entre candidatos (lado a lado).


🔗 Enlaces directos a fuentes oficiales (JNE, Congreso, ONPE).



🖼️ Capturas de pantalla de la app




























































































🔗 Prototipo en Figma
https://www.figma.com/make/C0julpMVtw3s3yjY2ijKE3/Pantallas-de-Candidatos?node-id=0-1&t=QUqLi6wWRlVKHUnc-1

📎 Fuentes de datos oficiales
JNE: https://declara.jne.gob.pe/


ONPE: https://www.onpe.gob.pe/


Congreso del Perú: https://www.congreso.gob.pe/



🗂️ Estructura del proyecto
📦 com.tecsup.candidato_info_app
 ├──  data/             ← Capa de datos (fuentes y modelos)
 │    ├── datasource/     ← LocalDataSource.kt (provee los datos de ejemplo)
 │    └── model/          ← Candidato.kt, Proyecto.kt, etc.
 ├── presentacion/     ← Capa de presentación (UI y lógica de pantallas)
 │    ├── screens/        ← ComparisonScreen.kt (pantalla de comparación)
 │    └── viewmodel/      ← ComparisonViewModel.kt (manejo de estado)
 └── ui.theme/         ← Configuración de colores, temas y tipografía

🧭 Navegación implementada


RUTA
DESCRIPCIÓN
home 
página principal
candidate detail
Perfil detallado del candidato
Comparison
Comparacion entre Candidatos
official sources
Enlaces oficiales (JNE, ONPE, Congreso)
candidate search
Búsqueda de candidatos por nombre, partido o región



📦 Versión final
Versión: v1.0 (Release)
Estado: Aplicación funcional con navegación, interfaz visual y simulación de datos.



🗣️ Presentación final
Durante la presentación se mostrará:
La búsqueda de candidatos y visualización del perfil detallado.


La comparación entre candidatos, mostrando propuestas y denuncias.


La integración de datos oficiales simulados, demostrando la veracidad de la información.


La importancia del valor social de la app, destacando cómo ayuda al ciudadano a tomar decisiones de voto informadas.






