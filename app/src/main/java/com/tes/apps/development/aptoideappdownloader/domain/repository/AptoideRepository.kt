package com.tes.apps.development.aptoideappdownloader.domain.repository

import com.tes.apps.development.aptoideappdownloader.data.remote.dto.AppInfoDto
import com.tes.apps.development.aptoideappdownloader.domain.model.AppInfo
import com.tes.apps.development.aptoideappdownloader.util.Resource
import kotlinx.coroutines.flow.Flow

interface AptoideRepository {

    suspend fun  getAppsList(
    ): Flow<Resource<List<AppInfo>>>
}