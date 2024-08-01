package campus.tech.kakao.map.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import campus.tech.kakao.map.R
import campus.tech.kakao.map.databinding.ActivitySplashBinding
import campus.tech.kakao.map.viewModel.SplashViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    private val splashViewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setBinding()
        splashViewModel.fetchServiceState()
        setScreen()

    }

    private fun setBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
    }

    private fun setScreen() {
        splashViewModel.navigateToHome.observe(this, Observer { navigateToHome ->
            if (navigateToHome) {
                navigateToHomeMapActivity()
            } else {

            }
        })
    }

    private fun navigateToHomeMapActivity() {
        val intent = Intent(this, HomeMapActivity::class.java)
        startActivity(intent)
    }
}