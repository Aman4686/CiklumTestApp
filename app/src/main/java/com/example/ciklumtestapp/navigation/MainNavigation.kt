package com.example.ciklumtestapp.navigation

import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController

import com.example.ciklumtestapp.MainActivity
import com.example.ciklumtestapp.R
import javax.inject.Inject

class MainNavigation constructor(val navController: NavController) : MainNavigator {

    override fun navigateToImageInfo() {
//        navController.navigate(R.id.action_creatorFragment_to_listFragment)
    }

    override fun navigateBack() {
        navController.popBackStack()

    }
}