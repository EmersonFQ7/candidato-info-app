package com.tecsup.candidato_info_app.data.datasource


import com.tecsup.candidato_info_app.data.model.*
import com.tecsup.candidato_info_app.R

object LocalDataSource {

    private val proyectos1 = listOf(
        Proyecto(
            id = "p1",
            nombre = "Plan Maestro de Desarrollo Urbano",
            descripcion = "Modernización de infraestructura urbana",
            estado = "Plan",
            fechaInicio = "2024",
            fechaFin = "2026"
        ),
        Proyecto(
            id = "p2",
            nombre = "Carretera Interoceanica Regional",
            descripcion = "Conexión vial entre regiones",
            estado = "En Proceso",
            fechaInicio = "2023",
            fechaFin = "2025"
        ),
        Proyecto(
            id = "p3",
            nombre = "Sistema de Agua Potable Rural",
            descripcion = "Acceso a agua potable en zonas rurales",
            estado = "Completado",
            fechaInicio = "2020",
            fechaFin = "2023"
        )
    )

    private val historialPolitico1 = listOf(
        HistorialPolitico(
            id = "h1",
            cargo = "Regidora Municipal de San Isidro",
            institucion = "Municipalidad de San Isidro",
            fechaInicio = "2015",
            fechaFin = "2018",
            descripcion = "Gestión municipal y desarrollo local"
        ),
        HistorialPolitico(
            id = "h2",
            cargo = "Asesora del Ministerio de Educación",
            institucion = "Ministerio de Educación",
            fechaInicio = "2019",
            fechaFin = "2021",
            descripcion = "Políticas educativas nacionales"
        ),
        HistorialPolitico(
            id = "h3",
            cargo = "Congresista de la República",
            institucion = "Congreso de la República",
            fechaInicio = "2021",
            fechaFin = "Presente",
            descripcion = "Representación legislativa"
        )
    )

    private val denuncias1 = listOf(
        Denuncia(
            id = "d1",
            tipo = "Investigación",
            titulo = "Investigación por presunto conflicto de intereses",
            descripcion = "Investigación administrativa en curso",
            fecha = "2019",
            estado = "En proceso",
            institucion = "Fiscalía Especializada"
        )
    )

    private val fuentesOficiales1 = listOf(
        FuenteOficial(
            id = "f1",
            nombre = "ONPE",
            url = "https://www.onpe.gob.pe",
            tipo = "ONPE",
            descripcion = "Oficina Nacional de Procesos Electorales"
        ),
        FuenteOficial(
            id = "f2",
            nombre = "Congreso de la República",
            url = "https://www.congreso.gob.pe",
            tipo = "Congreso",
            descripcion = "Portal del Congreso"
        )
    )

    private val candidato1 = Candidato(
        id = "c1",
        nombre = "María Elena Rodríguez Vargas",
        cargo = "Congresista",
        partido = "Alianza para el Progreso",
        region = "Lima",
        ciudad = "Lima",
        fotoUrl = "https://via.placeholder.com/200",
        descripcion = "Profesional con experiencia en gestión pública y desarrollo social",
        proyectos = proyectos1,
        historialPolitico = historialPolitico1,
        denuncias = denuncias1,
        fuentesOficiales = fuentesOficiales1,
        tieneInvestigaciones = true,
        tieneDenuncias = false
    )

    private val proyectos2 = listOf(
        Proyecto(
            id = "p4",
            nombre = "Reforma Tributaria Progresiva",
            descripcion = "Sistema tributario más equitativo",
            estado = "Plan",
            fechaInicio = "2024",
            fechaFin = null
        ),
        Proyecto(
            id = "p5",
            nombre = "Programa de Vivienda Social",
            descripcion = "Acceso a vivienda para sectores vulnerables",
            estado = "En Proceso",
            fechaInicio = "2022",
            fechaFin = "2025"
        ),
        Proyecto(
            id = "p6",
            nombre = "Hospitales Modulares en Zonas Alejadas",
            descripcion = "Infraestructura sanitaria descentralizada",
            estado = "Completado",
            fechaInicio = "2021",
            fechaFin = "2023"
        )
    )

    private val historialPolitico2 = listOf(
        HistorialPolitico(
            id = "h4",
            cargo = "Empresario del sector construcción",
            institucion = "Sector Privado",
            fechaInicio = "2010",
            fechaFin = "2018",
            descripcion = "Gestión empresarial"
        ),
        HistorialPolitico(
            id = "h5",
            cargo = "Gobernador Regional",
            institucion = "Gobierno Regional",
            fechaInicio = "2019",
            fechaFin = "2022",
            descripcion = "Administración regional"
        ),
        HistorialPolitico(
            id = "h6",
            cargo = "Candidato a Alcalde Provincial",
            institucion = "Municipalidad Provincial",
            fechaInicio = "2026",
            fechaFin = null,
            descripcion = "Candidatura actual"
        )
    )

    private val denuncias2 = listOf(
        Denuncia(
            id = "d2",
            tipo = "Denuncia",
            titulo = "Denuncia por nepotismo",
            descripcion = "Presunta contratación de familiares",
            fecha = "2017",
            estado = "Archivada por falta de pruebas",
            institucion = "Fiscalía Provincial"
        ),
        Denuncia(
            id = "d3",
            tipo = "Investigación",
            titulo = "Investigación administrativa",
            descripcion = "Investigación en curso",
            fecha = "2018",
            estado = "Sobreseída",
            institucion = "Contraloría General"
        )
    )

    private val fuentesOficiales2 = listOf(
        FuenteOficial(
            id = "f3",
            nombre = "ONPE",
            url = "https://www.onpe.gob.pe",
            tipo = "ONPE",
            descripcion = "Oficina Nacional de Procesos Electorales"
        ),
        FuenteOficial(
            id = "f4",
            nombre = "Poder Judicial",
            url = "https://www.pj.gob.pe",
            tipo = "Poder Judicial",
            descripcion = "Sistema Judicial Peruano"
        )
    )

    private val candidato2 = Candidato(
        id = "c2",
        nombre = "Carlos Alberto Mendoza Silva",
        cargo = "Alcalde Provincial",
        partido = "Fuerza Popular",
        region = "Arequipa",
        ciudad = "Arequipa",
        fotoUrl = "https://via.placeholder.com/200",
        descripcion = "Empresario con experiencia en gestión pública y desarrollo regional",
        proyectos = proyectos2,
        historialPolitico = historialPolitico2,
        denuncias = denuncias2,
        fuentesOficiales = fuentesOficiales2,
        tieneInvestigaciones = false,
        tieneDenuncias = true
    )

    private val candidatos = listOf(
        candidato1,
        candidato2,
        Candidato(
            id = "c3",
            nombre = "Jorge Luis Sánchez Prado",
            cargo = "Gobernador Regional",
            partido = "Acción Popular",
            region = "La Libertad",
            ciudad = "Trujillo",
            fotoUrl = "https://via.placeholder.com/200",
            descripcion = "Profesional en administración pública",
            proyectos = emptyList(),
            historialPolitico = emptyList(),
            denuncias = emptyList(),
            fuentesOficiales = emptyList(),
            tieneInvestigaciones = false,
            tieneDenuncias = false
        ),

        Candidato(
            id = "c5",
            nombre = "Rafael López Aliaga",
            cargo = "Alcalde Distrital",
            partido = "Renovación Popular",
            region = "Junín",
            ciudad = "Huancayo",
            fotoUrl = "https://saludconlupa.com/media/images/Rafael-Lopez-Aliaga.2e16d0ba.fill-400x400.jpg",
            descripcion = "Ingeniero civil con experiencia en infraestructura",
            proyectos = emptyList(),
            historialPolitico = emptyList(),
            denuncias = emptyList(),
            fuentesOficiales = emptyList(),
            tieneInvestigaciones = false,
            tieneDenuncias = false
        ),
        Candidato(
            id = "c6",
            nombre = "Sofía Martínez Ruiz",
            cargo = "Congresista",
            partido = "Morado",
            region = "Piura",
            ciudad = "Piura",
            fotoUrl = "https://via.placeholder.com/200",
            descripcion = "Economista especializada en políticas sociales",
            proyectos = emptyList(),
            historialPolitico = emptyList(),
            denuncias = emptyList(),
            fuentesOficiales = emptyList(),
            tieneInvestigaciones = false,
            tieneDenuncias = false
        )
    )

    fun getAllCandidatos(): List<Candidato> = candidatos

    fun getCandidatoById(id: String): Candidato? = candidatos.find { it.id == id }

    fun searchCandidatos(
        query: String = "",
        cargo: String = "",
        partido: String = "",
        region: String = ""
    ): List<Candidato> {
        return candidatos.filter { candidato ->
            val matchQuery = query.isEmpty() ||
                    candidato.nombre.contains(query, ignoreCase = true) ||
                    candidato.ciudad.contains(query, ignoreCase = true) ||
                    candidato.region.contains(query, ignoreCase = true)

            val matchCargo = cargo.isEmpty() || candidato.cargo == cargo
            val matchPartido = partido.isEmpty() || candidato.partido == partido
            val matchRegion = region.isEmpty() || candidato.region == region

            matchQuery && matchCargo && matchPartido && matchRegion
        }
    }

    fun getCargos(): List<String> = candidatos.map { it.cargo }.distinct()

    fun getPartidos(): List<String> = candidatos.map { it.partido }.distinct()

    fun getRegiones(): List<String> = candidatos.map { it.region }.distinct()


    fun getNoticias(): List<Noticia> = listOf(
        Noticia(
            id = "noticia_1",
            titulo = "Tech Giants Report Strong Q4 Earnings Despite Market Volatility",
            descripcion = "Major technology companies exceeded expectations in their quarterly reports, showing resilience in...",
            contenido = "Major technology companies exceeded expectations in their quarterly reports, showing resilience in the face of market volatility. The sector continues to demonstrate strong growth potential.",
            fecha = "2024-01-15",
            imagen = "noticia_1",
            fuente = "Reuters"
        ),
        Noticia(
            id = "noticia_2",
            titulo = "Nuevas regulaciones electorales para 2026",
            descripcion = "El JNE anuncia cambios importantes en los procesos electorales...",
            contenido = "El Jurado Nacional de Elecciones ha anunciado nuevas regulaciones que entrarán en vigor para las elecciones de 2026.",
            fecha = "2024-01-14",
            imagen = "noticia_2",
            fuente = "JNE"
        ),
        Noticia(
            id = "noticia_3",
            titulo = "Candidatos presidenciales presentan propuestas de desarrollo",
            descripcion = "Los principales candidatos presentaron sus planes de gobierno...",
            contenido = "Los principales candidatos a la presidencia presentaron sus planes de gobierno enfocados en desarrollo económico y social.",
            fecha = "2024-01-13",
            imagen = "noticia_3",
            fuente = "Congreso"
        )
    )

    // <CHANGE> Agregar datos simulados de datos importantes
    fun getDatosImportantes(): List<DatoImportante> = listOf(
        DatoImportante(
            id = "dato_1",
            titulo = "¿Qué se elige?",
            descripcion = "Información sobre qué se elige en las elecciones 2026",
            contenido = "En las elecciones generales de Perú 2026 se elige:\n" +
                    "• 1 Presidente de la República\n" +
                    "• 2 Vicepresidentes\n" +
                    "• 130 Diputados\n" +
                    "• 60 Senadores\n" +
                    "• 5 Parlamentarios Andinos",
            icono = "dato_que_se_elige"
        ),
        DatoImportante(
            id = "dato_2",
            titulo = "Fecha y Hora",
            descripcion = "Cuándo se realizarán las elecciones",
            contenido = "Fecha: 12 de abril de 2026\n" +
                    "Hora: 7:00 a 17:00\n" +
                    "Lugar: Locales de votación en todo el país",
            icono = "dato_fecha"
        ),
        DatoImportante(
            id = "dato_3",
            titulo = "¿Quiénes votan?",
            descripcion = "Requisitos para ser elector",
            contenido = "Pueden votar todos los ciudadanos peruanos mayores de 18 años, con DNI vigente.\n" +
                    "El voto es obligatorio hasta los 70 años.\n" +
                    "A partir de los 70 años, el voto es facultativo (opcional).",
            icono = "dato_quienes_votan"
        ),
        DatoImportante(
            id = "dato_4",
            titulo = "Recomendaciones",
            descripcion = "Consejos para el día de votación",
            contenido = "• Llevar DNI vigente\n" +
                    "• Revisar tu local y mesa de votación antes del día\n" +
                    "• Evita compartir tu voto o fotografiar la cédula electoral\n" +
                    "• Llega temprano para evitar aglomeraciones",
            icono = "dato_recomendaciones"
        )
    )

    // <CHANGE> Sistema de votos simulado
    private val votos = mutableMapOf<String, Int>()

    fun registrarVoto(candidatoId: String) {
        votos[candidatoId] = (votos[candidatoId] ?: 0) + 1
    }

    fun obtenerVotosPorCandidato(candidatoId: String): Int {
        return votos[candidatoId] ?: 0
    }

    fun obtenerRankingPorCargo(cargo: String): List<Pair<Candidato, Int>> {
        return getAllCandidatos()
            .filter { it.cargo == cargo }
            .map { it to (votos[it.id] ?: 0) }
            .sortedByDescending { it.second }
            .take(5)
    }
}
