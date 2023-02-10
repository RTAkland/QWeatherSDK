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

package cn.rtast.qwsdk.utils

import cn.rtast.qwsdk.exceptions.InvalidDateException


class DateUtil(private val date: String) {
    fun verifyYMD() {
        if (date.length != 8) {
            throw InvalidDateException("Invalid Date length: ${date.length}, expect: 8!")
        }

        val year = date.substring(0, 4).toInt()
        val month = date.substring(4, 6).toInt()
        val day = date.substring(6, 8).toInt()

        if (month !in 1..12) {
            throw InvalidDateException("Invalid month: ${month}.")
        }

        val isLeapYear = if (year % 4 == 0) {
            if (year % 100 == 0) {
                year % 400 == 0
            } else
                true
        } else
            false

        if (!isLeapYear && day == 29) {
            throw InvalidDateException("Invalid Day: ${day}.")
        }
    }

    fun verifyHM() {
        if (date.length != 4) {
            throw InvalidDateException("Invalid Date length: ${date.length}, expect: 4!")
        }
        val hour = date.substring(0, 2).toInt()
        val minute = date.substring(2, 4).toInt()
        if (hour !in 0..24) {
            throw InvalidDateException("Invalid Hour: ${hour}.")
        }

        if (minute !in 0..60) {
            throw InvalidDateException("Invalid Minute: ${minute}.")
        }
    }
}