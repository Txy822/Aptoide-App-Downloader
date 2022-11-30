package com.tes.apps.development.aptoideappdownloader.data.mapper

import com.tes.apps.development.aptoideappdownloader.data.remote.dto.AppInfoDto
import com.tes.apps.development.aptoideappdownloader.domain.model.AppInfo

fun AppInfoDto.toAppInfo(): AppInfo {
    return AppInfo(
        name = name ?: "",
        added = added ?: "",
        apkTags = apkTags,
        downloads = downloads,
        graphic = graphic,
        icon = icon,
        id = id,
        md5sum = md5sum,
        modified = modified,
        packageX = packageX,
        pdownloads = pdownloads,
        rating = rating,
        size = size,
        storeId = storeId,
        storeName = storeName,
        updated = updated,
        uptype = uptype,
        vercode = vercode,
        vername = vername
    )
}
