package com.javierestudio.thesportsdb.framework.network.services

import com.javierestudio.thesportsdb.framework.network.models.matches.DataMatchesResponse
import com.javierestudio.thesportsdb.framework.network.models.teams.DataTeamsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {

    @GET
    suspend fun getAllTeams(@Url url: String): Response<DataTeamsResponse>

    @GET
    suspend fun getAllMatches(@Url url: String): Response<DataMatchesResponse>

}