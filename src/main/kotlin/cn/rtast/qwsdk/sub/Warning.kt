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
import cn.rtast.qwsdk.entity.warning.WarningBean
import cn.rtast.qwsdk.entity.warning.list.WarningCityListBean
import cn.rtast.qwsdk.enums.CountryCode
import cn.rtast.qwsdk.enums.Lang
import cn.rtast.qwsdk.utils.HTTPUtil
import com.google.gson.Gson

class Warning {

    private val gson = Gson()

    fun now(
        location: String,
        lang: Lang = Lang.ZH
    ): WarningBean {
        val url = "${QWeather.rootAPI}/warning/now" +
                "?location=$location" +
                "&lang=${lang.name.lowercase()}"
        val result = HTTPUtil.get(url)
        return gson.fromJson(result, WarningBean::class.java)
    }

    fun list(
        range: CountryCode = CountryCode.CN
    ): WarningCityListBean {
        val url = "${QWeather.rootAPI}/warning/list" +
                "?range=${range.name.lowercase()}"
        val result = HTTPUtil.get(url)
        return gson.fromJson(result, WarningCityListBean::class.java)
    }
}