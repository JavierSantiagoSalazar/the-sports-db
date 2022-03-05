package com.javierestudio.core.domain.league.usecases

import com.javierestudio.core.domain.league.model.Team
import com.javierestudio.core.domain.league.repository.TeamsRepository
import javax.inject.Inject

class GetTeams @Inject constructor(private val teamsRepository: TeamsRepository) {
    suspend operator fun invoke(): List<Team> = teamsRepository.getTeams()
}