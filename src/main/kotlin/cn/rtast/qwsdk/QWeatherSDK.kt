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

@file:Suppress("unused")

package cn.rtast.qwsdk

import cn.rtast.qwsdk.api.*
import cn.rtast.qwsdk.enums.Plans
import com.google.gson.Gson
import java.util.logging.Logger


class QWeatherSDK(key: String, plan: Plans) {
    companion object {
        lateinit var apiKey: String
        lateinit var rootAPI: String
        const val GEO_API = "https://geoapi.qweather.com/v2"
        val logger: Logger = Logger.getLogger("QWSDK-MAIN")
        val gson = Gson()
    }

    init {
        apiKey = key
        rootAPI = plan.apiUrl
        logger.info("Current Plan: $plan, Current API Host: $rootAPI")
    }

    val geo = Geo
    val weather = Weather
    val indices = Indices
    val air = Air
    val timeMachine = TimeMachine
    val tropical = Tropical
    val ocean = Ocean
    val astronomy = Astronomy
    val warning = Warning
}
