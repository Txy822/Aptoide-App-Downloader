package com.tes.apps.development.aptoideappdownloader.domain.model

import com.google.gson.annotations.SerializedName
//plain kotlin class to show in the ui which is independant of data layer
data class AppInfo(
    val added: String? = "",
    val downloads: Long? = 0,
    val graphic: String? = "",
    val icon: String? = "",
    val id: Long? = 0,
    val md5sum: String? = "",
    val modified: String? = "",
    val name: String? = "",
    val packageX: String? = "",
    val pdownloads: Long? = 0,
    val rating: Double? = 0.0,
    val size: Long? = 0,
    val storeId: Long? = 0,
    val storeName: String? = "",
    val updated: String? = "",
    val uptype: String? = "",
    val vercode: Long? = 0,
    val vername: String? = ""
)
