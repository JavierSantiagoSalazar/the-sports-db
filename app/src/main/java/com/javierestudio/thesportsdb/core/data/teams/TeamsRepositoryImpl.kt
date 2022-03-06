package com.javierestudio.thesportsdb.core.data.teams

import com.javierestudio.appsosafe.framework.utils.DataException
import com.javierestudio.appsosafe.framework.utils.TypeError
import com.javierestudio.thesportsdb.core.domain.league.model.Team
import com.javierestudio.thesportsdb.core.domain.league.repository.TeamsRepository
import com.javierestudio.thesportsdb.core.domain.league.usecases.GetTeams
import java.lang.Exception

class TeamsRepositoryImpl(
    private val remoteDataSource: TeamsRemoteDataSource,
    private val localDataSource: TeamsLocalDataSource,
) : TeamsRepository {
    override suspend fun getTeams(): List<Team> {
        return try {
            val teams = remoteDataSource.getTeams()
            localDataSource.saveTeams(teams)
            teams
        } catch (e: DataException){
            localDataSource.getTeams()
        }
    }
}