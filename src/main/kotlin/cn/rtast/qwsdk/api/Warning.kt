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

package cn.rtast.qwsdk.api

import cn.rtast.qwsdk.QWeatherSDK
import cn.rtast.qwsdk.entity.warning.WarningEntity
import cn.rtast.qwsdk.entity.warning.list.WarningCityListEntity
import cn.rtast.qwsdk.enums.CountryCode
import cn.rtast.qwsdk.enums.Lang
import cn.rtast.qwsdk.exceptions.UnsupportedLanguageException
import cn.rtast.qwsdk.utils.Coordinate
import cn.rtast.qwsdk.utils.Http
import cn.rtast.qwsdk.utils.makeParam

object Warning {

    @JvmOverloads
    @Throws(UnsupportedLanguageException::class)
    fun now(
        location: String,
        lang: Lang = Lang.ZH,
    ): WarningEntity {
        val supportedLang = listOf(Lang.ZH, Lang.EN)
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
        val result = Http.get(url)
        return QWeatherSDK.gson.fromJson(result, WarningEntity::class.java)
    }

    @JvmOverloads
    @Throws(UnsupportedLanguageException::class)
    fun now(
        location: Coordinate,
        lang: Lang = Lang.ZH,
    ): WarningEntity {
        return this.now(location(), lang)
    }

    @JvmOverloads
    fun list(
        range: CountryCode = CountryCode.CN,
    ): WarningCityListEntity {
        val url = makeParam(
            "warning/list",
            mapOf("range" to range)
        )
        val result = Http.get(url)
        return QWeatherSDK.gson.fromJson(result, WarningCityListEntity::class.java)
    }
}