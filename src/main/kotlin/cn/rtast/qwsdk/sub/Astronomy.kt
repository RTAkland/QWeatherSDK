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
import cn.rtast.qwsdk.entity.astronomy.MoonBean
import cn.rtast.qwsdk.entity.astronomy.SolarElevationAngleBean
import cn.rtast.qwsdk.entity.astronomy.SunBean
import cn.rtast.qwsdk.enums.Lang
import cn.rtast.qwsdk.utils.DateUtil
import cn.rtast.qwsdk.utils.HTTPUtil
import com.google.gson.Gson

class Astronomy {

    private val gson = Gson()

    fun sun(
        location: String,
        date: String,
        lang: Lang = Lang.ZH
    ): SunBean {
        DateUtil(date).verifyYMD()
        val url = "${QWeather.rootAPI}/astronomy/sun" +
                "?location=$location" +
                "&date=$date" +
                "&lang=${lang.name.lowercase()}"
        val result = HTTPUtil.get(url)
        return gson.fromJson(result, SunBean::class.java)
    }

    fun moon(
        location: String,
        date: String,
        lang: Lang = Lang.ZH
    ): MoonBean {
        DateUtil(date).verifyYMD()
        val url = "${QWeather.rootAPI}/astronomy/moon" +
                "?location=$location" +
                "&date=$date" +
                "&lang=${lang.name.lowercase()}"
        val result = HTTPUtil.get(url)
        return gson.fromJson(result, MoonBean::class.java)
    }

    fun solarElevationAngle(
        location: String,
        date: String,
        time: String,
        tz: Int,
        alt: Int
    ): SolarElevationAngleBean {
        DateUtil(date).verifyYMD()
        DateUtil(time).verifyHM()
        val url = "${QWeather.rootAPI}/astronomy/solar-elevation-angle" +
                "?location=$location" +
                "&date=$date" +
                "&time=$time" +
                "&tz=$tz" +
                "&alt=$alt"
        val result = HTTPUtil.get(url)
        return gson.fromJson(result, SolarElevationAngleBean::class.java)
    }
}