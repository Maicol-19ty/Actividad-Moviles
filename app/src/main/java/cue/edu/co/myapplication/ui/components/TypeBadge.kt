package cue.edu.co.myapplication.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import cue.edu.co.myapplication.model.ProductType

/** Product image on a soft circle tinted with the type's accent color. */
@Composable
fun TypeBadge(type: ProductType, size: Dp = 56.dp, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.size(size).background(type.accent.copy(alpha = 0.15f), CircleShape),
        contentAlignment = Alignment.Center,
    ) {
        Image(
            painter = painterResource(type.imageRes),
            contentDescription = type.label,
            modifier = Modifier.padding(size / 5).size(size * 0.6f),
        )
    }
}
