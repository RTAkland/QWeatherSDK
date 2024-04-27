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
import cn.rtast.qwsdk.utils.DateUtil
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class TestDateUtil {

    @Test
    fun verifyYMDTest() {
        assertThrows<InvalidDateException> {
            DateUtil("202201021").validateYMD()  // wrong length
            DateUtil("20210229").validateYMD()  // not leap year
            DateUtil("20221320").validateYMD()  // Month 13 (
        }

        assertDoesNotThrow {
            DateUtil("20230110").validateYMD()  // correct
        }
    }

    @Test
    fun verifyHMTest() {
        assertThrows<InvalidDateException> {
            DateUtil("3010").validateHM()
            DateUtil("22100").validateHM()
            DateUtil("1961").validateHM()
        }

        assertDoesNotThrow {
            DateUtil("0110").validateHM()
        }
    }
}