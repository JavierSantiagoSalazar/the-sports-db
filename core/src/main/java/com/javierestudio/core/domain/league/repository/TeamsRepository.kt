package com.javierestudio.core.domain.league.repository

import com.javierestudio.core.domain.league.model.Team

interface TeamsRepository {
    suspend fun getTeams(): List<Team>
}