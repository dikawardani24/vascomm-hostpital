package dika.vasscom.ui.screens.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import dika.vasscom.R
import dika.vasscom.ui.components.AppTabs
import dika.vasscom.ui.components.AppTitle

@Composable
fun ListServices() {
    Column(
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        AppTitle("Pilih Tipe Layanan Kesehatan Anda", size = 20)
        Box(
            modifier = Modifier.width(300.dp)
                .height(50.dp)
                .shadow(
                    elevation = 4.dp,
                    shape = RoundedCornerShape(50),
                    clip = false
                ),
        ) {
            AppTabs(
                list = listOf("Satuan", "Paket Pemeriksaan")
            ) { }
        }
//        AppTabs(
//            list = listOf("Satuan", "Paket Pemeriksaan")
//        ) { }
        ItemService(
            title = "PCR Swab Test (Drive Thru) Hasil 1 Hari Kerja",
            price = "Rp 1.400.000",
            hospitalName = "Lenmarc Surabaya",
            location = "Dukuh Pakis, Surabaya",
            imageRes = R.drawable.img_mask_group
        )
        ItemService(
            title = "PCR Swab Test (Drive Thru) Hasil 1 Hari Kerja",
            price = "Rp 1.400.000",
            hospitalName = "Lenmarc Surabaya",
            location = "Dukuh Pakis, Surabaya",
            imageRes = R.drawable.img_mask_group_2
        )
        ItemService(
            title = "PCR Swab Test (Drive Thru) Hasil 1 Hari Kerja",
            price = "Rp 1.400.000",
            hospitalName = "Lenmarc Surabaya",
            location = "Dukuh Pakis, Surabaya",
            imageRes = R.drawable.img_mask_group
        )
        ItemService(
            title = "PCR Swab Test (Drive Thru) Hasil 1 Hari Kerja",
            price = "Rp 1.400.000",
            hospitalName = "Lenmarc Surabaya",
            location = "Dukuh Pakis, Surabaya",
            imageRes = R.drawable.img_mask_group_2
        )
        ItemService(
            title = "PCR Swab Test (Drive Thru) Hasil 1 Hari Kerja",
            price = "Rp 1.400.000",
            hospitalName = "Lenmarc Surabaya",
            location = "Dukuh Pakis, Surabaya",
            imageRes = R.drawable.img_mask_group
        )
        ItemService(
            title = "PCR Swab Test (Drive Thru) Hasil 1 Hari Kerja",
            price = "Rp 1.400.000",
            hospitalName = "Lenmarc Surabaya",
            location = "Dukuh Pakis, Surabaya",
            imageRes = R.drawable.img_mask_group_2
        )
        ItemService(
            title = "PCR Swab Test (Drive Thru) Hasil 1 Hari Kerja",
            price = "Rp 1.400.000",
            hospitalName = "Lenmarc Surabaya",
            location = "Dukuh Pakis, Surabaya",
            imageRes = R.drawable.img_mask_group
        )
        ItemService(
            title = "PCR Swab Test (Drive Thru) Hasil 1 Hari Kerja",
            price = "Rp 1.400.000",
            hospitalName = "Lenmarc Surabaya",
            location = "Dukuh Pakis, Surabaya",
            imageRes = R.drawable.img_mask_group_2
        )
    }
}
