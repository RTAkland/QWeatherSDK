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

package cn.rtast.qwsdk.entity.tropical

import cn.rtast.qwsdk.entity.Refer

data class TropicalForecastEntity(
    val code: String,
    val forecast: List<Forecast>,
    val fxLink: String,
    val refer: Refer,
    val updateTime: String,
) {
    data class Forecast(
        val fxTime: String,
        val lat: String,
        val lon: String,
        val move360: String,
        val moveDir: String,
        val moveSpeed: String,
        val pressure: String,
        val type: String,
        val windSpeed: String,
    )
}