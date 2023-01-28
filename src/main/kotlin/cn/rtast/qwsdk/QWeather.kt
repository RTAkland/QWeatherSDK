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
import java.util.logging.Logger


class QWeather {

    private val logger = Logger.getLogger("QWSDK-MAIN")

    fun init(plan: Plans, key: String) {
        Global.rootAPI = when (plan) {
            Plans.FREE -> {
                "https://devapi.qweather.com/v7"
            }

            Plans.STANDARD -> {
                "https://api.qweather.com/v7"
            }

            Plans.CUSTOM -> {
                "https://api.qweather.com/v7"
            }
        }
        Global.key = key
        logger.info("Current Plan: $plan, Current API Host: ${Global.rootAPI}")
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

    fun storm(): Tropical {
        return Tropical()
    }

    fun ocean(): Ocean {
        return Ocean()
    }

    fun solarRadiation() {
        TODO("No data can be display")
    }

    fun astronomy(): Astronomy {
        return Astronomy()
    }
}
