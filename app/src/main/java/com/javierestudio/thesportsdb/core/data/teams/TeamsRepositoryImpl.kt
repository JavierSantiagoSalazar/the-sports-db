package com.javierestudio.thesportsdb.core.data.teams

import com.javierestudio.thesportsdb.framework.utils.DataException
import com.javierestudio.thesportsdb.core.domain.league.model.Team
import com.javierestudio.thesportsdb.core.domain.league.repository.TeamsRepository

class TeamsRepositoryImpl(
    private val remoteDataSource: TeamsRemoteDataSource,
    private val localDataSource: TeamsLocalDataSource,
) : TeamsRepository {
    override suspend fun getTeams(league: Int): List<Team> {
        return try {
            val teams = remoteDataSource.getTeams(league)
            localDataSource.saveTeams(teams)
            teams
        } catch (e: DataException){
            localDataSource.getTeams()
        }
    }
}