package com.example.ciklumtestapp.navigation

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController

import com.example.ciklumtestapp.MainActivity
import com.example.ciklumtestapp.R
import com.example.ciklumtestapp.common.Const.ORIGINAL_IMAGE_URL
import javax.inject.Inject

class MainNavigation constructor(val navController: NavController) : MainNavigator {

    override fun navigateToImageInfo(originalImageUrl : String) {
        var bundle = Bundle();
        bundle.putString(ORIGINAL_IMAGE_URL , originalImageUrl);
        navController.navigate(R.id.action_imageListFragment_to_imageInfoFragment , bundle);
    }

    override fun navigateBack() {
        navController.popBackStack()

    }





}