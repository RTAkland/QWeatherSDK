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

package cn.rtast.qwsdk.sub

import cn.rtast.qwsdk.entity.ocean.currents.CurrentsBean
import cn.rtast.qwsdk.entity.ocean.tide.TideBean
import cn.rtast.qwsdk.utils.DateUtil
import cn.rtast.qwsdk.utils.get
import cn.rtast.qwsdk.utils.makeParam
import com.google.gson.Gson

class Ocean {

    private val gson = Gson()

    fun tide(
        location: String,
        date: String
    ): TideBean {
        DateUtil(date).verifyYMD()
        val url = makeParam(
            "ocean/tide",
            mapOf(
                "location" to location,
                "date" to date
            )
        )
        val result = get(url)
        return gson.fromJson(result, TideBean::class.java)
    }

    fun currents(
        location: String,
        date: String
    ): CurrentsBean {
        DateUtil(date).verifyYMD()
        val url = makeParam(
            "ocean/currents",
            mapOf(
                "location" to location,
                "date" to date
            )
        )
        val result = get(url)
        return gson.fromJson(result, CurrentsBean::class.java)
    }
}