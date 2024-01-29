/*
 * Copyright 2023 RTAkland
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package cn.rtast.qwsdk.utils

import cn.rtast.qwsdk.QWeatherSDK

/**
 * 构建请求字符串。
 */
fun makeParam(prefix: String, params: Map<String, Any?>, type: QWeatherSDK.ApiType = QWeatherSDK.ApiType.Common): String {
    val rootUrl = if (type == QWeatherSDK.ApiType.Common) {
        QWeatherSDK.rootAPI
    } else {
        QWeatherSDK.geoAPI
    }
    val url: StringBuilder = StringBuilder("$rootUrl/$prefix?")
    // 添加用户 key
    val urlParams = params.plus("key" to QWeatherSDK.key)
            .filterValues { it != null }.toList().joinToString("&") { (k, v) -> "$k=$v" }
    url.append(urlParams)
    return url.toString()
}