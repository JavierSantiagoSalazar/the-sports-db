package com.javierestudio.thesportsdb.framework.network.datasource

import com.javierestudio.thesportsdb.framework.utils.DataException
import com.javierestudio.thesportsdb.framework.utils.TypeError
import com.javierestudio.thesportsdb.core.data.teams.TeamsRemoteDataSource
import com.javierestudio.thesportsdb.core.domain.league.model.Team
import com.javierestudio.thesportsdb.framework.network.services.APIService
import com.javierestudio.thesportsdb.framework.utils.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TeamsRemoteDataSourceImpl(private val apiService: APIService) : TeamsRemoteDataSource {
    override suspend fun getTeams(league: Int): List<Team> = withContext(Dispatchers.IO) {
        val url: String = when (league) {
            Constants.LA_LIGA -> Constants.URL_BASE + Constants.URL_TEAMS_LA_LIGA
            Constants.PREMIER -> Constants.URL_BASE + Constants.URL_TEAMS_PREMIER
            Constants.SERIE -> Constants.URL_BASE + Constants.URL_TEAMS_SERIE
            else -> ""
        }
        try {
            val teams = apiService.getAllTeams(url)
            teams.body()?.teams?.map { it.mapToDomain() } ?: emptyList()
        } catch (e: DataException) {
            throw DataException(TypeError.GET)
        }
    }
}