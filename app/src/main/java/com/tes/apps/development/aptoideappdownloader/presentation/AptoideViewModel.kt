package com.tes.apps.development.aptoideappdownloader.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tes.apps.development.aptoideappdownloader.domain.model.AppInfo
import com.tes.apps.development.aptoideappdownloader.domain.repository.AptoideRepository
import com.tes.apps.development.aptoideappdownloader.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


@HiltViewModel
class AptoideViewModel(
    private val repository: AptoideRepository,
):ViewModel() {
    private var _data: MutableStateFlow<Resource<List<AppInfo>>> =
        MutableStateFlow(Resource.Loading())
    var data: StateFlow<Resource<List<AppInfo>>> = _data

    fun getAppList() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAppsList().collect() {
                _data.value = it
            }
        }
    }

}