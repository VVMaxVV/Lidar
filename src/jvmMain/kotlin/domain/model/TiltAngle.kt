package domain.model

import domain.utils.plus
import domain.utils.rem

data class TiltAngle(private var angleOnXPlane: Number = 0) {
    var getAngleOnXPlane: Number = angleOnXPlane
        private set

    init {
        getAngleOnXPlane %= 360
    }

    fun rotateOnXPlane(angle: Number) {
        getAngleOnXPlane = (getAngleOnXPlane + angle) % 360
    }
}
