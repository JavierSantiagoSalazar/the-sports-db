package com.javierestudio.thesportsdb.core.domain.matches.repository

import com.javierestudio.thesportsdb.core.domain.matches.model.Matches

interface MatchesRepository {
    suspend fun getMatches(teamId: Int): List<Matches>
}