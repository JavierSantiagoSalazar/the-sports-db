package com.javierestudio.thesportsdb.usecases

import com.javierestudio.thesportsdb.core.domain.league.model.Team
import com.javierestudio.thesportsdb.core.domain.league.repository.TeamsRepository
import com.javierestudio.thesportsdb.core.domain.league.usecases.GetTeams
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
class GetTeamsTests {

    @Mock
    private lateinit var teamRepository: TeamsRepository

    @InjectMocks
    private lateinit var getTeams: GetTeams

    @Test
    fun checkInvokeFunTest() = runBlocking {
        val league = 2
        val teamList = ArrayList<Team>()
        val team = Mockito.mock(Team::class.java)
        teamList.add(team)

        `when`(teamRepository.getTeams(league)).thenReturn(teamList)

        val list = getTeams.invoke(league)

        Assert.assertNotNull(list)
        Assert.assertEquals(list, teamList)
    }
}