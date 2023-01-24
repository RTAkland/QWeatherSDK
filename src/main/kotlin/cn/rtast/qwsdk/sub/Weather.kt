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
import cn.rtast.qwsdk.entity.weather.daily.WeatherHourlyBean
import cn.rtast.qwsdk.entity.weather.grid.daily.WeatherGridDailyBean
import cn.rtast.qwsdk.entity.weather.grid.hourly.WeatherGridHourlyBean
import cn.rtast.qwsdk.entity.weather.grid.realtime.WeatherGridRealtimeBean
import cn.rtast.qwsdk.entity.weather.hourly.WeatherDailyBean
import cn.rtast.qwsdk.entity.weather.minutely.WeatherMinutelyBean
import cn.rtast.qwsdk.entity.weather.now.WeatherNowBean
import cn.rtast.qwsdk.enums.Lang
import cn.rtast.qwsdk.enums.Unit
import cn.rtast.qwsdk.utils.HTTPUtil
import com.google.gson.Gson

class Weather {

    private val gson = Gson()

    private fun weatherHourly(
        hours: String,
        location: String,
        lang: Lang,
        unit: Unit
    ): WeatherHourlyBean {
        val url = "${QWeather.rootAPI}/weather/$hours" +
                "?location=$location" +
                "&lang=${lang.name.lowercase()}" +
                "&unit=${unit.name.lowercase()}"
        val result = HTTPUtil.get(url)
        return gson.fromJson(result, WeatherHourlyBean::class.java)
    }


    private fun weatherDaily(
        days: String,
        location: String,
        lang: Lang = Lang.ZH,
        unit: Unit = Unit.M
    ): WeatherDailyBean {
        val url = "${QWeather.rootAPI}/weather/$days" +
                "?location=$location" +
                "&lang=${lang.name.lowercase()}" +
                "&unit=${unit.name.lowercase()}"
        val result = HTTPUtil.get(url)
        return gson.fromJson(result, WeatherDailyBean::class.java)
    }

    private fun gridHourlyWeather(
        hours: String,
        location: String,
        lang: Lang = Lang.ZH,
        unit: Unit = Unit.M
    ): WeatherGridHourlyBean {
        val url = "${QWeather.rootAPI}/grid-weather/$hours" +
                "?location=$location" +
                "&lang=${lang.name.lowercase()}" +
                "&unit=${unit.name.lowercase()}"
        val result = HTTPUtil.get(url)
        return gson.fromJson(result, WeatherGridHourlyBean::class.java)
    }

    private fun gridDailyWeather(
        days: String,
        location: String,
        lang: Lang = Lang.ZH,
        unit: Unit = Unit.M
    ): WeatherGridDailyBean {
        val url = "${QWeather.rootAPI}/grid-weather/$days" +
                "?location=$location" +
                "&lang=${lang.name.lowercase()}" +
                "&unit=${unit.name.lowercase()}"
        val result = HTTPUtil.get(url)
        return gson.fromJson(result, WeatherGridDailyBean::class.java)
    }

    fun now(
        location: String, lang: Lang = Lang.ZH, unit: Unit = Unit.M
    ): WeatherNowBean {
        val url =
            "${QWeather.rootAPI}/weather/now" +
                    "?location=$location" +
                    "&lang=${lang.name.lowercase()}" +
                    "&unit=${unit.name.lowercase()}"
        val result = HTTPUtil.get(url)
        return gson.fromJson(result, WeatherNowBean::class.java)
    }

    fun weatherMinutely(
        location: String,
        lang: Lang = Lang.ZH
    ): WeatherMinutelyBean {
        val url = "${QWeather.rootAPI}/minutely/5m" +
                "?location=$location" +
                "&lang=${lang.name.lowercase()}"
        val result = HTTPUtil.get(url)
        return gson.fromJson(result, WeatherMinutelyBean::class.java)
    }

    fun weather24h(
        location: String,
        lang: Lang = Lang.ZH,
        unit: Unit = Unit.M
    ): WeatherHourlyBean {
        return weatherHourly("24h", location, lang, unit)
    }

    fun weather72h(
        location: String,
        lang: Lang = Lang.ZH,
        unit: Unit = Unit.M
    ): WeatherHourlyBean {
        return weatherHourly("72h", location, lang, unit)
    }

    fun weather168h(
        location: String,
        lang: Lang = Lang.ZH,
        unit: Unit = Unit.M
    ): WeatherHourlyBean {
        return weatherHourly("168h", location, lang, unit)
    }

    fun weather3d(
        location: String,
        lang: Lang = Lang.ZH,
        unit: Unit = Unit.M
    ): WeatherDailyBean {
        return weatherDaily("3d", location, lang, unit)
    }

    fun weather7d(
        location: String,
        lang: Lang = Lang.ZH,
        unit: Unit = Unit.M
    ): WeatherDailyBean {
        return weatherDaily("7d", location, lang, unit)
    }

    fun weather15d(
        location: String,
        lang: Lang = Lang.ZH,
        unit: Unit = Unit.M
    ): WeatherDailyBean {
        return weatherDaily("15d", location, lang, unit)
    }

    fun weatherGridRealtime(
        location: String,
        lang: Lang = Lang.ZH,
        unit: Unit = Unit.M
    ): WeatherGridRealtimeBean {
        val url = "${QWeather.rootAPI}/grid-weather/now" +
                "?location=$location" +
                "&lang=${lang.name.lowercase()}" +
                "&unit=${unit.name.lowercase()}"
        val result = HTTPUtil.get(url)
        return gson.fromJson(result, WeatherGridRealtimeBean::class.java)
    }

    fun weatherGrid24h(
        location: String,
        lang: Lang = Lang.ZH,
        unit: Unit = Unit.M
    ): WeatherGridHourlyBean {
        return this.gridHourlyWeather("24h", location, lang, unit)
    }

    fun weatherGrid72h(
        location: String,
        lang: Lang = Lang.ZH,
        unit: Unit = Unit.M
    ): WeatherGridHourlyBean {
        return this.gridHourlyWeather("72h", location, lang, unit)
    }

    fun weatherGrid3d(
        location: String,
        lang: Lang = Lang.ZH,
        unit: Unit = Unit.M
    ): WeatherGridDailyBean {
        return this.gridDailyWeather("3d", location, lang, unit)
    }

    fun weatherGrid7d(
        location: String,
        lang: Lang = Lang.ZH,
        unit: Unit = Unit.M
    ): WeatherGridDailyBean {
        return this.gridDailyWeather("7d", location, lang, unit)
    }
}