package com.whitedevils24.minimalnotes.presentation.onboarding.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.whitedevils24.minimalnotes.R
import com.whitedevils24.minimalnotes.ui.theme.MinimalNotesTheme

@Composable
fun OnBoardingPage(
    modifier: Modifier = Modifier,
    page: Page
) {
    Column(
        modifier = modifier
            .padding(
                start = 16.dp,
                end = 16.dp,
                top = 48.dp,
                bottom = 16.dp
            )
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier= Modifier
                .width(328.dp)
                .height(328.dp)
                .align(Alignment.CenterHorizontally),
            painter = painterResource(id = page.image),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = AnnotatedString(page.title),
            modifier = Modifier
                .wrapContentSize(Alignment.Center),
            style = androidx.compose.ui.text.TextStyle(
                fontSize = 20.sp,
                lineHeight = 20.sp,
                fontFamily = FontFamily(Font(R.font.merriweather_bold)),
                fontWeight = FontWeight(700),
                color = Color.Black,
                textAlign = TextAlign.Center,
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = AnnotatedString(page.description),
            modifier = modifier,
            style = androidx.compose.ui.text.TextStyle(
                fontSize = 14.sp,
                lineHeight = 20.sp,
                fontFamily = FontFamily(Font(R.font.inter_regular)),
                fontWeight = FontWeight(400),
                color = Color.Black,
                textAlign = TextAlign.Center,

            )
        )

    }

}

@Preview(showBackground = true)
@Composable
fun OnBoardingPagePreview(){
    MinimalNotesTheme {
        OnBoardingPage(
            page= pages[0])
    }
}