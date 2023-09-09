package com.example.youtube.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.example.youtube.BuildConfig
import com.example.youtube.core.base.BaseViewModel
import com.example.youtube.core.data.model.PlaylistsModel
import com.example.youtube.core.data.model.RemoteDataSource
import com.example.youtube.core.data.model.Resource
import com.example.youtube.core.data.remote.RetrofitService
import com.example.youtube.core.data.repository.Repository
import com.example.youtube.utils.Constants
import kotlinx.coroutines.Dispatchers
import okhttp3.Dispatcher

class PlaylistsViewModel : BaseViewModel() {

    private val remoteDataSource: RemoteDataSource by lazy {
        RemoteDataSource()
    }

    private val repository = Repository()

    fun getPlayList(): LiveData<Resource<PlaylistsModel>> {
        return liveData(Dispatchers.IO) {

            emit(Resource.loading())
            emit(remoteDataSource.getPlaylists())
        }
        Dispatchers.Main
    }
}