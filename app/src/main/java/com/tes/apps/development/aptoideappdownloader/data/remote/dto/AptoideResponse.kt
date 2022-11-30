package com.tes.apps.development.aptoideappdownloader.data.remote.dto


import com.google.gson.annotations.SerializedName

data class AptoideResponse(
    @SerializedName("responses")
    val responses: Responses = Responses(),
    @SerializedName("status")
    val status: String = ""
)
data class All(
    @SerializedName("data")
    val `data`: AppsListDto = AppsListDto(),
    @SerializedName("info")
    val info: InfoX = InfoX()
)



data class Datasets(
    @SerializedName("all")
    val all: All = All()
)

data class InfoX(
    @SerializedName("status")
    val status: String = "",
    @SerializedName("time")
    val time: Time = Time()
)

data class ListApps(
    @SerializedName("datasets")
    val datasets: Datasets = Datasets(),
    @SerializedName("info")
    val info: InfoX = InfoX()
)

data class Responses(
    @SerializedName("listApps")
    val listApps: ListApps = ListApps()
)

data class Time(
    @SerializedName("human")
    val human: String = "",
    @SerializedName("seconds")
    val seconds: Double = 0.0
)