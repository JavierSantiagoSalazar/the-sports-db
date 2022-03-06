package com.javierestudio.thesportsdb.core.domain.matches.usecases

import com.javierestudio.thesportsdb.core.domain.matches.model.Matches
import com.javierestudio.thesportsdb.core.domain.matches.repository.MatchesRepository
import javax.inject.Inject

class GetMatches @Inject constructor (private val matchesRepository: MatchesRepository) {
    suspend operator fun invoke(teamId: Int): List<Matches> = matchesRepository.getMatches(teamId)
}