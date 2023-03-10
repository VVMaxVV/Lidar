package data.factory

import androidx.compose.ui.geometry.Offset
import domain.model.*
import domain.utils.div
import domain.utils.getX
import domain.utils.getY
import domain.utils.plus

internal class RaysFactory {
    fun get(
        rayTracingConfiguration: RayTracingConfiguration,
        currentPosition: Position = Position(Point(), TiltAngle())
    ): List<Ray> {
        val raysList = mutableListOf<Ray>()
        val startDestinationDegree =
            rayTracingConfiguration.horizontalFov / 2 - rayTracingConfiguration.horizontalFov /
                    (rayTracingConfiguration.numbersOfRay * 2)
        val degreeDivision = rayTracingConfiguration.horizontalFov / rayTracingConfiguration.numbersOfRay
        for (rayNumber in 0 until rayTracingConfiguration.numbersOfRay) {
            raysList.add(
                Ray(
                    start = Offset(
                        currentPosition.currentCoordinates.x.toFloat(),
                        currentPosition.currentCoordinates.y.toFloat()
                    ),
                    end = Offset(
                        getX(
                            rayTracingConfiguration.maxLength,
                            (90 - startDestinationDegree + currentPosition.currentTiltAngle.getAngleOnXPlane)
                                    + degreeDivision * rayNumber,
                            currentPosition.currentCoordinates.x
                        ),
                        getY(
                            rayTracingConfiguration.maxLength,
                            (90 - startDestinationDegree + currentPosition.currentTiltAngle.getAngleOnXPlane)
                                    + degreeDivision * rayNumber,
                            currentPosition.currentCoordinates.y
                        )
                    )
                )
            )
        }
        return raysList
    }
}
