package com.tes.apps.development.aptoideappdownloader.data.repository

import com.tes.apps.development.aptoideappdownloader.data.mapper.toAppInfo
import com.tes.apps.development.aptoideappdownloader.data.remote.AptoideApi
import com.tes.apps.development.aptoideappdownloader.data.remote.dto.AppInfoDto
import com.tes.apps.development.aptoideappdownloader.domain.model.AppInfo
import com.tes.apps.development.aptoideappdownloader.domain.repository.AptoideRepository
import com.tes.apps.development.aptoideappdownloader.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class AptoideRepositoryImpl @Inject constructor(
    private val api: AptoideApi,
) : AptoideRepository {
    override suspend fun getAppsList(): Flow<Resource<List<AppInfo>>> {
        return flow {
            emit(Resource.Loading(true))
            val remoteListings = try {
                api.getAppsList().responses.listApps.datasets.all.data.list
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Resource.Error("Couldn't load data"))
                null // flow{null}
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Resource.Error("Couldn't load data"))
                null // flow{null}
            }

            remoteListings?.let { listings ->
                val list=listings.map { it.toAppInfo()}
                emit(Resource.Success(list))
                emit(Resource.Loading(false))
            }
        }
    }
}