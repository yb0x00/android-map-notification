package campus.tech.kakao.map.data.firebase

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class FirebaseMessagingService : FirebaseMessagingService(){

    override fun onMessageReceived(message: RemoteMessage) {
        Log.d("yeong","From: ${message.from}")

        message.notification?.let {
            Log.d("yeong","Message Notification Title: ${it.title}")
            Log.d("yeong","Message Notification Body: ${it.body}")
        }
    }
}