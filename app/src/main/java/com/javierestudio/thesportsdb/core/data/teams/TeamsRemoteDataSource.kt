package com.javierestudio.thesportsdb.core.data.teams

import com.javierestudio.thesportsdb.core.domain.league.model.Team

interface TeamsRemoteDataSource {
    suspend fun getTeams() : List<Team>
}