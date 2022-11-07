package uz.nurlibaydev.ecommerce.presentation.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.nurlibaydev.ecommerce.R
import uz.nurlibaydev.ecommerce.databinding.ContainerMainBinding

/**
 *  Created by Nurlibay Koshkinbaev on 07/11/2022 15:19
 */

class MainContainer : Fragment(R.layout.container_main) {

    private lateinit var navController: NavController
    private val binding: ContainerMainBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(requireActivity(), R.id.container_main)
        binding.bottomNavView.setupWithNavController(navController)
    }
}