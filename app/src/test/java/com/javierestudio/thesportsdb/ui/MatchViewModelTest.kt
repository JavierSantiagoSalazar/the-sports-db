package com.javierestudio.thesportsdb.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.javierestudio.thesportsdb.MainCoroutineRule
import com.javierestudio.thesportsdb.core.domain.matches.model.Matches
import com.javierestudio.thesportsdb.core.domain.matches.usecases.GetMatches
import com.javierestudio.thesportsdb.ui.detailsModule.DetailsViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito

@ExperimentalCoroutinesApi
class MatchViewModelTest {

    private val testDispatcher = TestCoroutineDispatcher()

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule(testDispatcher)

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var getMatches: GetMatches

    private lateinit var viewModel: DetailsViewModel

    @Before
    fun setUp(){
        viewModel = DetailsViewModel(getMatches)
    }

    @Test
    fun whenGetMatchesIsCalledShouldModifyLiveData(){
        val teamId = 17421
        val match = Mockito.mock(Matches::class.java)
        val matchList = ArrayList<Matches>()
        matchList.add(match)

        viewModel.getAllMatches(teamId)

        Mockito.verify(viewModel.getAllMatches(teamId))

        Assert.assertEquals(matchList, viewModel.matchesResponse.value)

    }

}