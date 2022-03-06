package com.javierestudio.thesportsdb.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.javierestudio.thesportsdb.MainCoroutineRule
import com.javierestudio.thesportsdb.core.data.teams.TeamsRepositoryImpl
import com.javierestudio.thesportsdb.core.domain.league.model.Team
import com.javierestudio.thesportsdb.core.domain.league.repository.TeamsRepository
import com.javierestudio.thesportsdb.core.domain.league.usecases.GetTeams
import com.javierestudio.thesportsdb.core.domain.matches.model.Matches
import com.javierestudio.thesportsdb.ui.teamModule.TeamViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify

@ExperimentalCoroutinesApi
class TeamViewModelTest {

    private val testDispatcher = TestCoroutineDispatcher()

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule(testDispatcher)

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var getTeams: GetTeams

    private lateinit var viewModel: TeamViewModel

    @Before
    fun setUp(){
        viewModel = TeamViewModel(getTeams)
    }

    @Test
    fun whenGetTeamsIsCalledShouldModifyLiveData(){
        val league = 2
        val match = Mockito.mock(Team::class.java)
        val teamList = ArrayList<Team>()
        teamList.add(match)

        viewModel.getAllTeams(league)

        verify(viewModel.getAllTeams(league))

        Assert.assertEquals(teamList, viewModel.teamsResponse.value)

    }

}