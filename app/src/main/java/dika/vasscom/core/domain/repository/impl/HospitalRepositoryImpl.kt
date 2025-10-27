package dika.vasscom.core.domain.repository.impl

import dika.vasscom.R
import dika.vasscom.core.domain.model.HealthInfo
import dika.vasscom.core.domain.model.HealthServiceOffer
import dika.vasscom.core.domain.model.HealthServiceOfferType
import dika.vasscom.core.domain.repository.HospitalRepository

class HospitalRepositoryImpl: HospitalRepository {
    override suspend fun getHealthInformations(): List<HealthInfo> {
        Thread.sleep(1000)
        return listOf(
            HealthInfo(
                title = "Solusi 1, Kesehatan anda",
                desc = "Update informasi seputar kesehatan semua bisa disini !",
                iconResId = R.drawable.ic_schedule
            ),
            HealthInfo(
                title = "Solusi 2, Kesehatan anda dan keluarga",
                desc = "Update informasi seputar kesehatan semua bisa disini !",
                iconResId = R.drawable.ic_special_service
            ),
            HealthInfo(
                title = "Solusi 3, Kesehatan anda dan orang tersayang",
                desc = "Update informasi seputar kesehatan semua bisa disini !",
                iconResId = R.drawable.ic_schedule
            )
        )
    }

    override suspend fun getHealthServiceOffer(): List<HealthServiceOffer> {
        Thread.sleep(1000)
        return listOf(
            HealthServiceOffer(
                title = "Layanan Khusus",
                desc = "Tes Covid 19, Cegah Corona Sedini Mungkin",
                type = HealthServiceOfferType.SPECIAL_SERVICE
            ),
            HealthServiceOffer(
                title = "Layanan Hemat",
                desc = "Tes Covid 19, Cegah Corona Sedini Mungkin dan nikmati murahnya",
                type = HealthServiceOfferType.SPECIAL_SERVICE
            ),
            HealthServiceOffer(
                title = "Track Pemeriksaan",
                desc = "Kamu dapat mengecek progress pemeriksaanmu disini",
                type = HealthServiceOfferType.TRACKING_CHECK_UP
            )
        )
    }

}