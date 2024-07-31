package campus.tech.kakao.map.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import campus.tech.kakao.map.R
import campus.tech.kakao.map.databinding.ActivitySplashBinding
import campus.tech.kakao.map.viewModel.SplashViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    private val bootViewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setBinding()

        if (bootViewModel.databaseState.toString() != "ON_SERVICE"){
            navigateToHomeMapActivity()
        } else{
            binding.serviceMsg.text = getString(R.string.boot_error)
        }
    }

    private fun setBinding(){
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
    }

    private fun navigateToHomeMapActivity(){
        val intent = Intent(this, HomeMapActivity::class.java)
        startActivity(intent)
    }
}