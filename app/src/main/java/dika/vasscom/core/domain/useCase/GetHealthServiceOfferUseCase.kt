package dika.vasscom.core.domain.useCase

import dika.vasscom.core.domain.model.HealthServiceOffer
import dika.vasscom.core.domain.repository.HospitalRepository

class GetHealthServiceOfferUseCase(
    private val hospitalRepository: HospitalRepository
) {
    suspend fun execute(): List<HealthServiceOffer> =
        hospitalRepository.getHealthServiceOffer()
}