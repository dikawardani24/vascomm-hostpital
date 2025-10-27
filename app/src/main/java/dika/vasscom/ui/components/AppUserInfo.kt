package dika.vasscom.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dika.vasscom.R
import dika.vasscom.ui.theme.VascommHospitalTheme

@Composable
fun AppUserInfo(
    modifier: Modifier = Modifier,
    firstName: String,
    lastName: String,
    membership: String,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_mask_group_2),
            contentDescription = null,
            modifier = Modifier
                .size(36.dp)
                .clip(
                    CircleShape
                ),
            contentScale = ContentScale.FillBounds
        )
        Spacer(modifier = Modifier.width(12.dp))
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            TitleAnnotated(
                title = ", $lastName",
                boldText = firstName,
                isBoldFirst = true,
                fontSize = 14,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            AppTextLite(
                text = membership,
                size = 12
            )
        }
    }
}

@Composable
@Preview
fun AppUserInfoPreview() {
    VascommHospitalTheme {
        AppUserInfo(
            firstName = "Joshny",
            lastName = "Begadang kjashkjahskjasjakjh akhfjkahdfkj ksjdhfkjhsdf",
            membership = "Permanet"
        )
    }
}
