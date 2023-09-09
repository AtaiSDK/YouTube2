package com.example.youtube.core.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.youtube.BuildConfig
import com.example.youtube.core.data.model.PlaylistsModel
import com.example.youtube.core.data.model.RemoteDataSource
import com.example.youtube.core.data.model.Resource

class Repository {

    private val remoteDataSource = RemoteDataSource()

    suspend fun getPlaylist(): LiveData<Resource<PlaylistsModel>> {
        val data = MutableLiveData<Resource<PlaylistsModel>>()
        data.postValue(remoteDataSource.getPlaylists())

        return data
    }
}