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
import cn.rtast.qwsdk.entity.weather.daily.WeatherHourlyBean
import cn.rtast.qwsdk.entity.weather.grid.daily.WeatherGridDailyBean
import cn.rtast.qwsdk.entity.weather.grid.hourly.WeatherGridHourlyBean
import cn.rtast.qwsdk.entity.weather.grid.realtime.WeatherGridRealtimeBean
import cn.rtast.qwsdk.entity.weather.hourly.WeatherDailyBean
import cn.rtast.qwsdk.entity.weather.minutely.WeatherMinutelyBean
import cn.rtast.qwsdk.entity.weather.now.WeatherNowBean
import cn.rtast.qwsdk.utils.Coordinate
import cn.rtast.qwsdk.utils.Http
import cn.rtast.qwsdk.utils.makeParam

class Weather {

    private fun weatherHourly(
        hours: String,
        location: String,
        lang: QWeatherSDK.Lang,
        unit: QWeatherSDK.Units
    ): WeatherHourlyBean {
        val url = makeParam(
            "weather/$hours",
            mapOf(
                "location" to location,
                "lang" to lang,
                "unit" to unit
            )
        )
        val result = Http.get(url)
        return QWeatherSDK.gson.fromJson(result, WeatherHourlyBean::class.java)
    }


    private fun weatherDaily(
        days: String,
        location: String,
        unit: QWeatherSDK.Units,
        lang: QWeatherSDK.Lang
    ): WeatherDailyBean {
        val url = makeParam(
            "weather/$days",
            mapOf(
                "location" to location,
                "lang" to lang,
                "unit" to unit
            )
        )
        val result = Http.get(url)
        return QWeatherSDK.gson.fromJson(result, WeatherDailyBean::class.java)
    }

    private fun gridHourlyWeather(
        hours: String,
        location: String,
        unit: QWeatherSDK.Units,
        lang: QWeatherSDK.Lang
    ): WeatherGridHourlyBean {
        val url = makeParam(
            "grid-weather/$hours",
            mapOf(
                "location" to location,
                "lang" to lang,
                "unit" to unit
            )
        )
        val result = Http.get(url)
        return QWeatherSDK.gson.fromJson(result, WeatherGridHourlyBean::class.java)
    }

    private fun gridDailyWeather(
        days: String,
        location: String,
        unit: QWeatherSDK.Units,
        lang: QWeatherSDK.Lang
    ): WeatherGridDailyBean {
        val url = makeParam(
            "grid-weather/$days",
            mapOf(
                "location" to location,
                "lang" to lang,
                "unit" to unit
            )
        )
        val result = Http.get(url)
        return QWeatherSDK.gson.fromJson(result, WeatherGridDailyBean::class.java)
    }

    @JvmOverloads
    fun now(
        location: String,
        unit: QWeatherSDK.Units = QWeatherSDK.Units.M,
        lang: QWeatherSDK.Lang = QWeatherSDK.Lang.ZH
    ): WeatherNowBean {
        val url = makeParam(
            "weather/now",
            mapOf(
                "location" to location,
                "lang" to lang,
                "unit" to unit
            )
        )
        val result = Http.get(url)
        return QWeatherSDK.gson.fromJson(result, WeatherNowBean::class.java)
    }

    @JvmOverloads
    fun now(
        location: Coordinate,
        unit: QWeatherSDK.Units = QWeatherSDK.Units.M,
        lang: QWeatherSDK.Lang = QWeatherSDK.Lang.ZH
    ): WeatherNowBean {
        return this.now(location(), unit, lang)
    }

    @JvmOverloads
    fun weatherMinutely(
        location: Coordinate,
        lang: QWeatherSDK.Lang = QWeatherSDK.Lang.ZH
    ): WeatherMinutelyBean {
        val url = makeParam(
            "minutely/5m",
            mapOf(
                "location" to location(),
                "lang" to lang,
            )
        )
        val result = Http.get(url)
        return QWeatherSDK.gson.fromJson(result, WeatherMinutelyBean::class.java)
    }

    @JvmOverloads
    fun weather24h(
        location: String,
        unit: QWeatherSDK.Units = QWeatherSDK.Units.M,
        lang: QWeatherSDK.Lang = QWeatherSDK.Lang.ZH
    ): WeatherHourlyBean {
        return this.weatherHourly("24h", location, lang, unit)
    }

    @JvmOverloads
    fun weather24h(
        location: Coordinate,
        unit: QWeatherSDK.Units = QWeatherSDK.Units.M,
        lang: QWeatherSDK.Lang = QWeatherSDK.Lang.ZH
    ): WeatherHourlyBean {
        return this.weather24h(location(), unit, lang)
    }

    @JvmOverloads
    fun weather72h(
        location: String,
        unit: QWeatherSDK.Units = QWeatherSDK.Units.M,
        lang: QWeatherSDK.Lang = QWeatherSDK.Lang.ZH
    ): WeatherHourlyBean {
        return this.weatherHourly("72h", location, lang, unit)
    }

    @JvmOverloads
    fun weather72h(
        location: Coordinate,
        unit: QWeatherSDK.Units = QWeatherSDK.Units.M,
        lang: QWeatherSDK.Lang = QWeatherSDK.Lang.ZH
    ): WeatherHourlyBean {
        return this.weather72h(location(), unit, lang)
    }

    @JvmOverloads
    fun weather168h(
        location: String,
        unit: QWeatherSDK.Units = QWeatherSDK.Units.M,
        lang: QWeatherSDK.Lang = QWeatherSDK.Lang.ZH
    ): WeatherHourlyBean {
        return this.weatherHourly("168h", location, lang, unit)
    }

    @JvmOverloads
    fun weather168h(
        location: Coordinate,
        unit: QWeatherSDK.Units = QWeatherSDK.Units.M,
        lang: QWeatherSDK.Lang = QWeatherSDK.Lang.ZH
    ): WeatherHourlyBean {
        return this.weather168h(location(), unit, lang)
    }

    @JvmOverloads
    fun weather3d(
        location: String,
        unit: QWeatherSDK.Units = QWeatherSDK.Units.M,
        lang: QWeatherSDK.Lang = QWeatherSDK.Lang.ZH
    ): WeatherDailyBean {
        return this.weatherDaily("3d", location, unit, lang)
    }

    @JvmOverloads
    fun weather3d(
        location: Coordinate,
        unit: QWeatherSDK.Units = QWeatherSDK.Units.M,
        lang: QWeatherSDK.Lang = QWeatherSDK.Lang.ZH
    ): WeatherDailyBean {
        return this.weather3d(location(), unit, lang)
    }

    @JvmOverloads
    fun weather7d(
        location: String,
        unit: QWeatherSDK.Units = QWeatherSDK.Units.M,
        lang: QWeatherSDK.Lang = QWeatherSDK.Lang.ZH
    ): WeatherDailyBean {
        return this.weatherDaily("7d", location, unit, lang)
    }

    @JvmOverloads
    fun weather7d(
        location: Coordinate,
        unit: QWeatherSDK.Units = QWeatherSDK.Units.M,
        lang: QWeatherSDK.Lang = QWeatherSDK.Lang.ZH
    ): WeatherDailyBean {
        return this.weather7d(location(), unit, lang)
    }

    @JvmOverloads
    fun weather15d(
        location: String,
        unit: QWeatherSDK.Units = QWeatherSDK.Units.M,
        lang: QWeatherSDK.Lang = QWeatherSDK.Lang.ZH
    ): WeatherDailyBean {
        return this.weatherDaily("15d", location, unit, lang)
    }

    @JvmOverloads
    fun weather15d(
        location: Coordinate,
        unit: QWeatherSDK.Units = QWeatherSDK.Units.M,
        lang: QWeatherSDK.Lang = QWeatherSDK.Lang.ZH
    ): WeatherDailyBean {
        return this.weather15d(location(), unit, lang)
    }

    @JvmOverloads
    fun weatherGridNow(
        location: Coordinate,
        unit: QWeatherSDK.Units = QWeatherSDK.Units.M,
        lang: QWeatherSDK.Lang = QWeatherSDK.Lang.ZH
    ): WeatherGridRealtimeBean {
        val url = makeParam(
            "grid-weather/now",
            mapOf(
                "location" to location(),
                "lang" to lang,
                "unit" to unit
            )
        )
        val result = Http.get(url)
        return QWeatherSDK.gson.fromJson(result, WeatherGridRealtimeBean::class.java)
    }

    @JvmOverloads
    fun weatherGrid24h(
        location: Coordinate,
        unit: QWeatherSDK.Units = QWeatherSDK.Units.M,
        lang: QWeatherSDK.Lang = QWeatherSDK.Lang.ZH
    ): WeatherGridHourlyBean {
        return this.gridHourlyWeather("24h", location(), unit, lang)
    }

    @JvmOverloads
    fun weatherGrid72h(
        location: Coordinate,
        unit: QWeatherSDK.Units = QWeatherSDK.Units.M,
        lang: QWeatherSDK.Lang = QWeatherSDK.Lang.ZH
    ): WeatherGridHourlyBean {
        return this.gridHourlyWeather("72h", location(), unit, lang)
    }

    @JvmOverloads
    fun weatherGrid3d(
        location: Coordinate,
        unit: QWeatherSDK.Units = QWeatherSDK.Units.M,
        lang: QWeatherSDK.Lang = QWeatherSDK.Lang.ZH
    ): WeatherGridDailyBean {
        return this.gridDailyWeather("3d", location(), unit, lang)
    }

    @JvmOverloads
    fun weatherGrid7d(
        location: Coordinate,
        unit: QWeatherSDK.Units = QWeatherSDK.Units.M,
        lang: QWeatherSDK.Lang = QWeatherSDK.Lang.ZH
    ): WeatherGridDailyBean {
        return this.gridDailyWeather("7d", location(), unit, lang)
    }
}