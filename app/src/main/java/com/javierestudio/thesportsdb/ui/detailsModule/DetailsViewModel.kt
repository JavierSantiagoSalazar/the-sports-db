package com.javierestudio.thesportsdb.ui.detailsModule

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.javierestudio.thesportsdb.framework.utils.DataException
import com.javierestudio.thesportsdb.framework.utils.TypeError
import com.javierestudio.thesportsdb.core.domain.matches.model.Matches
import com.javierestudio.thesportsdb.core.domain.matches.usecases.GetMatches
import com.javierestudio.thesportsdb.framework.utils.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(private val getMatches: GetMatches) : ViewModel() {
    private val _matchesResponse = MutableLiveData<List<Matches>>()
    private val _isVisible = MutableLiveData<Boolean>()
    private val _typeError: MutableLiveData<TypeError> = MutableLiveData()

    val matchesResponse: LiveData<List<Matches>> get() = _matchesResponse
    val isVisible: LiveData<Boolean> get() = _isVisible
    val typeError: LiveData<TypeError> get() = _typeError

    fun getAllMatches(teamId: Int) {
        viewModelScope.launch {
            _isVisible.value = Constants.SHOW
            try {
                _matchesResponse.value = getMatches(teamId)
            } catch (e: DataException) {
                _typeError.value = e.typeError
            } finally {
                _isVisible.value = Constants.HIDE
            }
        }
    }
}