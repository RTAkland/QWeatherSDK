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

import cn.rtast.qwsdk.QWeatherSDK
import cn.rtast.qwsdk.entity.air.daily.AirDailyBean
import cn.rtast.qwsdk.entity.air.realtime.AirBean
import cn.rtast.qwsdk.utils.Coordinate
import cn.rtast.qwsdk.utils.Http
import cn.rtast.qwsdk.utils.makeParam

class Air {

    @JvmOverloads
    fun now(
        location: String,
        lang: QWeatherSDK.Lang = QWeatherSDK.Lang.ZH
    ): AirBean {
        val url = makeParam(
            "air/now",
            mapOf(
                "location" to location,
                "lang" to lang
            )
        )
        val result = Http.get(url)
        return QWeatherSDK.gson.fromJson(result, AirBean::class.java)
    }

    @JvmOverloads
    fun now(
        location: Coordinate,
        lang: QWeatherSDK.Lang = QWeatherSDK.Lang.ZH
    ): AirBean {
        return this.now(location(), lang)
    }

    @JvmOverloads
    fun daily(
        location: String,
        lang: QWeatherSDK.Lang = QWeatherSDK.Lang.ZH
    ): AirDailyBean {
        val url = makeParam(
            "air/5d",
            mapOf(
                "location" to location,
                "lang" to lang
            )
        )
        val result = Http.get(url)
        return QWeatherSDK.gson.fromJson(result, AirDailyBean::class.java)
    }

    @JvmOverloads
    fun daily(
        location: Coordinate,
        lang: QWeatherSDK.Lang = QWeatherSDK.Lang.ZH
    ): AirDailyBean {
        return this.daily(location(), lang)
    }
}