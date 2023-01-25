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
import cn.rtast.qwsdk.enums.Unit
import cn.rtast.qwsdk.utils.DateUtil
import cn.rtast.qwsdk.utils.HTTPUtil
import com.google.gson.Gson

class TimeMachine {

    private val gson = Gson()

    fun weatherHistory(
        location: String,
        date: String,
        lang: Lang = Lang.ZH,
        unit: Unit = Unit.M
    ): WeatherHistoricalBean {
        DateUtil().verify(date)
        val url = "${QWeather.rootAPI}/historical/weather" +
                "?location=$location" +
                "&lang=${lang.name.lowercase()}" +
                "&unit=${unit.name.lowercase()}" +
                "&date=$date"
        val result = HTTPUtil.get(url)
        return gson.fromJson(result, WeatherHistoricalBean::class.java)
    }

    fun airHistory(
        location: String,
        date: String,
        lang: Lang = Lang.ZH,
        unit: Unit = Unit.M
    ): AirHistoricalBean {
        DateUtil().verify(date)
        val url = "${QWeather.rootAPI}/historical/air" +
                "?location=$location" +
                "&lang=${lang.name.lowercase()}" +
                "&unit=${unit.name.lowercase()}" +
                "&date=$date"
        val result = HTTPUtil.get(url)
        return gson.fromJson(result, AirHistoricalBean::class.java)
    }
}