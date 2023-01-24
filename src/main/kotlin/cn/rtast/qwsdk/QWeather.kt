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

object QWeather {
    private val plan: Plans? = null

    const val GEOAPI = "https://geoapi.qweather.com/v2"

    var rootAPI: String = "https://devapi.qweather.com/v7"

    var key: String? = null

    fun switchPlan(plan: Plans, key: String) {
        rootAPI = when (plan) {
            Plans.FREE -> {
                "https://devapi.qweather.com/v7/weather"
            }

            Plans.STANDARD -> {
                "https://api.qweather.com/v7/weather"
            }

            Plans.CUSTOM -> {
                "https://api.qweather.com/v7/weather"
            }
        }
        this.key = key
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

    fun sea(){
        TODO()
    }

    fun radiation() {
        TODO()
    }

    fun sunAndMoon() {
        TODO()
    }

}


fun main() {
    val qweater = QWeather
    qweater.switchPlan(Plans.FREE, "0e03e86c8f5441af869237052f365d41")
    qweater.air().now("101010100")
}
