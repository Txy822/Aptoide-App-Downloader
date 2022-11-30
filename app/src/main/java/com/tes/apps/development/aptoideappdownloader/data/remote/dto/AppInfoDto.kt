package com.tes.apps.development.aptoideappdownloader.data.remote.dto


import com.google.gson.annotations.SerializedName

data class AppInfoDto(
    @SerializedName("added")
    val added: String = "",
    @SerializedName("apk_tags")
    val apkTags: List<String> = listOf(),
    @SerializedName("downloads")
    val downloads: Int = 0,
    @SerializedName("graphic")
    val graphic: String = "",
    @SerializedName("icon")
    val icon: String = "",
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("md5sum")
    val md5sum: String = "",
    @SerializedName("modified")
    val modified: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("package")
    val packageX: String = "",
    @SerializedName("pdownloads")
    val pdownloads: Int = 0,
    @SerializedName("rating")
    val rating: Double = 0.0,
    @SerializedName("size")
    val size: Int = 0,
    @SerializedName("store_id")
    val storeId: Int = 0,
    @SerializedName("store_name")
    val storeName: String = "",
    @SerializedName("updated")
    val updated: String = "",
    @SerializedName("uptype")
    val uptype: String = "",
    @SerializedName("vercode")
    val vercode: Int = 0,
    @SerializedName("vername")
    val vername: String = ""
)