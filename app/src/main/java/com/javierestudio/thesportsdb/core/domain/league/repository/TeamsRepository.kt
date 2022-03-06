package com.javierestudio.thesportsdb.core.domain.league.repository

import com.javierestudio.thesportsdb.core.domain.league.model.Team

interface TeamsRepository {
    suspend fun getTeams(league: Int): List<Team>
}