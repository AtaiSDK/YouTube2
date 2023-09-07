package com.example.youtube.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.youtube.BuildConfig
import com.example.youtube.core.base.BaseViewModel
import com.example.youtube.core.data.model.PlaylistsModel
import com.example.youtube.core.data.remote.RetrofitService
import com.example.youtube.core.data.repository.Repository
import com.example.youtube.utils.Constants

class PlaylistsViewModel: BaseViewModel() {

    private val repository = Repository()

    fun getPlayList(maxResult: Int) : LiveData<PlaylistsModel>{
        return repository.getPlaylist()
    }
}