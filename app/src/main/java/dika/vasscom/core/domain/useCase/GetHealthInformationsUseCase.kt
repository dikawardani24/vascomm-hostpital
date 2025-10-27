package dika.vasscom.core.domain.useCase

import dika.vasscom.core.domain.model.HealthInfo
import dika.vasscom.core.domain.repository.HospitalRepository

class GetHealthInformationsUseCase(
    private val hospitalRepository: HospitalRepository
) {
    suspend fun execute(): List<HealthInfo> =
        hospitalRepository.getHealthInformations()
}