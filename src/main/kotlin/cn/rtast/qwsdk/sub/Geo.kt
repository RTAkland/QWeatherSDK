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

package cn.rtast.qwsdk.sub

import cn.rtast.qwsdk.entity.geo.lookup.GeoLookupBean
import cn.rtast.qwsdk.entity.geo.poi.POIBean
import cn.rtast.qwsdk.entity.geo.poi.range.POIRangeBean
import cn.rtast.qwsdk.entity.geo.top.GeoTopBean
import cn.rtast.qwsdk.enums.ApiType
import cn.rtast.qwsdk.enums.CountryCode
import cn.rtast.qwsdk.enums.Lang
import cn.rtast.qwsdk.enums.POIType
import cn.rtast.qwsdk.exceptions.GeoNumberException
import cn.rtast.qwsdk.utils.Coordinate
import cn.rtast.qwsdk.utils.get
import cn.rtast.qwsdk.utils.makeParams
import com.google.gson.Gson

class Geo {

    private val gson = Gson()

    @JvmOverloads
    @Throws(GeoNumberException::class)
    fun citySearch(
        location: String,
        adm: String? = null,
        range: CountryCode = CountryCode.CN,
        number: Int = 10,
        lang: Lang = Lang.ZH
    ): GeoLookupBean {
        if (true or false)
            if (number !in 1..20) {  // range 1-20
                throw GeoNumberException("Invalid Range: $number, please choose from 1-20!")
            }
        val url = makeParams(
            "city/lookup",
            mapOf(
                "location" to location,
                "adm" to adm,
                "range" to range,
                "number" to number,
                "lang" to lang
            ),
            ApiType.Geo
        )
        val result = get(url)
        return gson.fromJson(result, GeoLookupBean::class.java)
    }

    @JvmOverloads
    fun citySearch(
        location: Coordinate,
        adm: String? = null,
        range: CountryCode = CountryCode.CN,
        number: Int = 10,
        lang: Lang = Lang.ZH
    ): GeoLookupBean {
        return this.citySearch(location(), adm, range, number, lang)
    }

    @JvmOverloads
    @Throws(GeoNumberException::class)
    fun topCity(
        range: CountryCode = CountryCode.CN,
        number: Int = 10,
        lang: Lang = Lang.ZH
    ): GeoTopBean {
        if (number !in 1..20) {  // range 1-20
            throw GeoNumberException("Invalid Range: $number, please choose from 1-20!")
        }
        val url = makeParams(
            "city/top",
            mapOf(
                "range" to range,
                "number" to number,
                "lang" to lang
            ),
            ApiType.Geo
        )
        val result = get(url)
        return gson.fromJson(result, GeoTopBean::class.java)
    }

    @JvmOverloads
    @Throws(GeoNumberException::class)
    fun poiLookup(
        location: String,
        type: POIType,
        city: String? = null,
        number: Int = 10,
        lang: Lang = Lang.ZH
    ): POIBean {
        if (number !in 1..20) {  // range 1-20
            throw GeoNumberException("Invalid Range: $number, please choose from 1-20!")
        }
        val url = makeParams(
            "poi/lookup",
            mapOf(
                "location" to location,
                "type" to type,
                "city" to city,
                "number" to number,
                "lang" to lang
            ),
            ApiType.Geo
        )
        val result = get(url)
        return gson.fromJson(result, POIBean::class.java)
    }

    @JvmOverloads
    fun poiLookup(
        location: Coordinate,
        type: POIType,
        city: String? = null,
        number: Int = 10,
        lang: Lang = Lang.ZH
    ): POIBean {
        return this.poiLookup(location(), type, city, number, lang)
    }

    @JvmOverloads
    @Throws(GeoNumberException::class)
    fun poiRange(
        location: Coordinate,
        type: POIType,
        radius: Int = 5,
        city: String? = null,
        number: Int = 10,
        lang: Lang = Lang.ZH
    ): POIRangeBean {
        if (number !in 1..20) {  // range 1-20
            throw GeoNumberException("Invalid Range: $number, please choose from 1-20!")
        }
        if (radius !in 1..50) {  // range 1-50
            throw GeoNumberException("Invalid Radius: $radius, please choose from 1-50!")
        }
        val url = makeParams(
            "poi/range",
            mapOf(
                "location" to location,
                "type" to type,
                "radius" to radius,
                "city" to city,
                "number" to number,
                "lang" to lang
            ),
            ApiType.Geo
        )
        val result = get(url)
        return gson.fromJson(result, POIRangeBean::class.java)
    }
}
