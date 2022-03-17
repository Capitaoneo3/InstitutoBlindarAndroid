package com.br.app5m.institutoblindarandroid.ui.activity

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cn.jzvd.Jzvd
import com.br.app5m.institutoblindarandroid.R
import kotlinx.android.synthetic.main.activity_video_full_screen.*

class VideoFullScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_full_screen)

        val jzvdStd  = jz_video
        jzvdStd.setUp(
            "https://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4",
            "Título"
        )
        jzvdStd.posterImageView.setImageURI(Uri.parse("http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640"))
        jzvdStd.backButton.setOnClickListener {
            super.onBackPressed()

        }
        jzvdStd.fullscreenButton.setOnClickListener {
            super.onBackPressed()

        }
        jzvdStd.startVideo()
              jzvdStd.setScreenFullscreen()
              jzvdStd.gotoFullscreen()

    }
    override fun onBackPressed() {
        if (Jzvd.backPress()) {
            super.onBackPressed()
            return
        }
        super.onBackPressed()
    }

    override fun onPause() {
        super.onPause()
        Jzvd.releaseAllVideos()
    }
}