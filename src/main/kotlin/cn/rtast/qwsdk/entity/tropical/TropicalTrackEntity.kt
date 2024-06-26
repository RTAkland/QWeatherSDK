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

data class TropicalTrackEntity(
    val code: String,
    val fxLink: String,
    val isActive: String,
    val now: Now,
    val refer: Refer,
    val track: List<Track>,
    val updateTime: String,
) {
    data class Now(
        val lat: String,
        val lon: String,
        val move360: String,
        val moveDir: String,
        val moveSpeed: String,
        val pressure: String,
        val pubTime: String,
        val type: String,
        val windRadius30: WindRadius30,
        val windRadius50: WindRadius30,
        val windRadius64: WindRadius30,
        val windSpeed: String,
    )

    data class WindRadius30(
        val neRadius: String,
        val nwRadius: String,
        val seRadius: String,
        val swRadius: String,
    )

    data class Track(
        val lat: String,
        val lon: String,
        val move360: String,
        val moveDir: String,
        val moveSpeed: String,
        val pressure: String,
        val time: String,
        val type: String,
        val windRadius30: WindRadius30,
        val windRadius50: WindRadius30,
        val windRadius64: WindRadius30,
        val windSpeed: String,
    )
}