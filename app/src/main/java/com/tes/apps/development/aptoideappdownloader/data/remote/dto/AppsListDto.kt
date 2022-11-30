package com.tes.apps.development.aptoideappdownloader.data.remote.dto


import com.google.gson.annotations.SerializedName

data class AppsListDto(
    @SerializedName("hidden")
    val hidden: Int = 0,
    @SerializedName("limit")
    val limit: Int = 0,
    @SerializedName("list")
    val list: List<AppInfoDto> = listOf(),
    @SerializedName("next")
    val next: Int = 0,
    @SerializedName("offset")
    val offset: Int = 0,
    @SerializedName("total")
    val total: Int = 0
)