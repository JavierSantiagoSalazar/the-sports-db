package com.javierestudio.thesportsdb.framework.network.models

import com.google.gson.annotations.SerializedName
import com.javierestudio.core.domain.league.model.Team

data class TeamResponse(

    @SerializedName("idTeam") var idTeam: Int,
    @SerializedName("strTeam") var strTeam: String,
    @SerializedName("strStadium") var strStadium: String,
    @SerializedName("strStadiumThumb") var strStadiumThumb: String,
    @SerializedName("intStadiumCapacity") var intStadiumCapacity: Int,
    @SerializedName("strTeamBadge") var strTeamBadge: String,
    @SerializedName("strDescriptionEN") var strDescriptionEn: String,
    @SerializedName("intFormedYear") var intFormedYear: String,
    @SerializedName("strTeamJersey") var strTeamJersey: String,
    @SerializedName("strWebsite") var strWebsite: String,
    @SerializedName("strFacebook") var strFacebook: String,
    @SerializedName("strTwitter") var strTwitter: String,
    @SerializedName("strInstagram") var strInstagram: String

){
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