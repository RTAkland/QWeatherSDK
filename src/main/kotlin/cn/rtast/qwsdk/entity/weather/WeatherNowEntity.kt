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

package cn.rtast.qwsdk.entity.weather

import cn.rtast.qwsdk.entity.Refer

data class WeatherNowEntity(
    val code: String,
    val fxLink: String,
    val now: Now,
    val refer: Refer,
    val updateTime: String,
) {
    data class Now(
        val cloud: String,
        val dew: String,
        val feelsLike: String,
        val humidity: String,
        val icon: String,
        val obsTime: String,
        val precip: String,
        val pressure: String,
        val temp: String,
        val text: String,
        val vis: String,
        val wind360: String,
        val windDir: String,
        val windScale: String,
        val windSpeed: String,
    )
}