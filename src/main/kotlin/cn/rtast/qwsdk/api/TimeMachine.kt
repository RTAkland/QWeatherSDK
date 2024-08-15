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
import cn.rtast.qwsdk.entity.historical.AirHistoricalEntity
import cn.rtast.qwsdk.entity.historical.WeatherHistoricalEntity
import cn.rtast.qwsdk.enums.Lang
import cn.rtast.qwsdk.enums.Units
import cn.rtast.qwsdk.utils.DateUtil
import cn.rtast.qwsdk.utils.Http

object TimeMachine {

    init {
        QWeatherSDK.logger.info("This API only support Location ID to get weather.")
    }

    @JvmOverloads
    fun weatherHistory(
        location: String,
        date: String,
        unit: Units = Units.Metric,
        lang: Lang = Lang.ZH,
    ): WeatherHistoricalEntity {
        DateUtil(date).validateYMD()
        return Http.get<WeatherHistoricalEntity>(
            QWeatherSDK.rootAPI + "historical/weather",
            params = mapOf(
                "location" to location,
                "date" to date,
                "unit" to unit,
                "lang" to lang.toString()
            )
        )
    }

    @JvmOverloads
    fun airHistory(
        location: String,
        date: String,
        unit: Units = Units.Metric,
        lang: Lang = Lang.ZH,
    ): AirHistoricalEntity {
        DateUtil(date).validateYMD()
        return Http.get<AirHistoricalEntity>(
            QWeatherSDK.rootAPI + "historical/air",
            params = mapOf(
                "location" to location,
                "date" to date,
                "unit" to unit,
                "lang" to lang.toString()
            )
        )
    }
}