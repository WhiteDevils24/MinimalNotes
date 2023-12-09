package com.whitedevils24.minimalnotes.presentation.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.whitedevils24.minimalnotes.presentation.common.MediumButton
import com.whitedevils24.minimalnotes.presentation.onboarding.component.OnBoardingPage
import com.whitedevils24.minimalnotes.presentation.onboarding.component.PageIndicator
import com.whitedevils24.minimalnotes.presentation.onboarding.component.pages
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(
    event: (OnBoardingEvent) -> Unit
) {

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        val pagerState = rememberPagerState(initialPage = 0) {
            pages.size
        }

        val buttonState = remember {
            derivedStateOf {
                when (pagerState.currentPage) {
                    0 -> listOf("Next")
                    1 -> listOf("Next")
                    2 -> listOf("Continue")
                    else -> listOf("")
                }
            }
        }

        HorizontalPager(state = pagerState) { index ->
            OnBoardingPage(
                page = pages[index]
            )
        }

        Spacer(modifier = Modifier.height(90.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .navigationBarsPadding(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            PageIndicator(
                modifier = Modifier.width(56.dp),
                pageSize = pages.size,
                selectedPage = pagerState.currentPage
            )
        }
        
        Spacer(modifier = Modifier.height(36.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .navigationBarsPadding(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            val scope = rememberCoroutineScope()

            MediumButton(
                text = buttonState.value[0],
                onClick = {
                    scope.launch {
                        if (pagerState.currentPage == 2) {
                            // If it's the last page, navigate to the login page
                            event(OnBoardingEvent.SaveAppEntry)
                        } else {
                            pagerState.animateScrollToPage(
                                page = pagerState.currentPage + 1
                            )
                        }
                    }
                }
            )

        }
    }




}


