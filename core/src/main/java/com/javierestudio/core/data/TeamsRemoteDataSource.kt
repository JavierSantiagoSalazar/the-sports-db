package com.javierestudio.core.data

import com.javierestudio.core.domain.league.model.Team

interface TeamsRemoteDataSource {
    suspend fun getTeams() : List<Team>
}