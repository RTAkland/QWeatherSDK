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
import cn.rtast.qwsdk.entity.air.AirDailyEntity
import cn.rtast.qwsdk.entity.air.AirEntity
import cn.rtast.qwsdk.enums.Lang
import cn.rtast.qwsdk.utils.Coordinate
import cn.rtast.qwsdk.utils.Http
import cn.rtast.qwsdk.utils.makeParam

object Air {

    @JvmOverloads
    fun now(
        location: String,
        lang: Lang = Lang.ZH,
    ): AirEntity {
        val url = makeParam(
            "air/now",
            mapOf(
                "location" to location,
                "lang" to lang
            )
        )
        val result = Http.get(url)
        return QWeatherSDK.gson.fromJson(result, AirEntity::class.java)
    }

    @JvmOverloads
    fun now(
        location: Coordinate,
        lang: Lang = Lang.ZH,
    ): AirEntity {
        return this.now(location(), lang)
    }

    @JvmOverloads
    fun daily(
        location: String,
        lang: Lang = Lang.ZH,
    ): AirDailyEntity {
        val url = makeParam(
            "air/5d",
            mapOf(
                "location" to location,
                "lang" to lang
            )
        )
        val result = Http.get(url)
        return QWeatherSDK.gson.fromJson(result, AirDailyEntity::class.java)
    }

    @JvmOverloads
    fun daily(
        location: Coordinate,
        lang: Lang = Lang.ZH,
    ): AirDailyEntity {
        return this.daily(location(), lang)
    }
}