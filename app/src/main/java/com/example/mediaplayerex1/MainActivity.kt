package com.example.mediaplayerex1

import android.graphics.Color
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var player: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt_play.setOnClickListener {
            if (player == null) player = MediaPlayer.create(this, R.raw.backtoyou)

            if (!player!!.isPlaying) {
                bt_play.setImageResource(R.drawable.ic_pause_black_24dp)
                player!!.start()
                player!!.setOnCompletionListener {
                    player!!.release()
                    player = null
                    bt_play.setImageResource(R.drawable.ic_play_arrow_black_24dp)
                }

            } else {
                if (player != null) {
                    player!!.pause()
                    bt_play.setImageResource(R.drawable.ic_play_arrow_black_24dp)
                }

            }

        }

        bt_stop.setOnClickListener {
            if (player != null) {
                player!!.release()
                player = null
                bt_play.setImageResource(R.drawable.ic_play_arrow_black_24dp)
            }
        }


    }
}
