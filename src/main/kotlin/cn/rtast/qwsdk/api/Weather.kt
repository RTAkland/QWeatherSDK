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
import cn.rtast.qwsdk.entity.weather.*
import cn.rtast.qwsdk.enums.Lang
import cn.rtast.qwsdk.enums.Units
import cn.rtast.qwsdk.utils.Coordinate
import cn.rtast.qwsdk.utils.Http

object Weather {

    private fun weatherHourly(
        hours: String,
        location: String,
        lang: Lang,
        unit: Units,
    ): WeatherHourlyEntity {
        return Http.get<WeatherHourlyEntity>(
            QWeatherSDK.rootAPI + "weather/$hours",
            params = mapOf(
                "location" to location,
                "unit" to unit,
                "lang" to lang.toString(),
            )
        )
    }

    private fun weatherHourlyAsync(
        hours: String,
        location: String,
        lang: Lang,
        unit: Units,
        onRequest: (WeatherHourlyEntity?) -> Unit
    ) {
        Http.getAsync<WeatherHourlyEntity>(
            QWeatherSDK.rootAPI + "weather/$hours",
            params = mapOf(
                "location" to location,
                "unit" to unit,
                "lang" to lang.toString(),
            )
        ) { onRequest(it) }
    }


    private fun weatherDaily(
        days: String,
        location: String,
        unit: Units,
        lang: Lang,
    ): WeatherDailyEntity {
        return Http.get<WeatherDailyEntity>(
            QWeatherSDK.rootAPI + "weather/$days",
            params = mapOf(
                "location" to location,
                "unit" to unit,
                "lang" to lang.toString(),
            )
        )
    }

    private fun weatherDailyAsync(
        days: String,
        location: String,
        unit: Units,
        lang: Lang,
        onRequest: (WeatherDailyEntity?) -> Unit
    ) {
        Http.getAsync<WeatherDailyEntity>(
            QWeatherSDK.rootAPI + "weather/$days",
            params = mapOf(
                "location" to location,
                "unit" to unit,
                "lang" to lang.toString(),
            )
        ) { onRequest(it) }
    }

    private fun gridHourlyWeather(
        hours: String,
        location: String,
        unit: Units,
        lang: Lang,
    ): WeatherGridHourlyEntity {
        return Http.get<WeatherGridHourlyEntity>(
            QWeatherSDK.rootAPI + "grid-weather/$hours",
            params = mapOf(
                "location" to location,
                "unit" to unit,
                "lang" to lang.toString(),
            )
        )
    }

    private fun gridHourlyWeatherAsync(
        hours: String,
        location: String,
        unit: Units,
        lang: Lang,
        onRequest: (WeatherGridHourlyEntity?) -> Unit
    ) {
        Http.getAsync<WeatherGridHourlyEntity>(
            QWeatherSDK.rootAPI + "grid-weather/$hours",
            params = mapOf(
                "location" to location,
                "unit" to unit,
                "lang" to lang.toString(),
            )
        ) { onRequest(it) }
    }

    private fun gridDailyWeather(
        days: String,
        location: String,
        unit: Units,
        lang: Lang,
    ): WeatherGridDailyEntity {
        return Http.get<WeatherGridDailyEntity>(
            QWeatherSDK.rootAPI + "grid-weather/$days",
            params = mapOf(
                "location" to location,
                "unit" to unit,
                "lang" to lang.toString(),
            )
        )
    }

    private fun gridDailyWeatherAsync(
        days: String,
        location: String,
        unit: Units,
        lang: Lang,
        onRequest: (WeatherGridDailyEntity?) -> Unit
    ) {
        Http.getAsync<WeatherGridDailyEntity>(
            QWeatherSDK.rootAPI + "grid-weather/$days",
            params = mapOf(
                "location" to location,
                "unit" to unit,
                "lang" to lang.toString(),
            )
        ) { onRequest(it) }
    }

    @JvmOverloads
    fun now(
        location: String,
        unit: Units = Units.Metric,
        lang: Lang = Lang.ZH,
    ): WeatherNowEntity {
        return Http.get<WeatherNowEntity>(
            QWeatherSDK.rootAPI + "weather/now",
            params = mapOf(
                "location" to location,
                "unit" to unit,
                "lang" to lang.toString(),
            )
        )
    }

    @JvmOverloads
    fun nowAsync(
        location: String,
        unit: Units = Units.Metric,
        lang: Lang = Lang.ZH,
        onRequest: (WeatherNowEntity?) -> Unit
    ) {
        Http.getAsync<WeatherNowEntity>(
            QWeatherSDK.rootAPI + "weather/now",
            params = mapOf(
                "location" to location,
                "unit" to unit,
                "lang" to lang.toString(),
            )
        ) { onRequest(it) }
    }

    @JvmOverloads
    fun now(
        location: Coordinate,
        unit: Units = Units.Metric,
        lang: Lang = Lang.ZH,
    ): WeatherNowEntity {
        return this.now(location(), unit, lang)
    }

    @JvmOverloads
    fun nowAsync(
        location: Coordinate,
        unit: Units = Units.Metric,
        lang: Lang = Lang.ZH,
        onRequest: (WeatherNowEntity?) -> Unit
    ) {
        this.nowAsync(location(), unit, lang, onRequest)
    }

    @JvmOverloads
    fun weatherMinutely(
        location: Coordinate,
        lang: Lang = Lang.ZH,
    ): WeatherMinutelyEntity {
        return Http.get<WeatherMinutelyEntity>(
            QWeatherSDK.rootAPI + "weather/minutely",
            params = mapOf(
                "location" to location(),
                "lang" to lang.toString(),
            )
        )
    }

    @JvmOverloads
    fun weatherMinutelyAsync(
        location: Coordinate,
        lang: Lang = Lang.ZH,
        onRequest: (WeatherMinutelyEntity?) -> Unit
    ) {
        Http.getAsync<WeatherMinutelyEntity>(
            QWeatherSDK.rootAPI + "weather/minutely",
            params = mapOf(
                "location" to location(),
                "lang" to lang.toString(),
            )
        ) { onRequest(it) }
    }

    @JvmOverloads
    fun weather24h(
        location: String,
        unit: Units = Units.Metric,
        lang: Lang = Lang.ZH,
    ): WeatherHourlyEntity {
        return this.weatherHourly("24h", location, lang, unit)
    }

    @JvmOverloads
    fun weather24h(
        location: String,
        unit: Units = Units.Metric,
        lang: Lang = Lang.ZH,
        onRequest: (WeatherHourlyEntity?) -> Unit
    ) {
        this.weatherHourlyAsync("24h", location, lang, unit, onRequest)
    }

    @JvmOverloads
    fun weather24h(
        location: Coordinate,
        unit: Units = Units.Metric,
        lang: Lang = Lang.ZH,
    ): WeatherHourlyEntity {
        return this.weather24h(location(), unit, lang)
    }

    @JvmOverloads
    fun weather24hAsync(
        location: Coordinate,
        unit: Units = Units.Metric,
        lang: Lang = Lang.ZH,
        onRequest: (WeatherHourlyEntity?) -> Unit
    ) {
        this.weatherHourlyAsync(location(), unit, lang, onRequest)
    }

    @JvmOverloads
    fun weather72h(
        location: String,
        unit: Units = Units.Metric,
        lang: Lang = Lang.ZH,
    ): WeatherHourlyEntity {
        return this.weatherHourly("72h", location, lang, unit)
    }

    @JvmOverloads
    fun weather72h(
        location: Coordinate,
        unit: Units = Units.Metric,
        lang: Lang = Lang.ZH,
    ): WeatherHourlyEntity {
        return this.weather72h(location(), unit, lang)
    }

    @JvmOverloads
    fun weather168h(
        location: String,
        unit: Units = Units.Metric,
        lang: Lang = Lang.ZH,
    ): WeatherHourlyEntity {
        return this.weatherHourly("168h", location, lang, unit)
    }

    @JvmOverloads
    fun weather168h(
        location: Coordinate,
        unit: Units = Units.Metric,
        lang: Lang = Lang.ZH,
    ): WeatherHourlyEntity {
        return this.weather168h(location(), unit, lang)
    }

    @JvmOverloads
    fun weather3d(
        location: String,
        unit: Units = Units.Metric,
        lang: Lang = Lang.ZH,
    ): WeatherDailyEntity {
        return this.weatherDaily("3d", location, unit, lang)
    }

    @JvmOverloads
    fun weather3d(
        location: Coordinate,
        unit: Units = Units.Metric,
        lang: Lang = Lang.ZH,
    ): WeatherDailyEntity {
        return this.weather3d(location(), unit, lang)
    }

    @JvmOverloads
    fun weather7d(
        location: String,
        unit: Units = Units.Metric,
        lang: Lang = Lang.ZH,
    ): WeatherDailyEntity {
        return this.weatherDaily("7d", location, unit, lang)
    }

    @JvmOverloads
    fun weather7d(
        location: Coordinate,
        unit: Units = Units.Metric,
        lang: Lang = Lang.ZH,
    ): WeatherDailyEntity {
        return this.weather7d(location(), unit, lang)
    }

    @JvmOverloads
    fun weather15d(
        location: String,
        unit: Units = Units.Metric,
        lang: Lang = Lang.ZH,
    ): WeatherDailyEntity {
        return this.weatherDaily("15d", location, unit, lang)
    }

    @JvmOverloads
    fun weather15d(
        location: Coordinate,
        unit: Units = Units.Metric,
        lang: Lang = Lang.ZH,
    ): WeatherDailyEntity {
        return this.weather15d(location(), unit, lang)
    }

    @JvmOverloads
    fun weatherGridNow(
        location: Coordinate,
        unit: Units = Units.Metric,
        lang: Lang = Lang.ZH,
    ): WeatherGridRealtimeEntity {
        return Http.get<WeatherGridRealtimeEntity>(
            QWeatherSDK.rootAPI + "grid-weather/now",
            params = mapOf(
                "location" to location(),
                "unit" to unit.toString(),
                "lang" to lang.toString(),
            )
        )
    }

    @JvmOverloads
    fun weatherGrid24h(
        location: Coordinate,
        unit: Units = Units.Metric,
        lang: Lang = Lang.ZH,
    ): WeatherGridHourlyEntity {
        return this.gridHourlyWeather("24h", location(), unit, lang)
    }

    @JvmOverloads
    fun weatherGrid72h(
        location: Coordinate,
        unit: Units = Units.Metric,
        lang: Lang = Lang.ZH,
    ): WeatherGridHourlyEntity {
        return this.gridHourlyWeather("72h", location(), unit, lang)
    }

    @JvmOverloads
    fun weatherGrid3d(
        location: Coordinate,
        unit: Units = Units.Metric,
        lang: Lang = Lang.ZH,
    ): WeatherGridDailyEntity {
        return this.gridDailyWeather("3d", location(), unit, lang)
    }

    @JvmOverloads
    fun weatherGrid7d(
        location: Coordinate,
        unit: Units = Units.Metric,
        lang: Lang = Lang.ZH,
    ): WeatherGridDailyEntity {
        return this.gridDailyWeather("7d", location(), unit, lang)
    }
}