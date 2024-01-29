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
import cn.rtast.qwsdk.entity.indices.IndicesBean
import cn.rtast.qwsdk.exceptions.UnsupportedLanguageException
import cn.rtast.qwsdk.utils.Coordinate
import cn.rtast.qwsdk.utils.get
import cn.rtast.qwsdk.utils.makeParam
import cn.rtast.qwsdk.utils.parseIndices
import com.google.gson.Gson
import kotlin.jvm.Throws

class Indices {

    private val gson = Gson()

    @Throws(UnsupportedLanguageException::class)
    private fun indices(
        days: String,
        location: String,
        lang: QWeatherSDK.Lang = QWeatherSDK.Lang.ZH,
        vararg types: QWeatherSDK.IndicesType = arrayOf(QWeatherSDK.IndicesType.ALL),
    ): IndicesBean {
        val supportedLang = listOf(QWeatherSDK.Lang.ZH, QWeatherSDK.Lang.EN)
        if (lang !in supportedLang) {
            throw UnsupportedLanguageException("Unsupported language: ${lang.name}")
        }
        val typeArray = if (types.contains(QWeatherSDK.IndicesType.ALL)) {
            arrayOf(QWeatherSDK.IndicesType.ALL)
        } else types
        val typeString = typeArray.map { parseIndices(it) }.joinToString(",")
        val url = makeParam(
            "indices/$days",
            mapOf(
                "location" to location,
                "type" to typeString
            )
        )
        val result = get(url)
        return gson.fromJson(result, IndicesBean::class.java)
    }

    @JvmOverloads
    fun indices1d(
        location: String,
        lang: QWeatherSDK.Lang = QWeatherSDK.Lang.ZH,
        vararg types: QWeatherSDK.IndicesType = arrayOf(QWeatherSDK.IndicesType.ALL)
    ): IndicesBean {
        return this.indices("1d", location, lang, *types)
    }

    @JvmOverloads
    fun indices1d(
        location: Coordinate,
        lang: QWeatherSDK.Lang = QWeatherSDK.Lang.ZH,
        vararg types: QWeatherSDK.IndicesType = arrayOf(QWeatherSDK.IndicesType.ALL)
    ): IndicesBean {
        return this.indices1d(location(), lang, *types)
    }

    @JvmOverloads
    fun indices3d(
        location: String,
        lang: QWeatherSDK.Lang = QWeatherSDK.Lang.ZH,
        vararg types: QWeatherSDK.IndicesType = arrayOf(QWeatherSDK.IndicesType.ALL)
    ): IndicesBean {
        return this.indices("3d", location, lang, *types)
    }

    @JvmOverloads
    fun indices3d(
        location: Coordinate,
        lang: QWeatherSDK.Lang = QWeatherSDK.Lang.ZH,
        vararg types: QWeatherSDK.IndicesType = arrayOf(QWeatherSDK.IndicesType.ALL)
    ): IndicesBean {
        return this.indices1d(location(), lang, *types)
    }
}