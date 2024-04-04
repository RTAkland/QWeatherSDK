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

enum class IndicesType(val type: Int, val descZH: String) {
    ALL(0, "全部天气指数"),
    SPT(1, "运动指数"),
    CW(2, "洗车指数"),
    DRSG(3, "穿衣指数"),
    FIS(4, "钓鱼指数"),
    UV(5, "紫外线指数"),
    TRA(6, "旅游指数"),
    AG(7, "花粉过敏指数"),
    COMF(8, "舒适度指数"),
    FLU(9, "感冒指数"),
    AP(10, "空气污染扩散条件指数"),
    AC(11, "空调开启指数"),
    GL(12, "太阳镜指数"),
    MU(13, "化妆指数"),
    DC(14, "晾晒指数"),
    PTFC(15, "交通指数"),
    SPI(16, "防晒指数")
}