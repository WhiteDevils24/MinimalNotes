package com.whitedevils24.minimalnotes

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.lifecycleScope
import com.whitedevils24.minimalnotes.domain.usecases.AppEntryUseCases
import com.whitedevils24.minimalnotes.presentation.onboarding.OnBoardingScreen
import com.whitedevils24.minimalnotes.presentation.onboarding.OnboardingViewModel
import com.whitedevils24.minimalnotes.ui.theme.MinimalNotesTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var useCases: AppEntryUseCases

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()

        lifecycleScope.launch {
            useCases.readAppEntry().collect(){
                Log.d("test",it.toString())
            }
        }

        setContent {
            MinimalNotesTheme {
                val viewModel: OnboardingViewModel = hiltViewModel()
                OnBoardingScreen(
                    event = viewModel::onEvent
                )

            }
        }
    }
}
