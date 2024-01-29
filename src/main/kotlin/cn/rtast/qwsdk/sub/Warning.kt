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

package cn.rtast.qwsdk.sub

import cn.rtast.qwsdk.QWeatherSDK
import cn.rtast.qwsdk.entity.warning.WarningBean
import cn.rtast.qwsdk.entity.warning.list.WarningCityListBean
import cn.rtast.qwsdk.exceptions.UnsupportedLanguageException
import cn.rtast.qwsdk.utils.Coordinate
import cn.rtast.qwsdk.utils.get
import cn.rtast.qwsdk.utils.makeParam
import com.google.gson.Gson

class Warning {

    private val gson = Gson()

    @JvmOverloads
    fun now(
        location: String,
        lang: QWeatherSDK.Lang = QWeatherSDK.Lang.ZH
    ): WarningBean {
        val supportedLang = listOf(QWeatherSDK.Lang.ZH, QWeatherSDK.Lang.EN)
        if (lang !in supportedLang) {
            throw UnsupportedLanguageException("Unsupported language: ${lang.name}")
        }
        val url = makeParam(
            "warning/now",
            mapOf(
                "location" to location,
                "lang" to lang
            )
        )
        val result = get(url)
        return gson.fromJson(result, WarningBean::class.java)
    }

    @JvmOverloads
    fun now(
        location: Coordinate,
        lang: QWeatherSDK.Lang = QWeatherSDK.Lang.ZH
    ): WarningBean {
        return this.now(location(), lang)
    }

    @JvmOverloads
    fun list(
        range: QWeatherSDK.CountryCode = QWeatherSDK.CountryCode.CN
    ): WarningCityListBean {
        val url = makeParam(
            "warning/list",
            mapOf("range" to range)
        )
        val result = get(url)
        return gson.fromJson(result, WarningCityListBean::class.java)
    }
}