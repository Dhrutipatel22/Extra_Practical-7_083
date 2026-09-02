package com.example.extra_practical_7_083

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder

class MusicService : Service() {
    companion object{
        val SERVICE_KEY="Service1"
        val SERVICE_DATA ="PlayPause"
    }

    lateinit var mediaPlayer: MediaPlayer

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (!this::mediaPlayer.isInitialized)
            mediaPlayer = MediaPlayer.create(this, R.raw.song)
        if(intent!=null){
            val str1: String?=intent.getStringExtra(SERVICE_KEY)
            if (str1==SERVICE_DATA){
                if (!mediaPlayer.isPlaying)
                    mediaPlayer.start()
                else
                    mediaPlayer.pause()
            }
        }
        return START_STICKY
    }

    override fun onDestroy() {
        mediaPlayer.stop()
        super.onDestroy()
    }
}