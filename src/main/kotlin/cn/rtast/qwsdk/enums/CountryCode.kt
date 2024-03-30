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

enum class CountryCode {
    AF, AX, AL, DZ, AS, AD, AO, AI, AQ, AG,
    AR, AM, AW, AU, AT, AZ, BS, BH, BD, BB,
    BY, BE, BZ, BJ, BM, BT, BO, BQ, BA, BW,
    BV, BR, IO, BN, BG, BF, BI, CV, KH, CM,
    CA, KY, CF, TD, CL, CN, CX, CC, CO, KM,
    CG, CD, CK, CR, CI, HR, CU, CW, CY, CZ,
    DK, DJ, DM, DO, EC, EG, SV, GQ, ER, EE,
    ET, FK, FO, FJ, FI, FR, GF, PF, TF, GA,
    GM, GE, DE, GH, GI, GR, GL, GD, GP, GU,
    GT, GG, GN, GW, GY, HT, HM, VA, HN, HK,
    HU, IS, IN, ID, IR, IQ, IE, IM, IL, IT,
    JM, JP, JE, JO, KZ, KE, KI, KP, KR, KW,
    KG, LA, LV, LB, LS, LR, LY, LI, LT, LU,
    MO, MK, MG, MW, MY, MV, ML, MT, MH, MQ,
    MR, MU, YT, MX, FM, MD, MC, MN, ME, MS,
    MA, MZ, MM, NA, NR, NP, NL, NC, NZ, NI,
    NE, NG, NU, NF, MP, NO, OM, PK, PW, PS,
    PA, PG, PY, PE, PH, PN, PL, PT, PR, QA,
    RE, RO, RU, RW, BL, SH, KN, LC, MF, PM,
    VC, WS, SM, ST, SA, SN, RS, SC, SL, SG,
    SX, SK, SI, SB, SO, ZA, GS, SS, ES, LK,
    SD, SR, SJ, SZ, SE, CH, SY, TW, TJ, TZ,
    TH, TL, TG, TK, TO, TT, TN, TR, TM, TC,
    TV, UG, UA, AE, GB, US, UM, UY, UZ, VU,
    VE, VN, VG, VI, WF, EH, YE, ZM, ZW;

    override fun toString(): String = name.lowercase()
}