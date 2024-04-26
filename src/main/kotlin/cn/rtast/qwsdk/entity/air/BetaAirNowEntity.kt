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

package cn.rtast.qwsdk.entity.air

data class BetaAirNowEntity(
    val aqi: List<AQI>,
    val code: String,
    val pollutant: List<Pollutant>,
    val source: List<String>,
    val station: List<Station>,
    val updateTime: String,
) {
    data class AQI(
        val category: String,
        val code: String,
        val color: String,
        val defaultLocalAqi: Boolean,
        val health: Health,
        val level: String,
        val name: String,
        val primaryPollutant: PrimaryPollutant,
        val value: Int,
        val valueDisplay: String,
    )

    data class Health(
        val advice: Advice,
        val effect: String,
    )

    data class Advice(
        val generalPopulation: String,
        val sensitivePopulation: String,
    )


    data class PrimaryPollutant(
        val code: String,
        val fullName: String,
        val name: String,
    )

    data class Station(
        val id: String,
        val name: String,
    )

    data class SubIndex(
        val value: Int,
        val valueDisplay: String,
    )

    data class Pollutant(
        val code: String,
        val concentration: Concentration,
        val fullName: String,
        val name: String,
        val subIndex: SubIndex,
    )
}