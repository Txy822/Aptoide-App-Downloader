package com.tes.apps.development.aptoideappdownloader.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tes.apps.development.aptoideappdownloader.domain.repository.AptoideRepository
import com.tes.apps.development.aptoideappdownloader.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class AptoideViewModel @Inject constructor(
    private val repository: AptoideRepository,

    ) : ViewModel() {
    //state has ShowListingState type here
    var state by mutableStateOf(AptoideState())

    init {
        //to load initially for the first time
        getAppList()
    }

    /**
     * Show Listing function based on search query or boolean value
     */
    fun getAppList()
    {
        viewModelScope.launch(Dispatchers.Main) {
            //call repository method here
            repository.getAppsList()
                .collect { result ->
                    when (result) {
                        is Resource.Success -> {
                            result.data?.let { listings ->
                                state = state.copy( // copy of  current state so that we can change the listing that way we can still keep immutable state  without having var field which is helpful in multi-threading so that we don't get race condition
                                    apps = listings
                                )
                            }
                            state = state.copy()
                        }
                        is Resource.Error -> Unit
                        is Resource.Loading -> {
                            state = state.copy(isLoading = result.isLoading)
                        }
                    }
                }
        }
    }
}