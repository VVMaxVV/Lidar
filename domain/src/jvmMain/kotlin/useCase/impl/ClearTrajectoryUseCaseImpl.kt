package useCase.impl

import repository.TrajectoryRepository
import useCase.ClearTrajectoryUseCase

internal class ClearTrajectoryUseCaseImpl(private val trajectoryRepository: TrajectoryRepository) : ClearTrajectoryUseCase {
    override fun execute() {
        trajectoryRepository.clearTrajectory()
    }
}
