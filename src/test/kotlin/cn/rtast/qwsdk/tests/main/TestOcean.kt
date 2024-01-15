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

import cn.rtast.qwsdk.tests.Initial.qw
import cn.rtast.qwsdk.tests.utils.getCurrentDate
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TestOcean {

    @Test
    fun tideTest() {
        val result = qw.ocean().tide("P2951", getCurrentDate())
        assertEquals(result.code.toInt(), 200)
    }

    @Test
    fun currentsTest() {
        val result = qw.ocean().currents("P66981", getCurrentDate())
        assertEquals(result.code.toInt(), 200)
    }
}