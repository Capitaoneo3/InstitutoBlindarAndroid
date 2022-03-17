package com.br.app5m.institutoblindarandroid.ui.dialog

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.br.app5m.institutoblindarandroid.R
import android.widget.VideoView
import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import androidx.test.core.app.ApplicationProvider
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import com.tyorikan.voicerecordingvisualizer.RecordingSampler
import kotlinx.android.synthetic.main.dialog_video_detail.*
import android.view.WindowManager

import android.widget.FrameLayout

import com.br.app5m.institutoblindarandroid.MainActivity

import android.media.MediaPlayer

import android.media.MediaPlayer.OnVideoSizeChangedListener

import android.media.MediaPlayer.OnPreparedListener
import android.os.AsyncTask
import androidx.compose.ui.text.substring
import androidx.fragment.app.Fragment
import org.w3c.dom.Document
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL
import javax.xml.parsers.DocumentBuilder
import javax.xml.parsers.DocumentBuilderFactory
import cn.jzvd.Jzvd
import com.br.app5m.institutoblindarandroid.ui.activity.VideoFullScreenActivity


class VideoDetailDialog(context2: Context) : DialogFragment() {
    private lateinit var builder: AlertDialog.Builder
    private lateinit var alertDialog: AlertDialog
    private var context2= context2
    var mVideoView: VideoView? = null
    var mediaController: MediaController? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NORMAL, R.style.DialogNoBackground)

    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_video_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        builder = AlertDialog.Builder(requireContext())
        alertDialog = builder.create()

        clicks()
      /*  val fullscreenVideoView =fullscreenVideoView
        val videoUrl = "https://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4"
        fullscreenVideoView.videoUrl(videoUrl)
            .enableAutoStart()*/

        val jzvdStd  = jz_video
        jzvdStd.setUp(
            "https://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4",
            "Título"
        )
        jzvdStd.posterImageView.setImageURI(Uri.parse("http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640"))
        /*jzvdStd.backButton.setOnClickListener {
//            Jzvd.releaseAllVideos()

        }*/
        jzvdStd.fullscreenButton.setOnClickListener {
            val intent = Intent (requireContext(), VideoFullScreenActivity::class.java)
            requireContext().startActivity(intent)
        }
        jzvdStd.startVideo()
  /*      jzvdStd.setScreenFullscreen()
        jzvdStd.gotoFullscreen()*/
    }


    private fun clicks() {
      /*  floatingActionDelete.setOnClickListener {
            this.dismiss()
        }*/
    }

    override fun onDestroy() {
        super.onDestroy()
        Jzvd.releaseAllVideos()
    }


}

