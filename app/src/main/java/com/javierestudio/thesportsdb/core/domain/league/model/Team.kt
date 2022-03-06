package com.javierestudio.thesportsdb.core.domain.league.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Team(
    var idTeam: Int,
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
) : Parcelable
