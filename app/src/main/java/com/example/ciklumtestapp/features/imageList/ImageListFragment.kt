package com.example.ciklumtestapp.features.imageList

import android.content.Context
import android.os.Bundle
import android.text.Spannable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.ciklumtestapp.App
import com.example.ciklumtestapp.databinding.FragmentImageListBinding
import javax.inject.Inject

class ImageListFragment : Fragment() {

    @Inject
    lateinit var factory : ImageListViewModel.Factory

    private lateinit var binding: FragmentImageListBinding

    lateinit var model : ImageListViewModel


    override fun onAttach(context: Context) {
        App.appComponent.inject(this)
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        model = ViewModelProvider(this, factory)[ImageListViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentImageListBinding.inflate(inflater , container , false)

        return binding.root
    }

}