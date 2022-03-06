package com.javierestudio.thesportsdb.ui.teamModule.adapters

import com.javierestudio.thesportsdb.core.domain.league.model.Team

interface OnTeamClick {
    fun showTeamDetails(team: Team)
}