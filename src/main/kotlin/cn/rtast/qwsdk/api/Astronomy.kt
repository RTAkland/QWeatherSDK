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
import cn.rtast.qwsdk.entity.astronomy.MoonEntity
import cn.rtast.qwsdk.entity.astronomy.SolarElevationAngleEntity
import cn.rtast.qwsdk.entity.astronomy.SunEntity
import cn.rtast.qwsdk.enums.Lang
import cn.rtast.qwsdk.exceptions.InvalidDateException
import cn.rtast.qwsdk.utils.*

object Astronomy {

    @JvmOverloads
    @Throws(InvalidDateException::class)
    fun sun(
        location: String,
        date: String,
        lang: Lang = Lang.ZH,
    ): SunEntity {
        DateUtil(date).validateYMD()
        return Http.get<SunEntity>(
            QWeatherSDK.rootAPI + "astronomy/sun",
            params = mapOf(
                "location" to location,
                "date" to date,
                "lang" to lang.toString()
            )
        )
    }

    @JvmOverloads
    @Throws(InvalidDateException::class)
    fun sunAsync(
        location: String,
        date: String,
        lang: Lang = Lang.ZH,
        onRequest: (SunEntity?) -> Unit
    ) {
        DateUtil(date).validateYMD()
        Http.getAsync<SunEntity>(
            QWeatherSDK.rootAPI + "astronomy/sun",
            params = mapOf(
                "location" to location,
                "date" to date,
                "lang" to lang.toString()
            )
        ) { onRequest(it) }
    }


    @JvmOverloads
    @Throws(InvalidDateException::class)
    fun sun(
        location: Coordinate,
        date: String,
        lang: Lang = Lang.ZH,
    ): SunEntity {
        return this.sun(location(), date, lang)
    }

    @JvmOverloads
    @Throws(InvalidDateException::class)
    fun sunAsync(
        location: Coordinate,
        date: String,
        lang: Lang = Lang.ZH,
        onRequest: (SunEntity?) -> Unit
    ) {
        this.sunAsync(location(), date, lang) { onRequest }
    }


    @JvmOverloads
    @Throws(InvalidDateException::class)
    fun moon(
        location: String,
        date: String,
        lang: Lang = Lang.ZH,
    ): MoonEntity {
        DateUtil(date).validateYMD()
        return Http.get<MoonEntity>(
            QWeatherSDK.rootAPI + "astronomy/moon",
            params = mapOf(
                "location" to location,
                "date" to date,
                "lang" to lang.toString()
            )
        )
    }

    @JvmOverloads
    @Throws(InvalidDateException::class)
    fun moonAsync(
        location: String,
        date: String,
        lang: Lang = Lang.ZH,
        onRequest: (MoonEntity?) -> Unit
    ) {
        DateUtil(date).validateYMD()
        Http.getAsync<MoonEntity>(
            QWeatherSDK.rootAPI + "astronomy/moon",
            params = mapOf(
                "location" to location,
                "date" to date,
                "lang" to lang.toString()
            )
        ) { onRequest(it) }
    }

    @JvmOverloads
    @Throws(InvalidDateException::class)
    fun moon(
        location: Coordinate,
        date: String,
        lang: Lang = Lang.ZH,
    ): MoonEntity {
        return this.moon(location(), date, lang)
    }

    @JvmOverloads
    @Throws(InvalidDateException::class)
    fun moonAsync(
        location: Coordinate,
        date: String,
        lang: Lang = Lang.ZH,
        onRequest: (MoonEntity?) -> Unit
    ) {
        this.moonAsync(location(), date, lang) { onRequest }
    }

    @Throws(InvalidDateException::class)
    fun solarElevationAngle(
        location: Coordinate,
        date: String,
        time: String,
        timezone: String,
        alt: Int,
    ): SolarElevationAngleEntity {
        DateUtil(date).validateYMD()
        DateUtil(time).validateHM()
        return Http.get<SolarElevationAngleEntity>(
            QWeatherSDK.rootAPI + "astronomy/solar-elevation-angle",
            params = mapOf(
                "location" to location(),
                "date" to date,
                "time" to timezone,
                "alt" to alt,
                "timezone" to timezone,
            )
        )
    }

    @Throws(InvalidDateException::class)
    fun solarElevationAngleAsync(
        location: Coordinate,
        date: String,
        time: String,
        timezone: String,
        alt: Int,
        onRequest: (SolarElevationAngleEntity?) -> Unit
    ) {
        DateUtil(date).validateYMD()
        DateUtil(time).validateHM()
        Http.getAsync<SolarElevationAngleEntity>(
            QWeatherSDK.rootAPI + "astronomy/solar-elevation-angle",
            params = mapOf(
                "location" to location(),
                "date" to date,
                "time" to timezone,
                "alt" to alt,
                "timezone" to timezone,
            )
        ) { onRequest(it) }
    }
}