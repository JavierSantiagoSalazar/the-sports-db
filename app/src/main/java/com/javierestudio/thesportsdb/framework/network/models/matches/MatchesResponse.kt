package com.javierestudio.thesportsdb.framework.network.models.matches

import com.google.gson.annotations.SerializedName
import com.javierestudio.thesportsdb.core.domain.matches.model.Matches

data class MatchesResponse(
    @SerializedName("idEvent") var idEvent: Int,
    @SerializedName("strEvent") var strEvent: String,
    @SerializedName("dateEvent") var dateEvent: String,
    @SerializedName("strTime") var strTime: String,
    @SerializedName("strVenue") var strVenue: String
) {
    fun mapToDomain(): Matches = Matches(
        idEvent = idEvent,
        strEvent = strEvent,
        dateEvent = dateEvent,
        strTime = strTime,
        strVenue = strVenue
    )
}