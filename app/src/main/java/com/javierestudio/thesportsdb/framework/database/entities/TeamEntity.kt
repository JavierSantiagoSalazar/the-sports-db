package com.javierestudio.thesportsdb.framework.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.javierestudio.thesportsdb.core.domain.league.model.Team

@Entity(tableName = "TeamEntity")
data class TeamEntity(
    @PrimaryKey var idTeam: Int,
    var strTeam: String,
    var strStadium: String,
    var strStadiumThumb: String,
    var intStadiumCapacity: Int,
    var strTeamBadge: String,
    var strDescriptionEn: String,
    var intFormedYear: String,
    var strTeamJersey: String,
    var strWebsite: String?,
    var strFacebook: String?,
    var strTwitter: String?,
    var strInstagram: String?
) {
    constructor(team: Team) : this(
        team.idTeam,
        team.strTeam,
        team.strStadium,
        team.strStadiumThumb,
        team.intStadiumCapacity,
        team.strTeamBadge,
        team.strDescriptionEn,
        team.intFormedYear,
        team.strTeamJersey,
        team.strWebsite,
        team.strFacebook,
        team.strTwitter,
        team.strInstagram,
    )

    fun mapToDomain(): Team = Team(
        idTeam = idTeam,
        strTeam = strTeam,
        strStadium = strStadium,
        strStadiumThumb = strStadiumThumb,
        intStadiumCapacity = intStadiumCapacity,
        strTeamBadge = strTeamBadge,
        strDescriptionEn = strDescriptionEn,
        intFormedYear = intFormedYear,
        strTeamJersey = strTeamJersey,
        strWebsite = strWebsite,
        strFacebook = strFacebook,
        strTwitter = strTwitter,
        strInstagram = strInstagram
    )
}
