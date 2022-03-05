package com.javierestudio.thesportsdb.framework.network.services

import com.javierestudio.thesportsdb.framework.network.models.DataTeamsResponse
import com.javierestudio.thesportsdb.framework.network.models.TeamResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {

    @GET
    suspend fun getAllTeams(@Url url: String): Response<DataTeamsResponse>

}