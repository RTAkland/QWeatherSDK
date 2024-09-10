/*
 * Copyright 2024 RTAkland
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
import cn.rtast.qwsdk.entity.air.BetaAirNowEntity
import cn.rtast.qwsdk.entity.air.BetaAirStationEntity
import cn.rtast.qwsdk.enums.Lang
import cn.rtast.qwsdk.utils.Coordinate
import cn.rtast.qwsdk.utils.Http
import cn.rtast.qwsdk.utils.buildRequestURL

object AirNew {

    @JvmOverloads
    fun now(
        location: Coordinate,
        lang: Lang = Lang.ZH,
    ): BetaAirNowEntity {
        val url = buildRequestURL(
            "airquality/v1/current/${location.latitude}/${location.longitude}",
            mapOf("lang" to lang)
        )

        val result = Http.get(url)
        return QWeatherSDK.gson.fromJson(result, BetaAirNowEntity::class.java)
    }

    @JvmOverloads
    fun stationInfo(location: String, lang: Lang = Lang.ZH): BetaAirStationEntity {
        val url = buildRequestURL(
            "airquality/v1/station/$location",
            mapOf(
                "lang" to lang
            )
        )

        val result = Http.get(url)

        return QWeatherSDK.gson.fromJson(result, BetaAirStationEntity::class.java)
    }
}