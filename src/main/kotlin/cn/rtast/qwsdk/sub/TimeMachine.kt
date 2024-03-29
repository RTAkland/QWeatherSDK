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
import cn.rtast.qwsdk.entity.historical.air.AirHistoricalBean
import cn.rtast.qwsdk.entity.historical.weather.WeatherHistoricalBean
import cn.rtast.qwsdk.utils.DateUtil
import cn.rtast.qwsdk.utils.Http
import cn.rtast.qwsdk.utils.makeParam

class TimeMachine {

    init {
        QWeatherSDK.logger.info("This API only support Location ID to get weather.")
    }

    @JvmOverloads
    fun weatherHistory(
        location: String,
        date: String,
        unit: QWeatherSDK.Units = QWeatherSDK.Units.M,
        lang: QWeatherSDK.Lang = QWeatherSDK.Lang.ZH
    ): WeatherHistoricalBean {
        DateUtil(date).verifyYMD()
        val url = makeParam(
            "historical/weather",
            mapOf(
                "location" to location,
                "lang" to lang,
                "unit" to unit,
                "date" to date
            )
        )
        QWeatherSDK.logger.info(url)
        val result = Http.get(url)
        return QWeatherSDK.gson.fromJson(result, WeatherHistoricalBean::class.java)
    }

    @JvmOverloads
    fun airHistory(
        location: String,
        date: String,
        unit: QWeatherSDK.Units = QWeatherSDK.Units.M,
        lang: QWeatherSDK.Lang = QWeatherSDK.Lang.ZH
    ): AirHistoricalBean {
        DateUtil(date).verifyYMD()
        val url = makeParam(
            "historical/air",
            mapOf(
                "location" to location,
                "lang" to lang,
                "unit" to unit,
                "date" to date
            )
        )
        val result = Http.get(url)
        return QWeatherSDK.gson.fromJson(result, AirHistoricalBean::class.java)
    }
}