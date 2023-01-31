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

import cn.rtast.qwsdk.exceptions.InvalidDateException
import cn.rtast.qwsdk.utils.verifyHM
import cn.rtast.qwsdk.utils.verifyYMD
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class TestDateUtil {

    @Test
    fun verifyYMDTest() {
        assertThrows<InvalidDateException> {
            verifyYMD("202201021")  // wrong length
            verifyYMD("20210229")  // not leap year
            verifyYMD("20221320")  // Month 13 (
        }

        assertDoesNotThrow {
            verifyYMD("20230110")  // correct
        }
    }

    @Test
    fun verifyHMTest() {
        assertThrows<InvalidDateException> {
            verifyHM("3010")
            verifyHM("22100")
            verifyHM("1961")
        }

        assertDoesNotThrow {
            verifyHM("0110")
        }
    }
}