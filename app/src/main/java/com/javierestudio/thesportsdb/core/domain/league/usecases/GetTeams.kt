package com.javierestudio.thesportsdb.core.domain.league.usecases

import com.javierestudio.thesportsdb.core.domain.league.model.Team
import com.javierestudio.thesportsdb.core.domain.league.repository.TeamsRepository
import javax.inject.Inject

class GetTeams @Inject constructor(private val teamsRepository: TeamsRepository) {
    suspend operator fun invoke(league: Int): List<Team> = teamsRepository.getTeams(league)
}