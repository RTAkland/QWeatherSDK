/*
 * Copyright 2024 RTAkland
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


package cn.rtast.qwsdk.enums

enum class BasinType(val description: String, val descriptionZH: String) {
    AL("North Atlantic", "北太平洋"),
    EP("Eastern Pacific", "东太平洋"),
    NP("NorthWest Pacific", "西北太平洋"),
    SP("SouthWestern Pacific", "西南太平洋"),
    NI("North Indian", "北印度洋"),
    SI("South Indian", "南印度洋");

    override fun toString(): String = name
}