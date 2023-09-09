package com.example.youtube.core.data.model

import com.example.youtube.BuildConfig
import com.example.youtube.core.base.BaseDataSource
import com.example.youtube.core.data.remote.RetrofitService
import com.example.youtube.utils.Constants
import retrofit2.Call

class RemoteDataSource : BaseDataSource() {

    private val apiService = RetrofitService.getApiService()

    suspend fun getPlaylists() = getResult {
        apiService.getPlaylists(
            part = Constants.PART,
            channelId = Constants.CHANNEL_ID,
            key = BuildConfig.API_KEY,
            maxResults = 10
        )
    }
}