package com.tes.apps.development.aptoideappdownloader.data.remote

import com.tes.apps.development.aptoideappdownloader.data.remote.dto.AppInfoDto
import com.tes.apps.development.aptoideappdownloader.data.remote.dto.AppsListDto
import com.tes.apps.development.aptoideappdownloader.data.remote.dto.AptoideResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface AptoideApi {
    /**
     * get show listing as a list of shows
     */
    @GET(END)
    suspend fun getAppsList(
    ): AptoideResponse

    /**
     * api base url and end point as constant
     */
    companion object {

        const val BASE_URL = "http://ws2.aptoide.com/"
        const val END = "api/6/bulkRequest/api_list/listApps"
    }

}
