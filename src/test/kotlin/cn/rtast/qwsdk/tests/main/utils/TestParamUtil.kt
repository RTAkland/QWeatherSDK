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

package cn.rtast.qwsdk.tests.main.utils

import cn.rtast.qwsdk.utils.buildRequestURL
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class TestParamUtil {
    @Test
    fun makeTest() {
        assertDoesNotThrow {
            buildRequestURL("test/a", mapOf("1" to 2, "2" to 4, "4" to 8))
        }
    }
}