package com.whitedevils24.minimalnotes.presentation.onboarding.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun PageIndicator(
    modifier: Modifier = Modifier,
    pageSize: Int,
    selectedPage: Int,
    selectedColor: Color = Color.Black,
    unselectedColor: Color = Color(0xFFADB5BD)
) {
    Row (
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        repeat(pageSize) { page ->
            Box(
                modifier = Modifier
                    .size(12.dp)
                    .clip(CircleShape)
                    .background(color = if (page == selectedPage) selectedColor else unselectedColor)
            )
        }
    }
}