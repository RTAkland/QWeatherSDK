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
import cn.rtast.qwsdk.utils.Http

object AirBeta {

    @JvmOverloads
    fun now(
        location: String,
        lang: Lang = Lang.ZH,
        pollutant: Boolean = false,
        station: Boolean = false,
    ): BetaAirNowEntity {
        return Http.get<BetaAirNowEntity>(
            QWeatherSDK.rootAPI + "airquality/v1/now/$location",
            params = mapOf(
                "lang" to lang.toString(),
                "pollutant" to pollutant,
                "station" to station
            )
        )
    }

    @JvmOverloads
    fun stationInfo(location: String, lang: Lang = Lang.ZH): BetaAirStationEntity {
        return Http.get<BetaAirStationEntity>(
            QWeatherSDK.rootAPI + "airquality/v1/station/$location",
            params = mapOf("lang" to lang.toString())
        )
    }
}