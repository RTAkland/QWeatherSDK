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

import cn.rtast.qwsdk.QWeatherSDK

fun parseIndices(indices: QWeatherSDK.IndicesType): Int {
    val number = when (indices) {
        QWeatherSDK.IndicesType.ALL -> 0
        QWeatherSDK.IndicesType.SPORT -> 1
        QWeatherSDK.IndicesType.WASH_CAR -> 2
        QWeatherSDK.IndicesType.CLOTHING -> 3
        QWeatherSDK.IndicesType.FISHING -> 4
        QWeatherSDK.IndicesType.UV_RAY -> 5
        QWeatherSDK.IndicesType.TRAVEL -> 6
        QWeatherSDK.IndicesType.POLLEN_ALLERGY -> 7
        QWeatherSDK.IndicesType.COMFORT -> 8
        QWeatherSDK.IndicesType.COLD -> 9
        QWeatherSDK.IndicesType.AIR_POLLUTION_DIFFUSION_CONDITION -> 10
        QWeatherSDK.IndicesType.AIR_CONDITIONER -> 11
        QWeatherSDK.IndicesType.SUNGLASSES -> 12
        QWeatherSDK.IndicesType.MAKEUP -> 13
        QWeatherSDK.IndicesType.DRYING -> 14
        QWeatherSDK.IndicesType.TRAFFIC -> 15
        QWeatherSDK.IndicesType.SPF -> 16
    }
    return number
}
