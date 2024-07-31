package campus.tech.kakao.map.data.firebase

import android.util.Log
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteConfig @Inject constructor() {

    private val remoteConfig: FirebaseRemoteConfig = Firebase.remoteConfig

    private val configSettings = remoteConfigSettings {
        minimumFetchIntervalInSeconds = 0
    }

    init {
        remoteConfig.setConfigSettingsAsync(configSettings)
    }

    fun fetchAndActive(): String? {
        var state : String? = null
        remoteConfig.fetchAndActivate()
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    state = remoteConfig.getString(SERVICE_STATE_KEY)
                    Log.d("yeong", state!!)
                }
            }
        return state
    }

    companion object {
        const val SERVICE_STATE_KEY = "serviceState"
    }
}