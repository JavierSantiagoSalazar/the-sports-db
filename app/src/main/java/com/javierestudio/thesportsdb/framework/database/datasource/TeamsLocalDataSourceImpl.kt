package com.javierestudio.thesportsdb.framework.database.datasource

import com.javierestudio.thesportsdb.core.data.teams.TeamsLocalDataSource
import com.javierestudio.thesportsdb.core.domain.league.model.Team
import com.javierestudio.thesportsdb.framework.database.daos.TeamDao
import com.javierestudio.thesportsdb.framework.database.entities.TeamEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TeamsLocalDataSourceImpl(private val teamDao: TeamDao) : TeamsLocalDataSource {
    override suspend fun saveTeams(teams: List<Team>) = withContext(Dispatchers.IO){
        teamDao.saveTeams(teams.map { TeamEntity(it) })
    }

    override suspend fun getTeams(): List<Team> = withContext(Dispatchers.IO) {
        teamDao.getTeams().map { it.mapToDomain() }
    }
}