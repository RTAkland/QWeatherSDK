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
import cn.rtast.qwsdk.entity.astronomy.MoonBean
import cn.rtast.qwsdk.entity.astronomy.SolarElevationAngleBean
import cn.rtast.qwsdk.entity.astronomy.SunBean
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
    ): SunBean {
        DateUtil(date).verifyYMD()
        val url = makeParam(
            "astronomy/sun",
            mapOf(
                "location" to location,
                "date" to date,
                "lang" to lang
            )
        )
        val result = Http.get(url)
        return QWeatherSDK.gson.fromJson(result, SunBean::class.java)
    }

    @JvmOverloads
    @Throws(InvalidDateException::class)
    fun sun(
        location: Coordinate,
        date: String,
        lang: Lang = Lang.ZH,
    ): SunBean {
        return this.sun(location(), date, lang)
    }

    @JvmOverloads
    @Throws(InvalidDateException::class)
    fun moon(
        location: String,
        date: String,
        lang: Lang = Lang.ZH,
    ): MoonBean {
        DateUtil(date).verifyYMD()
        val url = makeParam(
            "astronomy/moon", mapOf(
                "location" to location,
                "date" to date, "lang" to lang
            )
        )
        val result = Http.get(url)
        return QWeatherSDK.gson.fromJson(result, MoonBean::class.java)
    }

    @JvmOverloads
    @Throws(InvalidDateException::class)
    fun moon(
        location: Coordinate,
        date: String,
        lang: Lang = Lang.ZH,
    ): MoonBean {
        return this.moon(location(), date, lang)
    }

    @Throws(InvalidDateException::class)
    fun solarElevationAngle(
        location: Coordinate,
        date: String,
        time: String,
        tz: String,
        alt: Int,
    ): SolarElevationAngleBean {
        DateUtil(date).verifyYMD()
        DateUtil(time).verifyHM()
        val url = makeParam(
            "astronomy/solar-elevation-angle",
            mapOf(
                "location" to location(),
                "date" to date,
                "time" to time,
                "tz" to tz,
                "alt" to alt
            )
        )
        val result = Http.get(url)
        return QWeatherSDK.gson.fromJson(result, SolarElevationAngleBean::class.java)
    }
}