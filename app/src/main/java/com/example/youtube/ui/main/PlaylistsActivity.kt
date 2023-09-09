package com.example.youtube.ui.main

import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.youtube.core.base.BaseActivity
import com.example.youtube.core.base.PlaylistAdapter
import com.example.youtube.core.data.model.Resource
import com.example.youtube.databinding.ActivityMainBinding

class PlaylistsActivity : BaseActivity<ActivityMainBinding, PlaylistsViewModel>() {

    override fun inflateViewBinding() = ActivityMainBinding.inflate(layoutInflater)

    override lateinit var viewModel: PlaylistsViewModel

    private var adapter = PlaylistAdapter()

    override fun initLiveData() {
        super.initLiveData()
        viewModel.getPlayList().observe(this) {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    it.data?.items
                    adapter.setListModel(it)
                }
                Resource.Status.ERROR -> {
                    Toast.makeText(this, "error Status", Toast.LENGTH_SHORT)
                }
                Resource.Status.LOADING -> {

                }

            }
        }
    }

    override fun initView() {
        super.initView()
        viewModel = ViewModelProvider(this)[PlaylistsViewModel::class.java]
        binding.recyclerView.adapter = adapter
        viewModel.getPlayList()
    }

    override fun checkInternetConnection() {
        super.checkInternetConnection()

    }

    override fun initViewModel(): PlaylistsViewModel {
        return ViewModelProvider(this).get(PlaylistsViewModel::class.java)
    }
}