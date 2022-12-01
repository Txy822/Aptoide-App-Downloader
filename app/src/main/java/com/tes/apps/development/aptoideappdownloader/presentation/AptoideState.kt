package com.tes.apps.development.aptoideappdownloader.presentation

import com.tes.apps.development.aptoideappdownloader.domain.model.AppInfo

data class AptoideState (
    var apps: List<AppInfo> = emptyList(),
    val isLoading:Boolean =false,
)