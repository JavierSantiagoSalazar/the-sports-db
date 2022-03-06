package com.javierestudio.thesportsdb.framework.network.models.matches

import com.google.gson.annotations.SerializedName

data class DataMatchesResponse (
    @SerializedName("results") var results: List<MatchesResponse>
)