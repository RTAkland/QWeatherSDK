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

import cn.rtast.qwsdk.tests.QWeatherSDKTest.qw
import cn.rtast.qwsdk.tests.utils.getCurrentYear
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TestTropical {
    @Test
    fun forecastTest() {
        val id = qw.tropical().list(getCurrentYear()).storm[0].id
        val result = qw.tropical().forecast(id).apply {
            forecast.forEach {
                println(it)
            }
        }
        assertEquals(result.code.toInt(), 200)
    }

    @Test
    fun trackTest() {
        val id = qw.tropical().list(getCurrentYear()).storm[0].id
        val result = qw.tropical().track(id).apply {
            track.forEach {
                println(it)
            }
        }
        assertEquals(result.code.toInt(), 200)
    }

    @Test
    fun listTest() {
        val result = qw.tropical().list(getCurrentYear()).apply {
            storm.forEach {
                println(it)
            }
        }
        assertEquals(result.code.toInt(), 200)
    }
}
