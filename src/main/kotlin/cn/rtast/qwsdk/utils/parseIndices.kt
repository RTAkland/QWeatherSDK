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

package cn.rtast.qwsdk.utils

import cn.rtast.qwsdk.QWeather

fun parseIndices(indices: QWeather.IndicesType): Int {
    val number = when (indices) {
        QWeather.IndicesType.ALL -> 0
        QWeather.IndicesType.SPORT -> 1
        QWeather.IndicesType.WASH_CAR -> 2
        QWeather.IndicesType.CLOTHING -> 3
        QWeather.IndicesType.FISHING -> 4
        QWeather.IndicesType.UV_RAY -> 5
        QWeather.IndicesType.TRAVEL -> 6
        QWeather.IndicesType.POLLEN_ALLERGY -> 7
        QWeather.IndicesType.COMFORT -> 8
        QWeather.IndicesType.COLD -> 9
        QWeather.IndicesType.AIR_POLLUTION_DIFFUSION_CONDITION -> 10
        QWeather.IndicesType.AIR_CONDITIONER -> 11
        QWeather.IndicesType.SUNGLASSES -> 12
        QWeather.IndicesType.MAKEUP -> 13
        QWeather.IndicesType.DRYING -> 14
        QWeather.IndicesType.TRAFFIC -> 15
        QWeather.IndicesType.SPF -> 16
    }
    return number
}
