package com.company0ne.broadcastreceiver_kotlin


import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    //register the receiver in the main activity in order
    //to receive updates of broadcasts events if occur
    lateinit var receiver: AirplaneModeChangeReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        receiver = AirplaneModeChangeReceiver()

        // Intent Filter is useful to determine which apps wants to receive
        // which intents,since here we want to respond to change of
        // airplane mode
        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            registerReceiver(receiver, it)

        }
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(receiver)
    }
}