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
import cn.rtast.qwsdk.entity.warning.WarningCityListEntity
import cn.rtast.qwsdk.entity.warning.WarningEntity
import cn.rtast.qwsdk.enums.CountryCode
import cn.rtast.qwsdk.enums.Lang
import cn.rtast.qwsdk.exceptions.UnsupportedLanguageException
import cn.rtast.qwsdk.utils.Coordinate
import cn.rtast.qwsdk.utils.Http

object Warning {

    private val supportedLang = listOf(Lang.ZH, Lang.EN)

    private fun check(lang: Lang) {
        if (lang !in supportedLang) {
            throw UnsupportedLanguageException("Unsupported language: ${lang.name}")
        }
    }

    @JvmOverloads
    @Throws(UnsupportedLanguageException::class)
    fun now(location: String, lang: Lang = Lang.ZH): WarningEntity {
        this.check(lang)
        return Http.get<WarningEntity>(
            QWeatherSDK.rootAPI + "warning/now",
            params = mapOf(
                "location" to location,
                "lang" to lang.toString(),
            )
        )
    }

    @JvmOverloads
    @Throws(UnsupportedLanguageException::class)
    fun nowAsync(
        location: String,
        lang: Lang = Lang.ZH,
        onRequest: (WarningEntity?) -> Unit
    ) {
        this.check(lang)
        Http.getAsync<WarningEntity>(
            QWeatherSDK.rootAPI + "warning/now",
            params = mapOf(
                "location" to location,
                "lang" to lang.toString(),
            )
        ) { onRequest(it) }
    }

    @JvmOverloads
    @Throws(UnsupportedLanguageException::class)
    fun now(location: Coordinate, lang: Lang = Lang.ZH): WarningEntity {
        return this.now(location(), lang)
    }

    @JvmOverloads
    @Throws(UnsupportedLanguageException::class)
    fun nowAsync(
        location: Coordinate,
        lang: Lang = Lang.ZH,
        onRequest: (WarningEntity?) -> Unit
    ) {
        this.nowAsync(location(), lang) { onRequest }
    }

    @JvmOverloads
    fun list(range: CountryCode = CountryCode.CN): WarningCityListEntity {
        return Http.get<WarningCityListEntity>(
            QWeatherSDK.rootAPI + "warning/list",
            params = mapOf("range" to range)
        )
    }

    @JvmOverloads
    fun listAsync(
        range: CountryCode = CountryCode.CN,
        onRequest: (WarningCityListEntity?) -> Unit
    ) {
        Http.getAsync<WarningCityListEntity>(
            QWeatherSDK.rootAPI + "warning/list",
            params = mapOf("range" to range)
        ) { onRequest(it) }
    }
}