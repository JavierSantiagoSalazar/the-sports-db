package com.javierestudio.thesportsdb.core.data.matches

import com.javierestudio.thesportsdb.core.domain.matches.model.Matches
import com.javierestudio.thesportsdb.core.domain.matches.repository.MatchesRepository

class MatchesRepositoryImpl(
    private val remoteDataSource: MatchesRemoteDataSource,
): MatchesRepository {
    override suspend fun getMatches(teamId: Int): List<Matches> = remoteDataSource.getMatches(teamId)
}