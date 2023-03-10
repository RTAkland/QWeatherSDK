package cn.rtast.qwsdk.tests

import cn.rtast.qwsdk.QWeather
import cn.rtast.qwsdk.enums.Plans
import cn.rtast.qwsdk.tests.errs.NoKeyFoundException

object Initial {

    val qw = QWeather()

    init {
        val envs = System.getenv()
        if (!envs.containsKey("QW_KEY") || !envs.containsKey("QW_PLAN")) {
            throw NoKeyFoundException("Couldn't find QW_KEY or QW_PLAN in env.")
        } else {
            val qwPlan = envs["QW_PLAN"]
            val type: Plans = when (qwPlan!!.lowercase()) {
                "standard" -> Plans.Standard
                "custom" -> Plans.Custom
                else -> Plans.Free
            }
            qw.init(type, envs["QW_KEY"]!!)
        }
    }
}