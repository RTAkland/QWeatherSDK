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
import cn.rtast.qwsdk.entity.tropical.TropicalForecastEntity
import cn.rtast.qwsdk.entity.tropical.TropicalListEntity
import cn.rtast.qwsdk.entity.tropical.TropicalTrackEntity
import cn.rtast.qwsdk.enums.BasinType
import cn.rtast.qwsdk.exceptions.UnsupportedRegionException
import cn.rtast.qwsdk.exceptions.UnsupportedYearException
import cn.rtast.qwsdk.utils.Http
import cn.rtast.qwsdk.utils.buildRequestURL
import java.time.Year

object Tropical {

    fun forecast(stormID: String): TropicalForecastEntity {
        val url = buildRequestURL(
            "tropical/storm-forecast",
            mapOf(
                "stormid" to stormID,
            )
        )
        val result = Http.get(url)
        return QWeatherSDK.gson.fromJson(result, TropicalForecastEntity::class.java)
    }

    fun track(stormID: String): TropicalTrackEntity {
        val url = buildRequestURL(
            "tropical/storm-track",
            mapOf(
                "stormid" to stormID,
            )
        )
        val result = Http.get(url)
        return QWeatherSDK.gson.fromJson(result, TropicalTrackEntity::class.java)
    }

    @JvmOverloads
    @Throws(UnsupportedYearException::class)
    fun list(
        year: String,
        basin: BasinType = BasinType.NP,
    ): TropicalListEntity {

        if (basin != BasinType.NP) {
            throw UnsupportedRegionException("This region is not currently supported: ${basin.desc}(${basin.descZH})!")
        }

        val currentYear = Year.now().toString().toInt()
        val lastYear = currentYear - 1
        if (year != currentYear.toString() && year != lastYear.toString()) {
            throw UnsupportedYearException("You can't list the year before last year and future storms!")
        }
        val url = buildRequestURL(
            "tropical/storm-list",
            mapOf(
                "basin" to basin,
                "year" to year
            )
        )
        QWeatherSDK.logger.info(url)
        val result = Http.get(url)
        return QWeatherSDK.gson.fromJson(result, TropicalListEntity::class.java)
    }
}