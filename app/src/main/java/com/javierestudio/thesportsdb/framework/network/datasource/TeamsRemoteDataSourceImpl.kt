package com.javierestudio.thesportsdb.framework.network.datasource

import com.javierestudio.appsosafe.framework.utils.DataException
import com.javierestudio.appsosafe.framework.utils.TypeError
import com.javierestudio.thesportsdb.core.data.teams.TeamsRemoteDataSource
import com.javierestudio.thesportsdb.core.domain.league.model.Team
import com.javierestudio.thesportsdb.framework.network.services.APIService
import com.javierestudio.thesportsdb.framework.utils.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TeamsRemoteDataSourceImpl(private val apiService: APIService) : TeamsRemoteDataSource {
    override suspend fun getTeams(): List<Team> = withContext(Dispatchers.IO) {
        val url: String = Constants.URL_BASE + Constants.URL_TEAMS
        try {
            val teams = apiService.getAllTeams(url)
            teams.body()?.teams?.map { it.mapToDomain() } ?: emptyList()
        } catch (e: DataException) {
            throw DataException(TypeError.GET)
        }
    }
}