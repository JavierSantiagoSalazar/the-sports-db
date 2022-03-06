package com.javierestudio.thesportsdb.core.data.matches

import com.javierestudio.thesportsdb.core.domain.matches.model.Matches

interface MatchesRemoteDataSource {
    suspend fun getMatches(teamId:Int) : List<Matches>
}