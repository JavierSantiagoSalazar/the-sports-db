package com.javierestudio.thesportsdb.framework.network.datasource

import com.javierestudio.thesportsdb.framework.utils.DataException
import com.javierestudio.thesportsdb.framework.utils.TypeError
import com.javierestudio.thesportsdb.core.data.matches.MatchesRemoteDataSource
import com.javierestudio.thesportsdb.core.domain.matches.model.Matches
import com.javierestudio.thesportsdb.framework.network.services.APIService
import com.javierestudio.thesportsdb.framework.utils.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MatchesRemoteDataSourceImpl(private val apiService: APIService) : MatchesRemoteDataSource {
    override suspend fun getMatches(teamId: Int): List<Matches> = withContext(Dispatchers.IO) {
        val url: String = Constants.URL_BASE + Constants.URL_MATCHES + teamId.toString()
        try {
            val matches = apiService.getAllMatches(url)
            matches.body()?.results?.map { it.mapToDomain() } ?: emptyList()
        } catch (e: DataException) {
            throw DataException(TypeError.GET)
        }
    }
}