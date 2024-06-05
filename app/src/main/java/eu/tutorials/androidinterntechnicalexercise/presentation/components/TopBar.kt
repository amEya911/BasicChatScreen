package eu.tutorials.androidinterntechnicalexercise.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import eu.tutorials.androidinterntechnicalexercise.R
import eu.tutorials.androidinterntechnicalexercise.ui.spacing

@Composable
fun TopBar(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.medium)
    ) {
        Image(
            modifier = Modifier.clip(RoundedCornerShape(50)).size(MaterialTheme.spacing.extraLarge),
            painter = painterResource(id = R.drawable.blank_profile),
            contentDescription = null
        )
        Text(
            text = "Group Chat",
            color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.8f),
            fontSize = 20.sp,
            fontWeight = FontWeight.Normal
        )
    }
}