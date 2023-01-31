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

import cn.rtast.qwsdk.enums.Lang
import cn.rtast.qwsdk.tests.Initial.qw
import cn.rtast.qwsdk.tests.utils.randomID
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

class TestAir {

    private val locationId = randomID()

    @Test
    fun airTest() {
        val result = qw.air().now(locationId, Lang.EN)
        assertNotNull(result)
    }

    @Test
    fun dailyTest() {
        val result = qw.air().daily(locationId, Lang.EN)
        assertNotNull(result)
    }
}