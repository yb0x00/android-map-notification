package campus.tech.kakao.map.viewModel

import androidx.lifecycle.ViewModel
import campus.tech.kakao.map.data.firebase.RemoteConfig
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    remoteConfig: RemoteConfig
) : ViewModel() {
    val databaseState = remoteConfig.fetchAndActive()
}