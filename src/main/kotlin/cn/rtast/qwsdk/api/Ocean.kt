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

package cn.rtast.qwsdk.api

import cn.rtast.qwsdk.QWeatherSDK
import cn.rtast.qwsdk.entity.ocean.CurrentsEntity
import cn.rtast.qwsdk.entity.ocean.TideEntity
import cn.rtast.qwsdk.utils.DateUtil
import cn.rtast.qwsdk.utils.Http

object Ocean {

    fun tide(
        location: String,
        date: String,
    ): TideEntity {
        DateUtil(date).validateYMD()
        return Http.get<TideEntity>(
            QWeatherSDK.rootAPI + "ocean/tide",
            params = mapOf(
                "location" to location,
                "date" to date
            )
        )
    }

    fun tideAsync(
        location: String,
        date: String,
        onRequest: (TideEntity?) -> Unit
    ) {
        DateUtil(date).validateYMD()
        return Http.getAsync<TideEntity>(
            QWeatherSDK.rootAPI + "ocean/tide",
            params = mapOf(
                "location" to location,
                "date" to date
            )
        ) { onRequest(it) }
    }

    fun currents(
        location: String,
        date: String,
    ) {
        DateUtil(date).validateYMD()
        Http.get<CurrentsEntity>(
            QWeatherSDK.rootAPI + "ocean/currents",
            params = mapOf(
                "location" to location,
                "date" to date
            )
        )
    }

    fun currentsAsync(
        location: String,
        date: String,
        onRequest: (CurrentsEntity?) -> Unit
    ) {
        DateUtil(date).validateYMD()
        Http.getAsync<CurrentsEntity>(
            QWeatherSDK.rootAPI + "ocean/currents",
            params = mapOf(
                "location" to location,
                "date" to date
            )
        ) { onRequest(it) }
    }
}