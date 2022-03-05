package com.javierestudio.core.data

import com.javierestudio.core.domain.league.model.Team
import com.javierestudio.core.domain.league.repository.TeamsRepository

class TeamsRepositoryImpl(
    private val remoteDataSource: TeamsRemoteDataSource,
): TeamsRepository {
    override suspend fun getTeams(): List<Team> = remoteDataSource.getTeams()
}