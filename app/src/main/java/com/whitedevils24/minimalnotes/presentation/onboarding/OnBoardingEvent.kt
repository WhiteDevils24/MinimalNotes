package com.whitedevils24.minimalnotes.presentation.onboarding

sealed class OnBoardingEvent {

    data object SaveAppEntry: OnBoardingEvent()

}