package com.example.extra_practical_7_083

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        findViewById<FloatingActionButton>(R.id.play_button).setOnClickListener {
            Intent(applicationContext, MusicService::class.java).
                    putExtra(MusicService.SERVICE_KEY, MusicService.SERVICE_DATA).
                    also { startService(it) }
        }
        findViewById<FloatingActionButton>(R.id.pause_button).setOnClickListener {
            Intent(applicationContext, MusicService::class.java).
            putExtra(MusicService.SERVICE_KEY, MusicService.SERVICE_DATA).
            also { stopService(it) }
        }

    }
}