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
import cn.rtast.qwsdk.tests.utils.getCurrentDate
import cn.rtast.qwsdk.tests.utils.randomID
import cn.rtast.qwsdk.utils.Coordinate
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TestAstronomy {

    private val locationID = randomID()

    @Test
    fun sunTest() {
        val result = qw.astronomy().sun(locationID, getCurrentDate()).apply {
            println(this)
        }
        assertEquals(result.code.toInt(), 200)
    }

    @Test
    fun moonTest() {
        val result = qw.astronomy().moon(locationID, getCurrentDate()).apply {
            println(this)
        }
        assertEquals(result.code.toInt(), 200)
    }

    @Test
    fun solarElevationAngleTest() {
        val result = qw.astronomy().solarElevationAngle(
            Coordinate(116.41, 39.92), "20170809", "1230", "0800", 43
        ).apply {
            println(this)
        }
        assertEquals(result.code.toInt(), 200)
    }
}