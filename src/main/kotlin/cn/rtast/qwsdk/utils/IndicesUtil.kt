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

import cn.rtast.qwsdk.enums.IndicesType

class IndicesUtil {
    fun p(indices: IndicesType): Int {
        val number = when (indices) {
            IndicesType.ALL -> 0
            IndicesType.SPORT -> 1
            IndicesType.WASH_CAR -> 2
            IndicesType.CLOTHING -> 3
            IndicesType.FISHING -> 4
            IndicesType.UV_RAY -> 5
            IndicesType.TRAVEL -> 6
            IndicesType.POLLEN_ALLERGY -> 7
            IndicesType.COMFORT -> 8
            IndicesType.COLD -> 9
            IndicesType.AIR_POLLUTION_DIFFUSION_CONDITION -> 10
            IndicesType.AIR_CONDITIONER -> 11
            IndicesType.SUNGLASSES -> 12
            IndicesType.MAKEUP -> 13
            IndicesType.DRYING -> 14
            IndicesType.TRAFFIC -> 15
            IndicesType.SPF -> 16
        }
        return number
    }
}