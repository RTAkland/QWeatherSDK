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

import cn.rtast.qwsdk.enums.IndicesType
import cn.rtast.qwsdk.tests.utils.getInstance
import cn.rtast.qwsdk.tests.utils.randomID
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TestIndices {

    private val locationID = randomID()
    private val qw = getInstance()

    @Test
    fun indices1dTest() {
        val result = qw.indices().indices1d(locationID).apply {
            daily.forEach {
                println(it)
            }
        }
        assertEquals(result.code.toInt(), 200)
    }

    @Test
    fun indices3d() {
        val result = qw.indices().indices3d(
            locationID, types = listOf(IndicesType.AC, IndicesType.CW)
        ).apply {
            daily.forEach { println(it) }
        }
        assertEquals(result.code.toInt(), 200)
    }
}