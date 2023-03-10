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

package cn.rtast.qwsdk

import cn.rtast.qwsdk.enums.Plans
import cn.rtast.qwsdk.sub.*
import cn.rtast.qwsdk.utils.Coordinate
import java.util.logging.Logger


class QWeather {
    companion object {
        var key: String? = null
        var rootAPI = "https://devapi.qweather.com/v7"
        const val geoAPI = "https://geoapi.qweather.com/v2"
        val logger: Logger = Logger.getLogger("QWSDK-MAIN")
    }

    fun init(plan: Plans, apiKey: String) {
        rootAPI = when (plan) {
            Plans.Free -> {
                "https://devapi.qweather.com/v7"
            }

            Plans.Standard -> {
                "https://api.qweather.com/v7"
            }

            Plans.Custom -> {
                "https://api.qweather.com/v7"
            }
        }
        key = apiKey
        logger.info("Current Plan: $plan, Current API Host: $rootAPI")
    }

    fun geo(): Geo {
        return Geo()
    }

    fun weather(): Weather {
        return Weather()
    }

    fun indices(): Indices {
        return Indices()
    }

    fun air(): Air {
        return Air()
    }

    fun timeMachine(): TimeMachine {
        return TimeMachine()
    }

    fun tropical(): Tropical {
        return Tropical()
    }

    fun ocean(): Ocean {
        return Ocean()
    }

    @Deprecated("This API is not impl! (No data to create data bean!)")
    fun solarRadiation() {
        logger.warning("Not Available!")
        TODO("Not available!")
    }

    fun astronomy(): Astronomy {
        return Astronomy()
    }

    fun warning(): Warning {
        return Warning()
    }
}
