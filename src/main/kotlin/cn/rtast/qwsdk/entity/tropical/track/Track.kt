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

package cn.rtast.qwsdk.entity.tropical.track

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
    val windSpeed: String
)