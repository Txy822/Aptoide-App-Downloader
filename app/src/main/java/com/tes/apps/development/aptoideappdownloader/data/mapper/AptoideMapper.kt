package com.tes.apps.development.aptoideappdownloader.data.mapper

import com.tes.apps.development.aptoideappdownloader.data.remote.dto.AppInfoDto
import com.tes.apps.development.aptoideappdownloader.domain.model.AppInfo

fun AppInfoDto.toAppInfo(): AppInfo {
    return AppInfo(
        name = name ?: "",
        added = added ?: "",
        downloads = downloads?: 0,
        graphic = graphic?: "",
        icon = icon?: "",
        id = id,
        md5sum = md5sum?: "",
        modified = modified?: "",
        packageX = packageX?: "",
        pdownloads = pdownloads?: 0,
        rating = rating?: 0.0,
        size = size?: 0,
        storeId = storeId?: 0,
        storeName = storeName?: "",
        updated = updated?: "",
        uptype = uptype?: "",
        vercode = vercode?: 0,
        vername = vername?: ""
    )
}
