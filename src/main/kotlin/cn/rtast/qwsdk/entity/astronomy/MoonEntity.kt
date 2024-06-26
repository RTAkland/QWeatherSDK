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

package cn.rtast.qwsdk.entity.astronomy

import cn.rtast.qwsdk.entity.Refer

data class MoonEntity(
    val code: String,
    val fxLink: String,
    val moonPhase: List<MoonPhase>,
    val moonrise: String,
    val moonset: String,
    val refer: Refer,
    val updateTime: String,
) {
    data class MoonPhase(
        val fxTime: String,
        val icon: String,
        val illumination: String,
        val name: String,
        val value: String,
    )

    data class SolarElevationAngleEntity(
        val code: String,
        val hourAngle: String,
        val refer: Refer,
        val solarAzimuthAngle: String,
        val solarElevationAngle: String,
        val solarHour: String,
    )
}