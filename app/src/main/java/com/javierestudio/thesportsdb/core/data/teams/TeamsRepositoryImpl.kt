package com.javierestudio.thesportsdb.core.data.teams

import com.javierestudio.thesportsdb.core.domain.league.model.Team
import com.javierestudio.thesportsdb.core.domain.league.repository.TeamsRepository

class TeamsRepositoryImpl(
    private val remoteDataSource: TeamsRemoteDataSource,
): TeamsRepository {
    override suspend fun getTeams(): List<Team> = remoteDataSource.getTeams()
}