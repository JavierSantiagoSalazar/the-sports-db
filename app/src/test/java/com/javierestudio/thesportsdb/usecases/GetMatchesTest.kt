package com.javierestudio.thesportsdb.usecases

import com.javierestudio.thesportsdb.core.domain.league.repository.TeamsRepository
import com.javierestudio.thesportsdb.core.domain.matches.repository.MatchesRepository
import com.javierestudio.thesportsdb.core.domain.matches.usecases.GetMatches
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.internal.matchers.Matches
import org.mockito.junit.MockitoJUnitRunner
import org.robolectric.annotation.Config


@RunWith(MockitoJUnitRunner::class)
@Config(manifest = Config.NONE)
class GetMatchesTest {

    @Mock
    private lateinit var matchesRepository: MatchesRepository

    @InjectMocks
    private lateinit var getMatches: GetMatches

    @Test
    fun  invokeTest() = runBlocking {
        val teamId = 13470
        val list = ArrayList<com.javierestudio.thesportsdb.core.domain.matches.model.Matches>()
        val match = Mockito.mock(com.javierestudio.thesportsdb.core.domain.matches.model.Matches::class.java)
        list.add(match)

        `when`(matchesRepository.getMatches(teamId)).thenReturn(list)

        val matchesList = getMatches.invoke(teamId)

        Assert.assertNotNull(matchesList)
        Assert.assertEquals(matchesList, list)
    }
}