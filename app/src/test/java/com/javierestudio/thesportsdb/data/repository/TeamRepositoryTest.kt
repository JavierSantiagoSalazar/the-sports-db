package com.javierestudio.thesportsdb.data.repository

import com.javierestudio.thesportsdb.core.data.teams.TeamsLocalDataSource
import com.javierestudio.thesportsdb.core.data.teams.TeamsRemoteDataSource
import com.javierestudio.thesportsdb.core.data.teams.TeamsRepositoryImpl
import com.javierestudio.thesportsdb.core.domain.league.model.Team
import com.javierestudio.thesportsdb.core.domain.league.repository.TeamsRepository
import com.javierestudio.thesportsdb.framework.database.datasource.TeamsLocalDataSourceImpl
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import org.robolectric.annotation.Config

@RunWith(MockitoJUnitRunner::class)
@Config(manifest = Config.NONE)
class TeamRepositoryTest {

    @Mock
    private lateinit var localDataSource: TeamsLocalDataSource

    @Mock
    private lateinit var remoteDataSource: TeamsRemoteDataSource

    @InjectMocks
    private lateinit var teamsRepository: TeamsRepositoryImpl

    @Test
    fun getTeamsRemoteReturnsNotNull() = runBlocking {
        val league = 2
        val team = Mockito.mock(Team::class.java)
        val teamList = ArrayList<Team>()
        teamList.add(team)

        `when`(remoteDataSource.getTeams(league)).thenReturn(teamList)

        val expected = teamsRepository.getTeams(league)

        Assert.assertNotNull(expected)
    }

    @Test
    fun getTeamsLocalReturnsNotNull() = runBlocking {
        val league = 2
        val team = Mockito.mock(Team::class.java)
        val teamList = ArrayList<Team>()
        teamList.add(team)

        `when`(localDataSource.getTeams()).thenReturn(teamList).thenReturn(teamList)

        val expected = teamsRepository.getTeams(league)

        Assert.assertNotNull(expected)
    }

}