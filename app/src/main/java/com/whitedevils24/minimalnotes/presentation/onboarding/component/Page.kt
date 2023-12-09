package com.whitedevils24.minimalnotes.presentation.onboarding.component

import androidx.annotation.DrawableRes
import com.whitedevils24.minimalnotes.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)

val pages = listOf<Page>(
    Page(
        "Clean and Intuitive Design",
        "Embrace the beauty of simplicity with our minimalistic user interface. Say goodbye to clutter and distractions, and hello to a sleek and intuitive design that puts your notes front and center.",
        R.drawable.onboarding_image1
    ),
    Page(
        "Organize with Ease",
        "Keep your notes organized effortlessly. Our app allows you to create categories and tags, making it a breeze to find the right note when you need it. No more searching through endless pages of content.",
        R.drawable.onboarding_image2
    ),
    Page(
        "Sync Across Devices",
        "Stay connected wherever you go. MinimalNote seamlessly syncs your notes across all your devices, ensuring that your ideas are accessible whenever and wherever inspiration strikes.",
        R.drawable.onboarding_image3
    )
)