package com.tecsup.candidato_info_app.data.repository

import com.tecsup.candidato_info_app.data.datasource.LocalDataSource
import com.tecsup.candidato_info_app.data.model.Candidato
import com.tecsup.candidato_info_app.data.model.Noticia

class CandidateRepository {

    fun getAllCandidatos(): List<Candidato> = LocalDataSource.getAllCandidatos()

    fun getCandidatoById(id: String): Candidato? = LocalDataSource.getCandidatoById(id)

    fun searchCandidatos(
        query: String = "",
        cargo: String = "",
        partido: String = "",
        region: String = ""
    ): List<Candidato> = LocalDataSource.searchCandidatos(query, cargo, partido, region)

    fun getCargos(): List<String> = LocalDataSource.getCargos()

    fun getPartidos(): List<String> = LocalDataSource.getPartidos()

    fun getRegiones(): List<String> = LocalDataSource.getRegiones()

    fun getNoticias(): List<Noticia> = LocalDataSource.getNoticias()

    fun registrarVoto(candidatoId: String) {
        LocalDataSource.registrarVoto(candidatoId)
    }

    fun obtenerVotosPorCandidato(candidatoId: String): Int {
        return LocalDataSource.obtenerVotosPorCandidato(candidatoId)
    }

    fun obtenerRankingPorCargo(cargo: String): List<Pair<Candidato, Int>> {
        return LocalDataSource.obtenerRankingPorCargo(cargo)
    }
}
