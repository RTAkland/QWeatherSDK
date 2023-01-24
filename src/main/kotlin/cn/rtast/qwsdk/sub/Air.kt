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
import cn.rtast.qwsdk.entity.air.daily.AirDailyBean
import cn.rtast.qwsdk.entity.air.realtime.AirBean
import cn.rtast.qwsdk.enums.Lang
import cn.rtast.qwsdk.utils.HTTPUtil
import com.google.gson.Gson

class Air {

    private val gson = Gson()

    fun now(
        location: String,
        lang: Lang = Lang.ZH
    ): AirBean {
        val url = "${QWeather.rootAPI}/air/now" +
                "?location=$location" +
                "&lang=${lang.name.lowercase()}"
        val result = HTTPUtil.get(url)
        return gson.fromJson(result, AirBean::class.java)
    }

    fun daily(
        location: String,
        lang: Lang = Lang.ZH
    ): AirDailyBean {
        val url = "${QWeather.rootAPI}/air/now" +
                "?location=$location" +
                "&lang=${lang.name.lowercase()}"
        val result = HTTPUtil.get(url)
        return gson.fromJson(result, AirDailyBean::class.java)
    }
}