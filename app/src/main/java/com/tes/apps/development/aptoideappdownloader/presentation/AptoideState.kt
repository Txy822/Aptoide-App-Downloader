package com.tes.apps.development.aptoideappdownloader.presentation

import com.tes.apps.development.aptoideappdownloader.domain.model.AppInfo

//class that represents everything to UI state on specific screen
data class AptoideState (
    var apps: List<AppInfo> = emptyList(),
    val isLoading:Boolean =false,
)