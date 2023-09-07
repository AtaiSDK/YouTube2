package com.example.youtube.ui

import android.content.Intent
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.youtube.R
import com.example.youtube.core.base.BaseActivity
import com.example.youtube.databinding.ActivityCheckInternetBinding
import com.example.youtube.databinding.ActivityMainBinding
import com.example.youtube.ui.main.PlaylistsActivity
import com.example.youtube.ui.main.PlaylistsViewModel
import com.example.youtube.ui.second.CheckInternetViewModel

class CheckInternetActivity : BaseActivity<ActivityCheckInternetBinding, CheckInternetViewModel>() {

    override var viewModel: CheckInternetViewModel
        get() = TODO("Not yet implemented")
        set(value) {}

    override fun inflateViewBinding(): ActivityCheckInternetBinding =
        ActivityCheckInternetBinding.inflate(layoutInflater)

    override fun initViewModel(): CheckInternetViewModel {
        return ViewModelProvider(this).get(CheckInternetViewModel::class.java)
    }

    override fun checkInternetConnection() {
        super.checkInternetConnection()
        binding.icludedLayout.checkInternetBtn.setOnClickListener {
            if (isInternetAvailable()) {
                startActivity(Intent(this, PlaylistsActivity::class.java))
            }
        }

    }

    private fun isInternetAvailable(): Boolean {
        val connectivityManager = getSystemService(ConnectivityManager::class.java)
        val networkInfo = connectivityManager?.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }
}
