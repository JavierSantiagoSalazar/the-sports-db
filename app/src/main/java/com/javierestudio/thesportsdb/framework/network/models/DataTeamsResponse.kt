package com.javierestudio.thesportsdb.framework.network.models

import com.google.gson.annotations.SerializedName

data class DataTeamsResponse(

    @SerializedName("teams") var teams: List<TeamResponse>
)
