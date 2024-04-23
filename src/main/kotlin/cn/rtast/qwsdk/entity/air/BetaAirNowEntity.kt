package cn.rtast.qwsdk.entity.air

data class BetaAirNowEntity(
    val aqi: List<AQI>,
    val code: String,
    val pollutant: List<Pollutant>,
    val source: List<String>,
    val station: List<Station>,
    val updateTime: String,
) {
    data class AQI(
        val category: String,
        val code: String,
        val color: String,
        val defaultLocalAqi: Boolean,
        val health: Health,
        val level: String,
        val name: String,
        val primaryPollutant: PrimaryPollutant,
        val value: Int,
        val valueDisplay: String,
    )

    data class Health(
        val advice: Advice,
        val effect: String,
    )

    data class Advice(
        val generalPopulation: String,
        val sensitivePopulation: String,
    )


    data class PrimaryPollutant(
        val code: String,
        val fullName: String,
        val name: String,
    )

    data class Station(
        val id: String,
        val name: String,
    )

    data class SubIndex(
        val value: Int,
        val valueDisplay: String,
    )

    data class Pollutant(
        val code: String,
        val concentration: Concentration,
        val fullName: String,
        val name: String,
        val subIndex: SubIndex,
    )
}