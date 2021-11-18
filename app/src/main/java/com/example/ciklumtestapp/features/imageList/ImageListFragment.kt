package com.example.ciklumtestapp.features.imageList

import android.content.Context
import android.os.Bundle
import android.text.Spannable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ciklumtestapp.App
import com.example.ciklumtestapp.databinding.FragmentImageListBinding
import com.example.ciklumtestapp.navigation.MainNavigation
import com.example.ciklumtestapp.navigation.MainNavigator
import javax.inject.Inject

class ImageListFragment : Fragment() {

    @Inject
    lateinit var factory : ImageListViewModel.Factory

    private lateinit var binding: FragmentImageListBinding

    lateinit var model : ImageListViewModel
    lateinit var adapter : ImageRecyclerAdapter

    lateinit var navigation : MainNavigator

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
        navigation = MainNavigation(findNavController())
        initSearchLogic()
        initRecycler()
        return binding.root
    }

    fun initSearchLogic(){
        binding.btnSearch.setOnClickListener{
            val tag = binding.etSearch.text.toString()
            if (tag.isNotEmpty())
                model.initImageListByTag(tag)

        }
    }

    private fun initRecycler(){
        val linearLayoutManager = LinearLayoutManager(context)
        adapter = ImageRecyclerAdapter(object : OnImageClickListener {
            override fun onClick(originalImageUrl: String) {
                navigation.navigateToImageInfo(originalImageUrl)
            }
        })
        with(binding){
            rvImageList.layoutManager = linearLayoutManager
            rvImageList.adapter = adapter
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initObservers()
    }

    private fun initObservers(){

        model.tumblrResponseLiveData.observe(viewLifecycleOwner){
            adapter.tumblrResponseList = it.response
        }
    }




}