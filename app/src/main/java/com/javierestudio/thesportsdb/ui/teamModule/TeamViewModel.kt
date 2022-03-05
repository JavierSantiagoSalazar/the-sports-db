package com.javierestudio.thesportsdb.ui.teamModule

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.javierestudio.appsosafe.framework.utils.DataException
import com.javierestudio.appsosafe.framework.utils.TypeError
import com.javierestudio.core.domain.league.model.Team
import com.javierestudio.core.domain.league.usecases.GetTeams
import com.javierestudio.thesportsdb.framework.utils.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TeamViewModel @Inject constructor(private val getTeams: GetTeams) : ViewModel() {

    private val _teamsResponse = MutableLiveData<List<Team>>()
    private val _isVisible = MutableLiveData<Boolean>()
    private val _typeError: MutableLiveData<TypeError> = MutableLiveData()

    val teamsResponse: LiveData<List<Team>> get() = _teamsResponse
    val isVisible:  LiveData<Boolean> get() = _isVisible
    val typeError:  LiveData<TypeError> get() = _typeError

    fun getAllTeams() {
        viewModelScope.launch {
            _isVisible.value = Constants.SHOW
            try {
                _teamsResponse.value = getTeams()
            } catch (e: DataException) {
                _typeError.value = e.typeError
            } finally {
                _isVisible.value = Constants.HIDE
            }
        }
    }
}