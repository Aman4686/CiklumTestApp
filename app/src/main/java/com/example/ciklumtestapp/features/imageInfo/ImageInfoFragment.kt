package com.example.ciklumtestapp.features.imageInfo

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ciklumtestapp.App
import com.example.ciklumtestapp.databinding.FragmentImageInfoBinding
import com.example.ciklumtestapp.databinding.FragmentImageListBinding

class ImageInfoFragment : Fragment() {

    private lateinit var binding: FragmentImageInfoBinding

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

        return binding.root
    }

}