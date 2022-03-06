package com.javierestudio.thesportsdb.core.data.teams

import com.javierestudio.thesportsdb.core.domain.league.model.Team

interface TeamsLocalDataSource {
    suspend fun saveTeams(teams: List<Team>)
    suspend fun getTeams(): List<Team>
}