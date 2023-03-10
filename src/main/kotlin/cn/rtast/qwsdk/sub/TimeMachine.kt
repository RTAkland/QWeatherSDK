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

import cn.rtast.qwsdk.QWeather
import cn.rtast.qwsdk.entity.historical.air.AirHistoricalBean
import cn.rtast.qwsdk.entity.historical.weather.WeatherHistoricalBean
import cn.rtast.qwsdk.enums.Lang
import cn.rtast.qwsdk.enums.Units
import cn.rtast.qwsdk.utils.DateUtil
import cn.rtast.qwsdk.utils.get
import cn.rtast.qwsdk.utils.makeParams
import com.google.gson.Gson
import java.util.logging.Logger

class TimeMachine {

    private val gson = Gson()

    init {
        QWeather.logger.info("This API only support Location ID to get weather.")
    }

    @JvmOverloads
    fun weatherHistory(
        location: String,
        date: String,
        unit: Units = Units.M,
        lang: Lang = Lang.ZH
    ): WeatherHistoricalBean {
        DateUtil(date).verifyYMD()
        val url = makeParams(
            "historical/weather",
            mapOf(
                "location" to location,
                "lang" to lang,
                "unit" to unit,
                "date" to date
            )
        )
        val result = get(url)
        return gson.fromJson(result, WeatherHistoricalBean::class.java)
    }

    @JvmOverloads
    fun airHistory(
        location: String,
        date: String,
        unit: Units = Units.M,
        lang: Lang = Lang.ZH
    ): AirHistoricalBean {
        DateUtil(date).verifyYMD()
        val url = makeParams(
            "historical/air",
            mapOf(
                "location" to location,
                "lang" to lang,
                "unit" to unit,
                "date" to date
            )
        )
        val result = get(url)
        return gson.fromJson(result, AirHistoricalBean::class.java)
    }
}