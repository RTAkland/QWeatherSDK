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

import cn.rtast.qwsdk.tests.utils.getInstance
import cn.rtast.qwsdk.tests.utils.randomID
import cn.rtast.qwsdk.utils.Coordinate
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TestWeather {

    private val qw = getInstance()

    private val locationID = randomID()
    private val coordinate = Coordinate(116.41, 39.92)

    @Test
    fun nowTest() {
        val result = qw.weather().now(locationID).apply {
            println(this)
        }
        assertEquals(result.code.toInt(), 200)
    }

    @Test
    fun weatherMinutelyTest() {
        val result = qw.weather().weatherMinutely(coordinate).apply {
            minutely.forEach {
                println(it)
            }
        }
        assertEquals(result.code.toInt(), 200)
    }

    @Test
    fun weather24hTest() {
        val result = qw.weather().weather24h(locationID).apply {
            hourly.forEach {
                println(it)
            }
        }
        assertEquals(result.code.toInt(), 200)
    }

    @Test
    fun weather72hTest() {
        val result = qw.weather().weather72h(locationID).apply {
            hourly.forEach {
                println(it)
            }
        }
        assertEquals(result.code.toInt(), 200)
    }

    @Test
    fun weather168hTest() {
        val result = qw.weather().weather168h(locationID).apply {
            hourly.forEach {
                println(it)
            }
        }
        assertEquals(result.code.toInt(), 200)
    }

    @Test
    fun weather3dTest() {
        val result = qw.weather().weather3d(locationID).apply {
            daily.forEach {
                println(it)
            }
        }
        assertEquals(result.code.toInt(), 200)
    }

    @Test
    fun weather7dTest() {
        val result = qw.weather().weather7d(locationID).apply {
            daily.forEach {
                println(it)
            }
        }
        assertEquals(result.code.toInt(), 200)
    }

    @Test
    fun weather15dTest() {
        val result = qw.weather().weather15d(locationID).apply {
            daily.forEach {
                println(it)
            }
        }
        assertEquals(result.code.toInt(), 200)
    }

    @Test
    fun weatherGridNowTest() {
        val result = qw.weather().weatherGridNow(coordinate).apply {
            println(this)
        }
        assertEquals(result.code.toInt(), 200)
    }

    @Test
    fun weatherGrid24hTest() {
        val result = qw.weather().weatherGrid24h(coordinate).apply {
            hourly.forEach {
                println(it)
            }
        }
        assertEquals(result.code.toInt(), 200)
    }

    @Test
    fun weatherGrid72hTest() {
        val result = qw.weather().weatherGrid72h(coordinate).apply {
            hourly.forEach {
                println(it)
            }
        }
        assertEquals(result.code.toInt(), 200)
    }

    @Test
    fun weatherGrid3dTest() {
        val result = qw.weather().weatherGrid3d(coordinate).apply {
            daily.forEach {
                println(it)
            }
        }
        assertEquals(result.code.toInt(), 200)
    }

    @Test
    fun weatherGrid7dTest() {
        val result = qw.weather().weatherGrid7d(coordinate).apply {
            daily.forEach {
                println(it)
            }
        }
        assertEquals(result.code.toInt(), 200)
    }

}