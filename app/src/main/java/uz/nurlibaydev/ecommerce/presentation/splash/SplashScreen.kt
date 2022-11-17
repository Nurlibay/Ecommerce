package uz.nurlibaydev.ecommerce.presentation.splash

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import uz.nurlibaydev.ecommerce.R

/**
 *  Created by Nurlibay Koshkinbaev on 07/11/2022 15:04
 */

@AndroidEntryPoint
@SuppressLint("CustomSplashScreen")
class SplashScreen : Fragment(R.layout.screen_splash) {

    private val navController: NavController by lazy(LazyThreadSafetyMode.NONE) { findNavController() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launchWhenResumed {
            delay(1500)
            navController.navigate(SplashScreenDirections.actionSplashScreenToMainContainer())
        }
    }
}