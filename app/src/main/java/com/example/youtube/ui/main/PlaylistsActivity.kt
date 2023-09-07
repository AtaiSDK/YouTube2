package com.example.youtube.ui.main

import androidx.lifecycle.ViewModelProvider
import com.example.youtube.core.base.BaseActivity
import com.example.youtube.core.base.PlaylistAdapter
import com.example.youtube.databinding.ActivityMainBinding

class PlaylistsActivity : BaseActivity<ActivityMainBinding, PlaylistsViewModel>() {

    override fun inflateViewBinding() = ActivityMainBinding.inflate(layoutInflater)

    override lateinit var viewModel: PlaylistsViewModel

    private var adapter = PlaylistAdapter()

    override fun initLiveData() {
        super.initLiveData()
        viewModel.getPlayList(10).observe(this) {
            adapter.setListModel(it)
        }
    }

    override fun initView() {
        super.initView()
        viewModel = ViewModelProvider(this)[PlaylistsViewModel::class.java]
        binding.recyclerView.adapter = adapter
        viewModel.getPlayList(1)
    }

    override fun checkInternetConnection() {
        super.checkInternetConnection()
    }

    override fun initViewModel(): PlaylistsViewModel {
        return ViewModelProvider(this).get(PlaylistsViewModel::class.java)
    }
}