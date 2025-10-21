package com.tecsup.candidato_info_app.data.repository

import com.tecsup.candidato_info_app.data.datasource.LocalDataSource
import com.tecsup.candidato_info_app.data.model.Candidato

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
}