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

package cn.rtast.qwsdk.entity.historical

import cn.rtast.qwsdk.entity.Refer

data class AirHistoricalEntity(
    val airHourly: List<AirHourly>,
    val code: String,
    val fxLink: String,
    val refer: Refer,
) {
    data class AirHourly(
        val aqi: String,
        val category: String,
        val co: String,
        val level: String,
        val no2: String,
        val o3: String,
        val pm10: String,
        val pm2p5: String,
        val primary: String,
        val pubTime: String,
        val so2: String,
    )
}