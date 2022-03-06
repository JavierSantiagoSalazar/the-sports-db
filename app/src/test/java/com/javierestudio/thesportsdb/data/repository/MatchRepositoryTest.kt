package com.javierestudio.thesportsdb.data.repository

import com.javierestudio.thesportsdb.core.data.matches.MatchesRemoteDataSource
import com.javierestudio.thesportsdb.core.data.matches.MatchesRepositoryImpl
import com.javierestudio.thesportsdb.core.data.teams.TeamsLocalDataSource
import com.javierestudio.thesportsdb.core.data.teams.TeamsRemoteDataSource
import com.javierestudio.thesportsdb.core.data.teams.TeamsRepositoryImpl
import com.javierestudio.thesportsdb.core.domain.league.model.Team
import com.javierestudio.thesportsdb.core.domain.matches.model.Matches
import com.javierestudio.thesportsdb.core.domain.matches.repository.MatchesRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import org.robolectric.annotation.Config

@RunWith(MockitoJUnitRunner::class)
@Config(manifest = Config.NONE)
class MatchRepositoryTest {

    @Mock
    private lateinit var remoteDataSource: MatchesRemoteDataSource

    @InjectMocks
    private lateinit var teamsRepository: MatchesRepositoryImpl

    @Test
    fun getTeamsRemoteReturnsNotNull() = runBlocking {
        val teamId = 13741
        val match = Mockito.mock(Matches::class.java)
        val matchList = ArrayList<Matches>()
        matchList.add(match)

        Mockito.`when`(remoteDataSource.getMatches(teamId)).thenReturn(matchList)

        val expected = teamsRepository.getMatches(teamId)

        Assert.assertNotNull(expected)
    }
}