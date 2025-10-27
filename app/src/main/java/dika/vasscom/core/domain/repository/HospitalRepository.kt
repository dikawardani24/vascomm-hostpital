package dika.vasscom.core.domain.repository

import dika.vasscom.core.domain.model.HealthInfo
import dika.vasscom.core.domain.model.HealthServiceOffer

interface HospitalRepository {
    suspend fun getHealthInformations(): List<HealthInfo>

    suspend fun getHealthServiceOffer(): List<HealthServiceOffer>
}