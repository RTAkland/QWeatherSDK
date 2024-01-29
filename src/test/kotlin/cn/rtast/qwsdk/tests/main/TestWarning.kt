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

package cn.rtast.qwsdk.tests.main

import cn.rtast.qwsdk.QWeatherSDK.CountryCode
import cn.rtast.qwsdk.QWeatherSDK.Lang
import cn.rtast.qwsdk.tests.QWeatherSDKTest.qw
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TestWarning {

    @Test
    fun nowTest() {
        val id = qw.warning().list(CountryCode.CN).warningLocList[0].locationId
        val result = qw.warning().now(id, Lang.ZH).apply {
            warning.forEach {
                println(it)
            }
        }
        assertEquals(result.code.toInt(), 200)
    }

    @Test
    fun listTest() {
        val result = qw.warning().list(CountryCode.CN).apply {
            warningLocList.forEach {
                println(it)
            }
        }
        assertEquals(result.code.toInt(), 200)
    }
}