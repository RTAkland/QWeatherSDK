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

import cn.rtast.qwsdk.Global
import cn.rtast.qwsdk.enums.*
import cn.rtast.qwsdk.enums.Unit

fun make(prefix: String, params: Map<String, Any?>, type: ApiType = ApiType.Common): String {
    var result = ""
    for ((k, v) in params.entries) {
        var value = v
        value = when (value) {
            is BasinType -> value.name.lowercase()
            is CountryCode -> value.name.lowercase()
            is Lang -> value.name.lowercase()
            is Unit -> value.name.lowercase()
            else -> v
        }
        if (v != null) {  // if null then pass it
            result += "$k=$value&"
        }
    }
    val param = "$prefix/?key=${Global.key}&${result.substring(0, result.length - 1)}"
    return if (type == ApiType.Common) {
        "${Global.rootAPI}/$param"
    } else {
        "${Global.geoAPI}/$param"
    }
}
