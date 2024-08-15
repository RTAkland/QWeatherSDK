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
import cn.rtast.qwsdk.entity.indices.IndicesEntity
import cn.rtast.qwsdk.enums.IndicesType
import cn.rtast.qwsdk.enums.Lang
import cn.rtast.qwsdk.exceptions.UnsupportedLanguageException
import cn.rtast.qwsdk.utils.Coordinate
import cn.rtast.qwsdk.utils.Http

object Indices {

    @Throws(UnsupportedLanguageException::class)
    private fun indices(
        days: String,
        location: String,
        lang: Lang = Lang.ZH,
        types: List<IndicesType> = listOf(IndicesType.ALL),
    ): IndicesEntity {
        val supportedLang = listOf(Lang.ZH, Lang.EN)
        if (lang !in supportedLang) {
            throw UnsupportedLanguageException("Unsupported language: ${lang.name}")
        }
        val typeArray = if (types.contains(IndicesType.ALL)) {
            listOf(IndicesType.ALL)
        } else types
        val typeString = typeArray.joinToString(",") { it.type.toString() }
        return Http.get<IndicesEntity>(
            QWeatherSDK.rootAPI + "indices/$days",
            params = mapOf(
                "location" to location,
                "lang" to lang.toString(),
                "type" to typeString,
            )
        )
    }

    @JvmOverloads
    @Throws(UnsupportedLanguageException::class)
    fun indices1d(
        location: String,
        lang: Lang = Lang.ZH,
        types: List<IndicesType> = listOf(IndicesType.ALL),
    ): IndicesEntity {
        return this.indices("1d", location, lang, types)
    }

    @JvmOverloads
    @Throws(UnsupportedLanguageException::class)
    fun indices1d(
        location: Coordinate,
        lang: Lang = Lang.ZH,
        types: List<IndicesType> = listOf(IndicesType.ALL),
    ): IndicesEntity {
        return this.indices1d(location(), lang, types)
    }

    @JvmOverloads
    @Throws(UnsupportedLanguageException::class)
    fun indices3d(
        location: String,
        lang: Lang = Lang.ZH,
        types: List<IndicesType> = listOf(IndicesType.ALL),
    ): IndicesEntity {
        return this.indices("3d", location, lang, types)
    }

    @JvmOverloads
    @Throws(UnsupportedLanguageException::class)
    fun indices3d(
        location: Coordinate,
        lang: Lang = Lang.ZH,
        types: List<IndicesType> = listOf(IndicesType.ALL),
    ): IndicesEntity {
        return this.indices1d(location(), lang, types)
    }
}