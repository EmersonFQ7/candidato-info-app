package com.tecsup.candidato_info_app.data.datasource

import com.tecsup.candidato_info_app.data.model.*
import com.tecsup.candidato_info_app.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

object LocalDataSource {
    val rankingUpdated: StateFlow<Unit> = VotePersistence.rankingUpdated
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
        fotoUrl = "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEhb6gmQX9KcnzvWse4YHx0ZVnashU1hyphenhyphenJfpvVhiX-8rBO7cne47ZPXC-t_r_Jgy8X2EdKff3JG6HBLM6ogboG09_JQskR8ku3DkwcFJAr4Row6xrbCKGmcyo3VjONpW51WG6aueA6Ac4Rxv/s1600/FOTO+MARIA+ELENA+RODRIGUEZ+CHAVARRI.JPG",
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
            estado = "cancelado",
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
        nombre = "Carlos Gonzales Mendoza",
        cargo = "Alcalde Provincial",
        partido = "Fuerza Popular",
        region = "Arequipa",
        ciudad = "Arequipa",
        fotoUrl = "https://elperuano.pe/fotografia/thumbnail/2024/03/17/000289827M.jpg",
        descripcion = "Empresario con experiencia en gestión pública y desarrollo regional",
        proyectos = proyectos2,
        historialPolitico = historialPolitico2,
        denuncias = denuncias2,
        fuentesOficiales = fuentesOficiales2,
        tieneInvestigaciones = false,
        tieneDenuncias = true
    )
//INFORMACION DEL CANDIDATO Jorge Luis Prado Palomino
private val proyectos3 = listOf(
    Proyecto(
        id = "p7",
        nombre = "Parques Industriales en 9 Regiones",
        descripcion = "Promoción de inversión privada por cerca de US$ 496 millones para nueve parques industriales en diversas regiones del país.",
        estado = "Plan",
        fechaInicio = "2022",
        fechaFin = null
    ),
    Proyecto(
        id = "p8",
        nombre = "Fortalecimiento de MIPYME en Piura",
        descripcion = "Programa para impulsar el surgimiento de micro y pequeñas empresas en la región de Piura, desde el Ministerio de la Producción.",
        estado = "En Proceso",
        fechaInicio = "2021",
        fechaFin = "2023"
    ),
    Proyecto(
        id = "p9",
        nombre = "Presupuesto 2022 para Innovación y Desembarcaderos",
        descripcion = "Asignación de S/ 851.8 millones para el sector Producción: S/ 150.1 millones en innovación para MIPYME; S/ 97.1 millones en pesca y acuicultura; S/ 75.1 millones para 23 desembarcaderos.",
        estado = "Completado",
        fechaInicio = "2021",
        fechaFin = "2022"
    )
)

    private val historialPolitico3 = listOf(
        HistorialPolitico(
            id = "h7",
            cargo = "Ministro de la Producción",
            institucion = "Ministerio de la Producción",
            fechaInicio = "2021-11-17",
            fechaFin = "2022-11",
            descripcion = "Asumió la cartera del sector Producción en el gobierno de Pedro Castillo."
        ),
        HistorialPolitico(
            id = "h8",
            cargo = "Docente universitario y auditor",
            institucion = "Universidad San Martín de Porres / Empresa privada",
            fechaInicio = "2015",
            fechaFin = null,
            descripcion = "Ha trabajado como auditor, gerente corporativo y docente universitario."
        )
    )

    private val denuncias3 = listOf(
        Denuncia(
            id = "d4",
            tipo = "Investigación",
            titulo = "Denuncia por nepotismo",
            descripcion = "La Contraloría recomendó denuncia penal por presunto nepotismo al contratar a su sobrino en el Ministerio de la Producción.",
            fecha = "2022-12-27",
            estado = "resuelto",
            institucion = "Contraloría / Fiscalía de la Nación"
        ),
        Denuncia(
            id = "d5",
            tipo = "Denuncia constitucional",
            titulo = "Instigador del delito contra la administración pública",
            descripcion = "Denuncia admitida en el Congreso por presunta negociación incompatible en agravio del Estado.",
            fecha = "2025-06-04",
            estado = "Admitida a trámite",
            institucion = "Congreso de la República"
        )
    )
//INFORMACION DEL CANDIDATO LOPEZ ALIAGA

    private val proyectos4 = listOf(
        Proyecto(
            id = "p10",
            nombre = "Sistema de Teleféricos Urbanos",
            descripcion = "Conectar distritos de Lima con transporte aéreo",
            estado = "Plan",
            fechaInicio = "2024",
            fechaFin = null
        ),
        Proyecto(
            id = "p11",
            nombre = "Reactivación del Tren Lima – Chosica",
            descripcion = "Proyecto de transporte ferroviario para Lima Este",
            estado = "En Proceso",
            fechaInicio = "2025",
            fechaFin = "2027"
        ),
        Proyecto(
            id = "p12",
            nombre = "Programa de Seguridad con Motos Inteligentes",
            descripcion = "Implementación de 10,000 motos con GPS para patrullaje",
            estado = "Plan",
            fechaInicio = "2025",
            fechaFin = null
        )
    )

    private val historialPolitico4 = listOf(
        HistorialPolitico(
            id = "h10",
            cargo = "Regidor de Lima",
            institucion = "Municipalidad Metropolitana de Lima",
            fechaInicio = "2007",
            fechaFin = "2010",
            descripcion = "Participación en gestión metropolitana"
        ),
        HistorialPolitico(
            id = "h11",
            cargo = "Candidato Presidencial",
            institucion = "Renovación Popular",
            fechaInicio = "2021",
            fechaFin = "2021",
            descripcion = "Candidatura presidencial en elecciones generales"
        ),
        HistorialPolitico(
            id = "h12",
            cargo = "Alcalde de Lima",
            institucion = "Municipalidad Metropolitana de Lima",
            fechaInicio = "2023",
            fechaFin = "Presente",
            descripcion = "Gestión de la capital con enfoque en seguridad y transporte"
        )
    )
    private val denuncias4 = listOf(
        Denuncia(
            id = "d6",
            tipo = "Investigación",
            titulo = "Contratos con estudio legal vinculado",
            descripcion = "Presunta colusión por contratos millonarios",
            fecha = "2025",
            estado = "En proceso",
            institucion = "Fiscalía Anticorrupción"
        ),
        Denuncia(
            id = "d7",
            tipo = "Investigación",
            titulo = "Grupo de inteligencia sin control",
            descripcion = "Operación irregular de equipo GEIM en Lima",
            fecha = "2025",
            estado = "En investigación",
            institucion = "Municipalidad / PNP"
        )
    )
//INFORMACION DEL CANDIDATO Sofía Martínez Ruiz
private val proyectos5 = listOf(
    Proyecto(
        id = "p13",
        nombre = "Programa Nacional de Alimentación Escolar",
        descripcion = "Mejorar la calidad nutricional en escuelas públicas rurales",
        estado = "Plan",
        fechaInicio = "2024",
        fechaFin = "2026"
    ),
    Proyecto(
        id = "p14",
        nombre = "Centro Integral de Atención a la Mujer",
        descripcion = "Implementación de centros de salud especializados para mujeres",
        estado = "En Proceso",
        fechaInicio = "2023",
        fechaFin = "2025"
    ),
    Proyecto(
        id = "p15",
        nombre = "Red de Apoyo Rural para Educación Inicial",
        descripcion = "Infraestructura y recursos para niños en zonas de difícil acceso",
        estado = "Completado",
        fechaInicio = "2020",
        fechaFin = "2023"
    )
)

    private val historialPolitico5 = listOf(
        HistorialPolitico(
            id = "h13",
            cargo = "Regidora Municipal de San Isidro",
            institucion = "Municipalidad de San Isidro",
            fechaInicio = "2015",
            fechaFin = "2018",
            descripcion = "Gestión municipal y desarrollo local"
        ),
        HistorialPolitico(
            id = "h14",
            cargo = "Asesora del Ministerio de Educación",
            institucion = "Ministerio de Educación",
            fechaInicio = "2019",
            fechaFin = "2021",
            descripcion = "Diseño e implementación de políticas educativas a nivel nacional"
        ),
        HistorialPolitico(
            id = "h15",
            cargo = "Congresista de la República",
            institucion = "Congreso de la República",
            fechaInicio = "2021",
            fechaFin = "Presente",
            descripcion = "Representación legislativa con enfoque en políticas sociales"
        )
    )

    private val denuncias5 = listOf(
        Denuncia(
            id = "d8",
            tipo = "Investigación",
            titulo = "Presunto conflicto de intereses",
            descripcion = "Investigación administrativa por brindar asesoría privada mientras ocupaba un cargo público.",
            fecha = "2019",
            estado = "En proceso",
            institucion = "Fiscalía Especializada"
        )
    )
//INDORMACION DEL CANDIDATO CESAR ACUÑA
private val proyectos6 = listOf(
    Proyecto(
        id = "p16",
        nombre = "Laboratorio de Criminalística – La Libertad",
        descripcion = "Construcción de moderno laboratorio de criminalística para la investigación policial en Trujillo, inversión de más de S/. 18 millones. :contentReference[oaicite:1]{index=1}",
        estado = "En Proceso",
        fechaInicio = "2025",
        fechaFin = null
    ),
    Proyecto(
        id = "p17",
        nombre = "Equipamiento policial y drones – La Libertad",
        descripcion = "Entrega de 40 drones inteligentes, patrulleros y tecnología para la Policía Nacional en La Libertad. :contentReference[oaicite:2]{index=2}",
        estado = "En Proceso",
        fechaInicio = "2024",
        fechaFin = "2026"
    ),
    Proyecto(
        id = "p18",
        nombre = "Inversión de S/ 12,000 millones para desarrollo regional",
        descripcion = "Compromiso de inversión para 4 años en la región La Libertad con énfasis en infraestructura, salud y educación. :contentReference[oaicite:3]{index=3}",
        estado = "Plan",
        fechaInicio = "2023",
        fechaFin = "2026"
    )
)

    private val historialPolitico6 = listOf(
        HistorialPolitico(
            id = "h16",
            cargo = "Alcalde Provincial de Trujillo",
            institucion = "Municipalidad Provincial de Trujillo",
            fechaInicio = "2007",
            fechaFin = "2010",
            descripcion = "Gestión municipal en la provincia de Trujillo."
        ),
        HistorialPolitico(
            id = "h17",
            cargo = "Congresista de la República",
            institucion = "Congreso de la República",
            fechaInicio = "2011",
            fechaFin = "2016",
            descripcion = "Period parlamentario representando a la región La Libertad. :contentReference[oaicite:4]{index=4}"
        ),
        HistorialPolitico(
            id = "h18",
            cargo = "Gobernador Regional de La Libertad",
            institucion = "Gobierno Regional de La Libertad",
            fechaInicio = "2023‑01‑01",
            fechaFin = "2025‑10‑13",
            descripcion = "Ejerció el cargo de gobernador regional hasta octubre de 2025. :contentReference[oaicite:5]{index=5}"
        )
    )

    private val denuncias6 = listOf(
        Denuncia(
            id = "d16",
            tipo = "Investigación",
            titulo = "Presuntas irregularidades en concursos Procompite",
            descripcion = "Se investigan denuncias por vicios en los procesos de selección de Procompite por cerca de S/ 60 millones en la gestión regional. :contentReference[oaicite:6]{index=6}",
            fecha = "2025‑08‑10",
            estado = "En investigación",
            institucion = "Fiscalía / Contraloría"
        ),
        Denuncia(
            id = "d17",
            tipo = "Investigación",
            titulo = "Adjudicación cuestionada de obra vial Huanchaco‑Trujillo",
            descripcion = "Contrato por S/ 121 millones anulado tras reportes de irregularidades en licitación. :contentReference[oaicite:7]{index=7}",
            fecha = "2025‑09‑09",
            estado = "En proceso",
            institucion = "Fiscalía"
        )
    )
    //INFORMACION SOBRE EL CANDIDATO KEIKO FUJIMORI
    private val proyectos7 = listOf(
        Proyecto(
            id = "p19",
            nombre = "Programa de Apoyo a la Mujer Emprendedora",
            descripcion = "Fondo de microcréditos y capacitación para mujeres emprendedoras en zonas urbanas y rurales del país",
            estado = "Plan",
            fechaInicio = "2025",
            fechaFin = null
        ),
        Proyecto(
            id = "p20",
            nombre = "Ciudad Segura – Cinturón de Seguridad Metropolitana",
            descripcion = "Infraestructura de cámaras, patrullaje y tecnología para seguridad ciudadana en Lima y Callao",
            estado = "En Proceso",
            fechaInicio = "2024",
            fechaFin = "2026"
        ),
        Proyecto(
            id = "p21",
            nombre = "Educación Técnica para el Futuro",
            descripcion = "Creación de institutos técnicos en cada región para jóvenes de 16‑24 años",
            estado = "Plan",
            fechaInicio = "2026",
            fechaFin = null
        )
    )

    private val historialPolitico7 = listOf(
        HistorialPolitico(
            id = "h19",
            cargo = "Congresista de la República",
            institucion = "Congreso de la República",
            fechaInicio = "2006",
            fechaFin = "2011",
            descripcion = "Representó al partido Fuerza Popular como parlamentaria"
        ),
        HistorialPolitico(
            id = "h20",
            cargo = "Candidata Presidencial",
            institucion = "Partido Fuerza Popular",
            fechaInicio = "2011",
            fechaFin = "2021",
            descripcion = "Se presentó como candidata presidencial en varias elecciones generales"
        ),
        HistorialPolitico(
            id = "h21",
            cargo = "Líder Política del Partido Fuerza Popular",
            institucion = "Partido Fuerza Popular",
            fechaInicio = "2014",
            fechaFin = null,
            descripcion = "Dirige la agrupación política mayoritaria de derecha en el país"
        )
    )

    private val denuncias7 = listOf(
        Denuncia(
            id = "d8",
            tipo = "Investigación",
            titulo = "Investigación por lavado de activos y aportes ilegales de campaña",
            descripcion = "Fiscalía investiga presuntos aportes ilícitos de empresas brasileñas para campañas presidenciales de 2011 y 2016. :contentReference[oaicite:2]{index=2}",
            fecha = "2019",
            estado = "En proceso",
            institucion = "Fiscalía Especializada en Delitos de Corrupción"
        ),
        Denuncia(
            id = "d9",
            tipo = "Denuncia Constitucional",
            titulo = "Denuncia por organización criminal en partido político",
            descripcion = "Parlamentarios denunciaron que la estructura de su partido funcionaba como organización criminal para la captación de fondos. :contentReference[oaicite:3]{index=3}",
            fecha = "2018",
            estado = "Admitida a trámite",
            institucion = "Congreso de la República"
        )
    )
    //INFORMACION SOBRE EL CANDIDATO YONHY LESCANO
    private val proyectos8 = listOf(
        Proyecto(
            id = "p22",
            nombre = "Red Nacional de Justicia Social",
            descripcion = "Creación de centros de apoyo legal y social para comunidades vulnerables en todo el país",
            estado = "Plan",
            fechaInicio = "2025",
            fechaFin = null
        ),
        Proyecto(
            id = "p23",
            nombre = "Educación Técnica y Superior para Puno y Altiplano",
            descripcion = "Mejoramiento de infraestructura educativa y becas para jóvenes de Puno y zonas altoandinas",
            estado = "En Proceso",
            fechaInicio = "2024",
            fechaFin = "2026"
        ),
        Proyecto(
            id = "p24",
            nombre = "Defensa del Medioambiente y Recursos Naturales",
            descripcion = "Proyecto de ley y programa para regular la explotación minera y proteger comunidades indígenas",
            estado = "Plan",
            fechaInicio = "2026",
            fechaFin = null
        )
    )

    private val historialPolitico8 = listOf(
        HistorialPolitico(
            id = "h22",
            cargo = "Congresista de la República",
            institucion = "Congreso de la República",
            fechaInicio = "2001",
            fechaFin = "2019",
            descripcion = "Representó a la región Puno y luego Lima, fue congresista durante varios periodos. :contentReference[oaicite:4]{index=4}"
        ),
        HistorialPolitico(
            id = "h23",
            cargo = "Secretario General del Partido Acción Popular",
            institucion = "Partido Acción Popular",
            fechaInicio = "2009",
            fechaFin = "2011",
            descripcion = "Ejerció como secretario general nacional de su partido. :contentReference[oaicite:5]{index=5}"
        ),
        HistorialPolitico(
            id = "h24",
            cargo = "Candidato Presidencial",
            institucion = "Partido Acción Popular",
            fechaInicio = "2021",
            fechaFin = "2021",
            descripcion = "Fue candidato a la presidencia en las elecciones generales de 2021. :contentReference[oaicite:6]{index=6}"
        )
    )

    private val denuncias8 = listOf(
        Denuncia(
            id = "d10",
            tipo = "Denuncia",
            titulo = "Denuncia por acoso sexual contra una periodista",
            descripcion = "En 2019 fue denunciado por presunto acoso sexual. Fiscalía archivó el caso en 2020. :contentReference[oaicite:7]{index=7}",
            fecha = "2019",
            estado = "Archivada",
            institucion = "Ministerio Público"
        )
    )
    //INFORMACION SOBRE EL CANIDDATO CARLOS ALVAREZ
    private val proyectos9 = listOf(
        Proyecto(
            id = "p25",
            nombre = "Campaña Nacional de Libertad de Expresión",
            descripcion = "Promover la libertad de expresión y medios independientes en el Perú",
            estado = "Plan",
            fechaInicio = "2025",
            fechaFin = null
        ),
        Proyecto(
            id = "p26",
            nombre = "Escuelas de Humor Social",
            descripcion = "Formación de jóvenes en técnicas de humor crítico para transformación social",
            estado = "Plan",
            fechaInicio = "2026",
            fechaFin = null
        ),
        Proyecto(
            id = "p27",
            nombre = "Plataforma Digital Participativa",
            descripcion = "Implementar una plataforma online para que ciudadanos propongan leyes y den seguimiento",
            estado = "En Proceso",
            fechaInicio = "2024",
            fechaFin = "2026"
        )
    )

    private val historialPolitico9 = listOf(
        HistorialPolitico(
            id = "h25",
            cargo = "Afiliado al partido País Para Todos",
            institucion = "Partido País Para Todos",
            fechaInicio = "2024",
            fechaFin = null,
            descripcion = "Ingreso al partido político tras carrera en medios de comunicación"
        ),
        HistorialPolitico(
            id = "h26",
            cargo = "Candidato a la Presidencia de la República (preinternas)",
            institucion = "Partido País Para Todos",
            fechaInicio = "2025",
            fechaFin = "2026",
            descripcion = "Proceso interno para definir candidatura a elecciones generales"
        ),
        HistorialPolitico(
            id = "h27",
            cargo = "Presentador y Comediante con enfoque político‑social",
            institucion = "Medios de Comunicación",
            fechaInicio = "1983",
            fechaFin = null,
            descripcion = "Amplia trayectoria en televisión, donde trató temas de política y sociedad"
        )
    )

    private val denuncias9 = listOf(
        Denuncia(
            id = "d9",
            tipo = "Investigación",
            titulo = "Denuncia por presuntos mensajes de odio y solicitud de ilegalidad del partido",
            descripcion = "La Fiscalía de la Nación abrió diligencias preliminares para evaluar la ilegalidad del partido País Para Todos al que pertenece Carlos Álvarez. :contentReference[oaicite:2]{index=2}",
            fecha = "2025‑03‑27",
            estado = "En proceso",
            institucion = "Ministerio Público"
        ),
        Denuncia(
            id = "d10",
            tipo = "Denuncia",
            titulo = "Denuncia por extorsión y amenazas recibidas",
            descripcion = "El propio Carlos Álvarez denunció haber sido víctima de extorsión y amenazas, con balas dejadas en su domicilio. :contentReference[oaicite:3]{index=3}",
            fecha = "2023‑05‑31",
            estado = "Archivada/En trámite",
            institucion = "DIRINCRI"
        )
    )
    //INFORMACION SOBRE EL CANDIDATO MARIO VIZACARRA
    private val proyectos10 = listOf(
        Proyecto(
            id = "p28",
            nombre = "Movilización Regional para la Participación Política",
            descripcion = "Programa de fortalecimiento de participación ciudadana en Moquegua y sur del Perú",
            estado = "Plan",
            fechaInicio = "2026",
            fechaFin = null
        ),
        Proyecto(
            id = "p29",
            nombre = "Alianza Territorial Perú Primero",
            descripcion = "Consolidar la base regional del partido Perú Primero para las elecciones generales",
            estado = "En Proceso",
            fechaInicio = "2025",
            fechaFin = "2027"
        ),
        Proyecto(
            id = "p30",
            nombre = "Plataforma de Transparencia y Ética Pública",
            descripcion = "Proyecto para monitorear contratos públicos y evitar favoritismos en la gestión estatal",
            estado = "Plan",
            fechaInicio = "2025",
            fechaFin = null
        )
    )

    private val historialPolitico10 = listOf(
        HistorialPolitico(
            id = "h28",
            cargo = "Militante del partido Perú Primero",
            institucion = "Partido Perú Primero",
            fechaInicio = "2023",
            fechaFin = null,
            descripcion = "Afiliación al partido fundado por su hermano Martín Vizcarra, con miras a asumir cargos de liderazgo. :contentReference[oaicite:5]{index=5}"
        ),
        HistorialPolitico(
            id = "h29",
            cargo = "Gestor de campañas políticas regionales",
            institucion = "Movilización política del sur",
            fechaInicio = "2011",
            fechaFin = null,
            descripcion = "Participó en campañas de su hermano en Moquegua y en la organización del partido"
        )
    )

    private val denuncias10 = listOf(
        Denuncia(
            id = "d11",
            tipo = "Denuncia",
            titulo = "Investigación preliminar por vinculación a red de corrupción ligada al expresidente Vizcarra",
            descripcion = "En informes se menciona que Mario Vizcarra y su hermano podrían estar involucrados en investigación de red que operaba durante la gestión de Martín Vizcarra. :contentReference[oaicite:6]{index=6}",
            fecha = "2025‑08‑17",
            estado = "En proceso",
            institucion = "Fiscalía de la Nación"
        )
    )

    // INFORMACIÓN SOBRE EL CANDIDATO ROBERTO CHIABRA
    private val proyectos11 = listOf(
        Proyecto(
            id = "p31",
            nombre = "Fortalecimiento de la Defensa Nacional",
            descripcion = "Plan de modernización y profesionalización de las Fuerzas Armadas del Perú",
            estado = "Plan",
            fechaInicio = "2025",
            fechaFin = null
        ),
        Proyecto(
            id = "p32",
            nombre = "Programa de Seguridad Ciudadana Regional",
            descripcion = "Iniciativa para reducir la criminalidad y fortalecer la presencia del Estado en provincias",
            estado = "Plan",
            fechaInicio = "2025",
            fechaFin = null
        )
    )

    private val historialPolitico11 = listOf(
        HistorialPolitico(
            id = "h30",
            cargo = "Comandante General del Ejército",
            institucion = "Fuerzas Armadas del Perú",
            fechaInicio = "1998",
            fechaFin = "2003",
            descripcion = "Dirigió el Ejército durante la gestión del exasesor presidencial Vladimiro Montesinos, con cuestionamientos por irregularidades administrativas"
        ),
        HistorialPolitico(
            id = "h31",
            cargo = "Candidato presidencial",
            institucion = "Coalición PPC – Unidad y Paz",
            fechaInicio = "2025",
            fechaFin = null,
            descripcion = "Candidatura presidencial con foco en seguridad y defensa nacional"
        )
    )

    private val denuncias11 = listOf(
        Denuncia(
            id = "d12",
            tipo = "Denuncia",
            titulo = "Investigación por irregularidades en el Ejército y vínculo con Montesinos",
            descripcion = "Investigación por presuntas irregularidades durante su gestión en el Ejército y cercanía al condenado exasesor presidencial Vladimiro Montesinos",
            fecha = "2025-08-20",
            estado = "En proceso",
            institucion = "Fiscalía de la Nación"
        )
    )

    // INFORMACIÓN SOBRE EL CANDIDATO MARIANO GONZÁLEZ
    private val proyectos12 = listOf(
        Proyecto(
            id = "p33",
            nombre = "Reforma de Salud y Atención Primaria",
            descripcion = "Fortalecer la atención primaria y regular el sector salud privado",
            estado = "Plan",
            fechaInicio = "2025",
            fechaFin = null
        ),
        Proyecto(
            id = "p34",
            nombre = "Reforma de la Relación Ejecutivo-MEF",
            descripcion = "Mejorar coordinación y eficiencia entre el Ejecutivo y el MEF",
            estado = "Plan",
            fechaInicio = "2025",
            fechaFin = null
        )
    )

    private val historialPolitico12 = listOf(
        HistorialPolitico(
            id = "h32",
            cargo = "Presidente de Salvemos al Perú",
            institucion = "Salvemos al Perú",
            fechaInicio = "2025",
            fechaFin = null,
            descripcion = "Lidera el partido con enfoque en reformas administrativas y sector salud"
        ),
        HistorialPolitico(
            id = "h33",
            cargo = "Exconsultor de Odebrecht",
            institucion = "Odebrecht",
            fechaInicio = "2010",
            fechaFin = "2015",
            descripcion = "Experiencia en consultoría internacional y obras públicas"
        )
    )

    private val denuncias12 = listOf(
        Denuncia(
            id = "d13",
            tipo = "Denuncia",
            titulo = "Acusación por uso de firmas falsas ante el JNE",
            descripcion = "Fue acusado por el partido Salvemos al Perú de utilizar firmas presuntamente falsas para inscribir una alianza ante el Jurado Nacional de Elecciones",
            fecha = "2025-08-31",
            estado = "En proceso",
            institucion = "Ministerio Público"
        )
    )

    // INFORMACIÓN SOBRE EL CANDIDATO CARLOS ESPÁ
    private val proyectos13 = listOf(
        Proyecto(
            id = "p35",
            nombre = "Reforma Tributaria y Simplificación Administrativa",
            descripcion = "Propuesta de simplificación de trámites y ajuste de impuestos",
            estado = "Plan",
            fechaInicio = "2025",
            fechaFin = null
        ),
        Proyecto(
            id = "p36",
            nombre = "Privatización de Videovigilancia Penitenciaria",
            descripcion = "Modernización del sistema penitenciario mediante participación privada",
            estado = "Plan",
            fechaInicio = "2025",
            fechaFin = null
        )
    )

    private val historialPolitico13 = listOf(
        HistorialPolitico(
            id = "h34",
            cargo = "Candidato presidencial",
            institucion = "SíCreo",
            fechaInicio = "2025",
            fechaFin = null,
            descripcion = "Candidato presidencial centrado en reformas tributarias y administración pública"
        )
    )

    private val denuncias13 = listOf<Denuncia>() // No se encontraron denuncias registradas

    // INFORMACIÓN SOBRE EL CANDIDATO GEORGE FORSYTH
    private val proyectos14 = listOf(
        Proyecto(
            id = "p37",
            nombre = "Mejoras en Gestión Municipal y Seguridad",
            descripcion = "Iniciativa basada en su experiencia como alcalde, fortaleciendo seguridad y administración local",
            estado = "Plan",
            fechaInicio = "2025",
            fechaFin = null
        )
    )

    private val historialPolitico14 = listOf(
        HistorialPolitico(
            id = "h35",
            cargo = "Alcalde de La Victoria",
            institucion = "Municipalidad de La Victoria",
            fechaInicio = "2019",
            fechaFin = "2022",
            descripcion = "Gestión municipal enfocada en seguridad y proyectos sociales"
        ),
        HistorialPolitico(
            id = "h36",
            cargo = "Candidato presidencial",
            institucion = "Somos Perú",
            fechaInicio = "2025",
            fechaFin = null,
            descripcion = "Candidato presidencial con enfoque en gestión pública y seguridad"
        )
    )

    private val denuncias14 = listOf(
        Denuncia(
            id = "d14",
            tipo = "Denuncia",
            titulo = "Denuncia por violencia doméstica",
            descripcion = "Su exesposa Vanessa Terkes presentó una denuncia por violencia psicológica durante su matrimonio; la denuncia fue archivada en primera instancia",
            fecha = "2019-05-31",
            estado = "Archivada",
            institucion = "Poder Judicial"
        )
    )



    private val candidatos = listOf(
        candidato1,
        candidato2,
        Candidato(
            id = "c3",
            nombre = "Jorge Luis Prado palomino",
            cargo = "Gobernador Regional",
            partido = "Acción Popular",
            region = "La Libertad",
            ciudad = "Trujillo",
            fotoUrl = "https://losinformativos.com/wp-content/uploads/2021/11/FEceBgyXMAQSsEs.jpg-0-1.jpg",
            descripcion = "Profesional en administración pública",
            proyectos = proyectos3,
            historialPolitico = historialPolitico3,
            denuncias = denuncias3,
            fuentesOficiales = emptyList(),
            tieneInvestigaciones = false,
            tieneDenuncias = false
        ),

        Candidato(
            id = "c4",
            nombre = "Rafael López Aliaga",
            cargo = "Presidente",
            partido = "Renovación Popular",
            region = "Junín",
            ciudad = "Huancayo",
            fotoUrl = "https://saludconlupa.com/media/images/Rafael-Lopez-Aliaga.2e16d0ba.fill-400x400.jpg",
            descripcion = "Ingeniero civil con experiencia en infraestructura",
            proyectos = proyectos4,
            historialPolitico = historialPolitico4,
            denuncias = denuncias4,
            fuentesOficiales = emptyList(),
            tieneInvestigaciones = false,
            tieneDenuncias = false
        ),
        Candidato(
            id = "c5",
            nombre = "Fiorella Isabel Molinelli Meléndez.",
            cargo = "Congresista",
            partido = "Morado",
            region = "Piura",
            ciudad = "Piura",
            fotoUrl = "https://www.huachos.com/upload/img/noticias/164441535064085b05558.jpg",
            descripcion = "Economista especializada en políticas sociales",
            proyectos = proyectos5,
            historialPolitico = historialPolitico5,
            denuncias = denuncias5,
            fuentesOficiales = emptyList(),
            tieneInvestigaciones = false,
            tieneDenuncias = false
        ),
        Candidato(
            id = "c6",
            nombre = "César Acuña Peralta",
            cargo = "Presidente",
            partido = "Alianza para el progreso",
            region = "La Libertad",
            ciudad = "Trujillo",
            fotoUrl = "https://caretas.pe/wp-content/uploads/2025/06/acuna-585x329.jpg",
            descripcion = "Empresario y politico peruano",
            proyectos = proyectos6,
            historialPolitico = historialPolitico6,
            denuncias = denuncias6,
            fuentesOficiales = emptyList(),
            tieneInvestigaciones = false,
            tieneDenuncias = false
        ),
        Candidato(
            id = "c7",
            nombre = "Keiko Fujimori Higuchi",
            cargo = "Presidente",
            partido = "Fuerza Popular",
            region = "Lima",
            ciudad = "Lima",
            fotoUrl = "https://caretas.pe/wp-content/uploads/2024/07/WhatsApp-Image-2024-07-12-at-12.57.19-PM-585x329.jpeg",
            descripcion = "Líder del partido Fuerza Popular, con experiencia congresal y varias candidaturas presidenciales",
            proyectos = proyectos7,
            historialPolitico = historialPolitico7,
            denuncias = denuncias7,
            fuentesOficiales = emptyList(),
            tieneInvestigaciones = true,
            tieneDenuncias = true
        ),
        Candidato(
            id = "c8",
            nombre = "Yonhy Lescano Ancieta",
            cargo = "Presidente",
            partido = "Acción Popular",
            region = "Puno",
            ciudad = "Puno",
            fotoUrl = "https://radiosantarosa.com.pe/wp-content/uploads/2023/02/LESCANO-DINA-REUNION-POLITICOS-CRISIS.jpg",
            descripcion = "Excongresista y exsecretario general de Acción Popular, enfocado en justicia social",
            proyectos = proyectos8,
            historialPolitico = historialPolitico8,
            denuncias = denuncias8,
            fuentesOficiales = emptyList(),
            tieneInvestigaciones = false,
            tieneDenuncias = true
        ),
        Candidato(
            id = "c9",
            nombre = "Carlos Álvarez Pinedo",
            cargo = "Presidente",
            partido = "País Para Todos",
            region = "Lima",
            ciudad = "Lima",
            fotoUrl = "https://storage.googleapis.com/repositorio-willax-prd/web-willax-assets/migrated/2018/07/alvarez.png",
            descripcion = "Comediante y comunicador, promotor de la participación ciudadana y libertad de expresión",
            proyectos = proyectos9,
            historialPolitico = historialPolitico9,
            denuncias = denuncias9,
            fuentesOficiales = emptyList(),
            tieneInvestigaciones = true,
            tieneDenuncias = false
        ),
        Candidato(
            id = "c10",
            nombre = "Mario Vizcarra Cornejo",
            cargo = "Presidente",
            partido = "Perú Primero",
            region = "Moquegua",
            ciudad = "Moquegua",
            fotoUrl = "https://altavoz.pe/wp-content/uploads/2025/08/martin-vizcarra.jpg",
            descripcion = "Empresario y dirigente político, vinculado al proyecto político del expresidente Martín Vizcarra",
            proyectos = proyectos10,
            historialPolitico = historialPolitico10,
            denuncias = denuncias10,
            fuentesOficiales = emptyList(),
            tieneInvestigaciones = true,
            tieneDenuncias = true
        ),
        Candidato(
            id = "c11",
            nombre = "Roberto Chiabra Gutiérrez",
            cargo = "Presidente",
            partido = "PPC – Unidad y Paz",
            region = "Nacional",
            ciudad = "Lima",
            fotoUrl = "https://img.lpderecho.pe/wp-content/uploads/2024/04/Roberto-Chiabra-LPDerecho.jpg",
            descripcion = "Congresista y excomandante general del Ejército, enfocado en defensa y seguridad nacional",
            proyectos = proyectos11,
            historialPolitico = historialPolitico11,
            denuncias = denuncias11,
            fuentesOficiales = emptyList(),
            tieneInvestigaciones = true,
            tieneDenuncias = true
        ),
        Candidato(
            id = "c12",
            nombre = "Mariano González Fernández",
            cargo = "Presidente",
            partido = "Salvemos al Perú",
            region = "Nacional",
            ciudad = "Lima",
            fotoUrl = "https://nuevodiario-assets.s3.us-east-2.amazonaws.com/wp-content/uploads/2022/07/04192725/92720965_01010mariano.jpg",
            descripcion = "Presidente de Salvemos al Perú, enfocado en reformas de salud y administración pública",
            proyectos = proyectos12,
            historialPolitico = historialPolitico12,
            denuncias = denuncias12,
            fuentesOficiales = emptyList(),
            tieneInvestigaciones = true,
            tieneDenuncias = true
        ),
        Candidato(
            id = "c13",
            nombre = "Alfonso Carlos Espá Garcés-Alvear",
            cargo = "Presidente",
            partido = "SíCreo",
            region = "Nacional",
            ciudad = "Lima",
            fotoUrl = "https://peru21.pe/sites/default/efsfiles/2025-03/entrevista-espa1.jpg_web.jpg",
            descripcion = "Aspirante de SíCreo, enfocado en reforma tributaria y simplificación administrativa",
            proyectos = proyectos13,
            historialPolitico = historialPolitico13,
            denuncias = denuncias13,
            fuentesOficiales = emptyList(),
            tieneInvestigaciones = false,
            tieneDenuncias = false
        ),
        Candidato(
            id = "c14",
            nombre = "George Forsyth Sommer",
            cargo = "Presidente",
            partido = "Somos Perú",
            region = "Nacional",
            ciudad = "Lima",
            fotoUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f7/George_Forsyth_Sommer.jpg/250px-George_Forsyth_Sommer.jpg",
            descripcion = "Exalcalde de La Victoria, enfocado en gestión pública y seguridad",
            proyectos = proyectos14,
            historialPolitico = historialPolitico14,
            denuncias = denuncias14,
            fuentesOficiales = emptyList(),
            tieneInvestigaciones = true,
            tieneDenuncias = true
        ),
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
            titulo = "Jefe de la ONPE supervisa avances en la organización de elecciones",
            descripcion = "Para atender las Elecciones Primarias, la ONPE ha conformado 14 oficinas descentralizadas...",
            fecha = "2025-01-15",
            fotoUrl = "https://cdn.www.gob.pe/uploads/document/file/8876812/1271285-fachada700x395.jpg",
            fuente = "ONPE"
        ),
        Noticia(
            id = "noticia_2",
            titulo = "Nuevas regulaciones electorales para 2026",
            descripcion = "El JNE anuncia cambios importantes en los procesos electorales...",
            fecha = "2025-01-14",
            fotoUrl = "https://cdn.www.gob.pe/uploads/document/file/8865165/1269839-jefe-de-la-onpe-supervisa-avances-en-la-organizacion-de-elecciones.jpg",
            fuente = "JNE"
        ),
        Noticia(
            id = "noticia_3",
            titulo = "Candidatos presidenciales presentan propuestas de desarrollo",
            descripcion = "Los principales candidatos presentaron sus planes de gobierno...",
            fecha = "2025-01-13",
            fotoUrl = "https://cdn.www.gob.pe/uploads/document/file/8868023/1270287-conadis-premia-a-la-onpe-en-concurso-de-buenas-practicas.jpg",
            fuente = "Congreso"
        ),

        Noticia(
        id = "noticia_4",
        titulo = "CONADIS premia a la ONPE en concurso de buenas prácticas",
        descripcion = "Por facilitar la votación de personas con discapacidad...",
        fecha = "2025-10-22",
        fotoUrl = "https://cdn.www.gob.pe/uploads/document/file/8865166/1269839-jefe-de-la-onpe-supervisa-avances-en-la-organizacion-de-elecciones.jpg",
        fuente = "CONADIS"
    )
    )

    // Datos importantes
    fun getDatosImportantes(): List<DatoImportante> = listOf(
        DatoImportante(
            id = "dato_1",
            titulo = "¿Qué se elige?",
             contenido = "En las elecciones generales de Perú 2026 se elige:\n" +
                    "• 1 Presidente de la República\n" +
                    "• 2 Vicepresidentes\n" +
                    "• 130 Diputados\n" +
                    "• 60 Senadores\n" +
                    "• 5 Parlamentarios Andinos",
         ),
        DatoImportante(
            id = "dato_2",
            titulo = "Fecha y Hora",
             contenido = "Fecha: 12 de abril de 2026\n" +
                    "Hora: 7:00 a 17:00\n",
         ),
        DatoImportante(
            id = "dato_3",
            titulo = "¿Quiénes votan?",
             contenido = "Pueden votar todos los ciudadanos peruanos mayores de 18 años, con DNI vigente.\n" +
                    "El voto es obligatorio hasta los 70 años.\n" +
                    "A partir de los 70 años, el voto es facultativo (opcional).",
         ),
        DatoImportante(
            id = "dato_4",
            titulo = "Recomendaciones",
             contenido = "• Llevar DNI vigente\n" +
                    "• Revisar tu local y mesa de votación antes del día\n" +
                    "• Evita compartir tu voto o fotografiar la cédula electoral\n" +
                    "• Llega temprano para evitar aglomeraciones",
         )
    )

    // Votacion
    fun registrarVoto(candidatoId: String) {
        VotePersistence.registrarVoto(candidatoId)
    }

    fun obtenerVotosPorCandidato(candidatoId: String): Int {
        return VotePersistence.obtenerVotosPorCandidato(candidatoId)
    }

    fun obtenerRankingPorCargo(cargo: String): List<Pair<Candidato, Int>> {
        val votos = VotePersistence.obtenerVotos()
        return getAllCandidatos()
            .filter { it.cargo == cargo }
            .map { it to (votos[it.id] ?: 0) }
            .sortedByDescending { it.second }
            .take(5)
    }

}
