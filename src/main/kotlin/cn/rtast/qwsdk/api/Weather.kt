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
import cn.rtast.qwsdk.entity.weather.WeatherHourlyEntity
import cn.rtast.qwsdk.entity.weather.WeatherGridDailyEntity
import cn.rtast.qwsdk.entity.weather.WeatherGridHourlyEntity
import cn.rtast.qwsdk.entity.weather.WeatherGridRealtimeEntity
import cn.rtast.qwsdk.entity.weather.WeatherDailyEntity
import cn.rtast.qwsdk.entity.weather.WeatherMinutelyEntity
import cn.rtast.qwsdk.entity.weather.WeatherNowEntity
import cn.rtast.qwsdk.enums.Lang
import cn.rtast.qwsdk.enums.Units
import cn.rtast.qwsdk.utils.Coordinate
import cn.rtast.qwsdk.utils.Http
import cn.rtast.qwsdk.utils.makeParam

object Weather {

    private fun weatherHourly(
        hours: String,
        location: String,
        lang: Lang,
        unit: Units,
    ): WeatherHourlyEntity {
        val url = makeParam(
            "weather/$hours", mapOf(
                "location" to location, "lang" to lang, "unit" to unit
            )
        )
        val result = Http.get(url)
        return QWeatherSDK.gson.fromJson(result, WeatherHourlyEntity::class.java)
    }


    private fun weatherDaily(
        days: String,
        location: String,
        unit: Units,
        lang: Lang,
    ): WeatherDailyEntity {
        val url = makeParam(
            "weather/$days", mapOf(
                "location" to location, "lang" to lang, "unit" to unit
            )
        )
        val result = Http.get(url)
        return QWeatherSDK.gson.fromJson(result, WeatherDailyEntity::class.java)
    }

    private fun gridHourlyWeather(
        hours: String,
        location: String,
        unit: Units,
        lang: Lang,
    ): WeatherGridHourlyEntity {
        val url = makeParam(
            "grid-weather/$hours", mapOf(
                "location" to location, "lang" to lang, "unit" to unit
            )
        )
        val result = Http.get(url)
        return QWeatherSDK.gson.fromJson(result, WeatherGridHourlyEntity::class.java)
    }

    private fun gridDailyWeather(
        days: String,
        location: String,
        unit: Units,
        lang: Lang,
    ): WeatherGridDailyEntity {
        val url = makeParam(
            "grid-weather/$days", mapOf(
                "location" to location, "lang" to lang, "unit" to unit
            )
        )
        val result = Http.get(url)
        return QWeatherSDK.gson.fromJson(result, WeatherGridDailyEntity::class.java)
    }

    @JvmOverloads
    fun now(
        location: String,
        unit: Units = Units.M,
        lang: Lang = Lang.ZH,
    ): WeatherNowEntity {
        val url = makeParam(
            "weather/now", mapOf(
                "location" to location, "lang" to lang, "unit" to unit
            )
        )
        val result = Http.get(url)
        return QWeatherSDK.gson.fromJson(result, WeatherNowEntity::class.java)
    }

    @JvmOverloads
    fun now(
        location: Coordinate,
        unit: Units = Units.M,
        lang: Lang = Lang.ZH,
    ): WeatherNowEntity {
        return this.now(location(), unit, lang)
    }

    @JvmOverloads
    fun weatherMinutely(
        location: Coordinate,
        lang: Lang = Lang.ZH,
    ): WeatherMinutelyEntity {
        val url = makeParam(
            "minutely/5m", mapOf(
                "location" to location(),
                "lang" to lang,
            )
        )
        val result = Http.get(url)
        return QWeatherSDK.gson.fromJson(result, WeatherMinutelyEntity::class.java)
    }

    @JvmOverloads
    fun weather24h(
        location: String,
        unit: Units = Units.M,
        lang: Lang = Lang.ZH,
    ): WeatherHourlyEntity {
        return this.weatherHourly("24h", location, lang, unit)
    }

    @JvmOverloads
    fun weather24h(
        location: Coordinate,
        unit: Units = Units.M,
        lang: Lang = Lang.ZH,
    ): WeatherHourlyEntity {
        return this.weather24h(location(), unit, lang)
    }

    @JvmOverloads
    fun weather72h(
        location: String,
        unit: Units = Units.M,
        lang: Lang = Lang.ZH,
    ): WeatherHourlyEntity {
        return this.weatherHourly("72h", location, lang, unit)
    }

    @JvmOverloads
    fun weather72h(
        location: Coordinate,
        unit: Units = Units.M,
        lang: Lang = Lang.ZH,
    ): WeatherHourlyEntity {
        return this.weather72h(location(), unit, lang)
    }

    @JvmOverloads
    fun weather168h(
        location: String,
        unit: Units = Units.M,
        lang: Lang = Lang.ZH,
    ): WeatherHourlyEntity {
        return this.weatherHourly("168h", location, lang, unit)
    }

    @JvmOverloads
    fun weather168h(
        location: Coordinate,
        unit: Units = Units.M,
        lang: Lang = Lang.ZH,
    ): WeatherHourlyEntity {
        return this.weather168h(location(), unit, lang)
    }

    @JvmOverloads
    fun weather3d(
        location: String,
        unit: Units = Units.M,
        lang: Lang = Lang.ZH,
    ): WeatherDailyEntity {
        return this.weatherDaily("3d", location, unit, lang)
    }

    @JvmOverloads
    fun weather3d(
        location: Coordinate,
        unit: Units = Units.M,
        lang: Lang = Lang.ZH,
    ): WeatherDailyEntity {
        return this.weather3d(location(), unit, lang)
    }

    @JvmOverloads
    fun weather7d(
        location: String,
        unit: Units = Units.M,
        lang: Lang = Lang.ZH,
    ): WeatherDailyEntity {
        return this.weatherDaily("7d", location, unit, lang)
    }

    @JvmOverloads
    fun weather7d(
        location: Coordinate,
        unit: Units = Units.M,
        lang: Lang = Lang.ZH,
    ): WeatherDailyEntity {
        return this.weather7d(location(), unit, lang)
    }

    @JvmOverloads
    fun weather15d(
        location: String,
        unit: Units = Units.M,
        lang: Lang = Lang.ZH,
    ): WeatherDailyEntity {
        return this.weatherDaily("15d", location, unit, lang)
    }

    @JvmOverloads
    fun weather15d(
        location: Coordinate,
        unit: Units = Units.M,
        lang: Lang = Lang.ZH,
    ): WeatherDailyEntity {
        return this.weather15d(location(), unit, lang)
    }

    @JvmOverloads
    fun weatherGridNow(
        location: Coordinate,
        unit: Units = Units.M,
        lang: Lang = Lang.ZH,
    ): WeatherGridRealtimeEntity {
        val url = makeParam(
            "grid-weather/now", mapOf(
                "location" to location(), "lang" to lang, "unit" to unit
            )
        )
        val result = Http.get(url)
        return QWeatherSDK.gson.fromJson(result, WeatherGridRealtimeEntity::class.java)
    }

    @JvmOverloads
    fun weatherGrid24h(
        location: Coordinate,
        unit: Units = Units.M,
        lang: Lang = Lang.ZH,
    ): WeatherGridHourlyEntity {
        return this.gridHourlyWeather("24h", location(), unit, lang)
    }

    @JvmOverloads
    fun weatherGrid72h(
        location: Coordinate,
        unit: Units = Units.M,
        lang: Lang = Lang.ZH,
    ): WeatherGridHourlyEntity {
        return this.gridHourlyWeather("72h", location(), unit, lang)
    }

    @JvmOverloads
    fun weatherGrid3d(
        location: Coordinate,
        unit: Units = Units.M,
        lang: Lang = Lang.ZH,
    ): WeatherGridDailyEntity {
        return this.gridDailyWeather("3d", location(), unit, lang)
    }

    @JvmOverloads
    fun weatherGrid7d(
        location: Coordinate,
        unit: Units = Units.M,
        lang: Lang = Lang.ZH,
    ): WeatherGridDailyEntity {
        return this.gridDailyWeather("7d", location(), unit, lang)
    }
}