package cn.rtast.qwsdk.tests

import cn.rtast.qwsdk.QWeatherSDK
import cn.rtast.qwsdk.enums.Plans
import cn.rtast.qwsdk.tests.errs.NoKeyFoundException
import org.junit.jupiter.api.Test

object QWeatherSDKTest {

    lateinit var qw: QWeatherSDK

    init {
        val envs = System.getenv()
        if (!envs.containsKey("QW_KEY") || !envs.containsKey("QW_PLAN") || !envs.containsKey("QW_PUBLICID")) {
            throw NoKeyFoundException("Couldn't find QW_KEY or QW_PLAN in env.")
        } else {
            val qwPlan = envs["QW_PLAN"]
            val type: Plans = when (qwPlan!!.lowercase()) {
                "standard" -> Plans.Standard
                "custom" -> Plans.Custom
                else -> Plans.Free
            }
            val qwKey = envs["QW_KEY"]!!
            val qwPublicKey = envs["QW_PUBLICID"]!!
            qw = QWeatherSDK(qwKey, qwPublicKey, type)

        }
    }

    @Test
    fun startTest() {
        println()
    }
}