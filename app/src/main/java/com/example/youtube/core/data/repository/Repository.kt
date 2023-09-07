package com.example.youtube.core.data.repository
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.youtube.BuildConfig
import com.example.youtube.core.data.model.PlaylistsModel
import com.example.youtube.core.data.remote.RetrofitService
import com.example.youtube.utils.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
class Repository {

    val retrofitService = RetrofitService

    fun getPlaylist(): MutableLiveData<PlaylistsModel> {
        val data = MutableLiveData<PlaylistsModel>()

        retrofitService.getApiService().getPlaylists(
            part = Constants.PART,
            channelId = Constants.CHANNEL_ID,
            key = BuildConfig.API_KEY,
            maxResults = 10
        ).enqueue(object : Callback<PlaylistsModel> {
            override fun onResponse(
                call: Call<PlaylistsModel>,
                response: Response<PlaylistsModel>
            ) {
                if(response.isSuccessful){
                    data.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<PlaylistsModel>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
        Log.d("Atai", "getPlaylist: ${data.value}")
        return data
    }
}