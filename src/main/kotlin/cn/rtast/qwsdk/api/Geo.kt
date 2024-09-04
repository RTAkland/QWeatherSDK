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

package cn.rtast.qwsdk.api

import cn.rtast.qwsdk.QWeatherSDK
import cn.rtast.qwsdk.entity.geo.GeoLookupEntity
import cn.rtast.qwsdk.entity.geo.GeoTopEntity
import cn.rtast.qwsdk.entity.geo.POIEntity
import cn.rtast.qwsdk.entity.geo.POIRangeEntity
import cn.rtast.qwsdk.enums.CountryCode
import cn.rtast.qwsdk.enums.Lang
import cn.rtast.qwsdk.enums.POIType
import cn.rtast.qwsdk.exceptions.GeoNumberException
import cn.rtast.qwsdk.utils.Coordinate
import cn.rtast.qwsdk.utils.Http

object Geo {

    @JvmOverloads
    @Throws(GeoNumberException::class)
    fun citySearch(
        location: String,
        adm: String? = null,
        range: CountryCode = CountryCode.CN,
        number: Int = 10,
        lang: Lang = Lang.ZH,
    ): GeoLookupEntity {
        if (number !in 1..20) {  // range 1-20
            throw GeoNumberException("Invalid Range: $number, please choose from 1-20!")
        }
        return Http.get<GeoLookupEntity>(
            QWeatherSDK.GEO_API + "city/lookup",
            params = mapOf(
                "location" to location,
                "adm" to adm,
                "range" to range,
                "number" to number,
                "lang" to lang.toString()
            )
        )
    }

    @JvmOverloads
    @Throws(GeoNumberException::class)
    fun citySearchAsync(
        location: String,
        adm: String? = null,
        range: CountryCode = CountryCode.CN,
        number: Int = 10,
        lang: Lang = Lang.ZH,
        onRequest: (GeoLookupEntity?) -> Unit
    ) {
        if (number !in 1..20) {  // range 1-20
            throw GeoNumberException("Invalid Range: $number, please choose from 1-20!")
        }
        Http.getAsync<GeoLookupEntity>(
            QWeatherSDK.GEO_API + "city/lookup",
            params = mapOf(
                "location" to location,
                "adm" to adm,
                "range" to range,
                "number" to number,
                "lang" to lang.toString()
            )
        ) { onRequest(it) }
    }

    @JvmOverloads
    @Throws(GeoNumberException::class)
    fun citySearch(
        location: Coordinate,
        adm: String? = null,
        range: CountryCode = CountryCode.CN,
        number: Int = 10,
        lang: Lang = Lang.ZH,
    ): GeoLookupEntity {
        return this.citySearch(location(), adm, range, number, lang)
    }

    @JvmOverloads
    @Throws(GeoNumberException::class)
    fun citySearchAsync(
        location: Coordinate,
        adm: String? = null,
        range: CountryCode = CountryCode.CN,
        number: Int = 10,
        lang: Lang = Lang.ZH,
        onRequest: (GeoLookupEntity?) -> Unit
    ) {
        this.citySearchAsync(location(), adm, range, number, lang) { onRequest }
    }

    @JvmOverloads
    @Throws(GeoNumberException::class)
    fun topCity(
        range: CountryCode = CountryCode.CN,
        number: Int = 10,
        lang: Lang = Lang.ZH,
    ): GeoTopEntity {
        if (number !in 1..20) {  // range 1-20
            throw GeoNumberException("Invalid Range: $number, please choose from 1-20!")
        }
        return Http.get<GeoTopEntity>(
            QWeatherSDK.GEO_API + "city/top",
            params = mapOf(
                "range" to range,
                "number" to number,
                "lang" to lang.toString()
            )
        )
    }

    @JvmOverloads
    @Throws(GeoNumberException::class)
    fun topCityAsync(
        range: CountryCode = CountryCode.CN,
        number: Int = 10,
        lang: Lang = Lang.ZH,
        onRequest: (GeoTopEntity?) -> Unit
    ) {
        if (number !in 1..20) {  // range 1-20
            throw GeoNumberException("Invalid Range: $number, please choose from 1-20!")
        }
        Http.getAsync<GeoTopEntity>(
            QWeatherSDK.GEO_API + "city/top",
            params = mapOf(
                "range" to range,
                "number" to number,
                "lang" to lang.toString()
            )
        ) { onRequest(it) }
    }

    @JvmOverloads
    @Throws(GeoNumberException::class)
    fun poiLookup(
        location: String,
        type: POIType,
        city: String? = null,
        number: Int = 10,
        lang: Lang = Lang.ZH,
    ): POIEntity {
        if (number !in 1..20) {  // range 1-20
            throw GeoNumberException("Invalid Range: $number, please choose from 1-20!")
        }
        return Http.get<POIEntity>(
            QWeatherSDK.GEO_API + "poi/lookup",
            params = mapOf(
                "location" to location,
                "type" to type,
                "city" to city,
                "number" to number,
                "lang" to lang.toString()
            )
        )
    }

    @JvmOverloads
    @Throws(GeoNumberException::class)
    fun poiLookupAsync(
        location: String,
        type: POIType,
        city: String? = null,
        number: Int = 10,
        lang: Lang = Lang.ZH,
        onRequest: (POIEntity?) -> Unit
    ) {
        if (number !in 1..20) {  // range 1-20
            throw GeoNumberException("Invalid Range: $number, please choose from 1-20!")
        }
        Http.getAsync<POIEntity>(
            QWeatherSDK.GEO_API + "poi/lookup",
            params = mapOf(
                "location" to location,
                "type" to type,
                "city" to city,
                "number" to number,
                "lang" to lang.toString()
            )
        ) { onRequest(it) }
    }

    @JvmOverloads
    @Throws(GeoNumberException::class)
    fun poiLookup(
        location: Coordinate,
        type: POIType,
        city: String? = null,
        number: Int = 10,
        lang: Lang = Lang.ZH,
    ): POIEntity {
        return this.poiLookup(location(), type, city, number, lang)
    }

    @JvmOverloads
    @Throws(GeoNumberException::class)
    fun poiLookupAsync(
        location: Coordinate,
        type: POIType,
        city: String? = null,
        number: Int = 10,
        lang: Lang = Lang.ZH,
        onRequest: (POIEntity?) -> Unit
    ) {
        this.poiLookupAsync(location(), type, city, number, lang) { onRequest }
    }

    @JvmOverloads
    @Throws(GeoNumberException::class)
    fun poiRange(
        location: Coordinate,
        type: POIType,
        radius: Int = 5,
        city: String? = null,
        number: Int = 10,
        lang: Lang = Lang.ZH,
    ): POIRangeEntity {
        if (number !in 1..20) {  // range 1-20
            throw GeoNumberException("Invalid Range: $number, please choose from 1-20!")
        }
        if (radius !in 1..50) {  // range 1-50
            throw GeoNumberException("Invalid Radius: $radius, please choose from 1-50!")
        }
        return Http.get<POIRangeEntity>(
            QWeatherSDK.GEO_API + "poi/range",
            params = mapOf(
                "location" to location(),
                "radius" to radius,
                "city" to city,
                "number" to number,
                "lang" to lang.toString(),
                "type" to type.id
            )
        )
    }

    @JvmOverloads
    @Throws(GeoNumberException::class)
    fun poiRangeAsync(
        location: Coordinate,
        type: POIType,
        radius: Int = 5,
        city: String? = null,
        number: Int = 10,
        lang: Lang = Lang.ZH,
        onRequest: (POIRangeEntity?) -> Unit
    ) {
        if (number !in 1..20) {  // range 1-20
            throw GeoNumberException("Invalid Range: $number, please choose from 1-20!")
        }
        if (radius !in 1..50) {  // range 1-50
            throw GeoNumberException("Invalid Radius: $radius, please choose from 1-50!")
        }
        Http.getAsync<POIRangeEntity>(
            QWeatherSDK.GEO_API + "poi/range",
            params = mapOf(
                "location" to location(),
                "radius" to radius,
                "city" to city,
                "number" to number,
                "lang" to lang.toString(),
                "type" to type.id
            )
        ) { onRequest(it) }
    }
}
