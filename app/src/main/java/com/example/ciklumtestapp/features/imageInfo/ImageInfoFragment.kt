package com.example.ciklumtestapp.features.imageInfo

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.ciklumtestapp.App
import com.example.ciklumtestapp.R
import com.example.ciklumtestapp.common.Const
import com.example.ciklumtestapp.common.Const.ORIGINAL_IMAGE_URL
import com.example.ciklumtestapp.databinding.FragmentImageInfoBinding
import com.example.ciklumtestapp.databinding.FragmentImageListBinding
import com.example.ciklumtestapp.navigation.MainNavigation
import com.example.ciklumtestapp.navigation.MainNavigator

class ImageInfoFragment : Fragment() {

    private lateinit var binding: FragmentImageInfoBinding
    lateinit var navigation : MainNavigator


    override fun onAttach(context: Context) {
        App.appComponent.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentImageInfoBinding.inflate(inflater , container , false)
        navigation = MainNavigation(findNavController())
        initButtons()

        val originalImageUrl = requireArguments().getString(ORIGINAL_IMAGE_URL)
        Glide.with(this)
            .load(originalImageUrl)
            .error(R.mipmap.ic_launcher)
            .into(binding.ivOriginalImage)

        return binding.root
    }

    fun initButtons(){
        binding.btnBack.setOnClickListener{
            navigation.navigateBack()
        }
    }





}