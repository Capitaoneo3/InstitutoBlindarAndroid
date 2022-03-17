package com.br.app5m.institutoblindarandroid.ui.dialog

import android.Manifest
import android.content.Context
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
import kotlinx.android.synthetic.main.dialog_video_detail2.*
import android.view.WindowManager

import android.widget.FrameLayout

import com.br.app5m.institutoblindarandroid.MainActivity

import android.media.MediaPlayer

import android.media.MediaPlayer.OnVideoSizeChangedListener

import android.media.MediaPlayer.OnPreparedListener
import android.os.AsyncTask
import androidx.compose.ui.text.substring
import org.w3c.dom.Document
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL
import javax.xml.parsers.DocumentBuilder
import javax.xml.parsers.DocumentBuilderFactory


class VideoDetailDialog2(context2: Context) : DialogFragment() {
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

//        val url = "android.resource://" + requireActivity().packageName + "/" + R.raw.elden
//        val url = "https://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4"
        val url = "https://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4"

        mVideoView= mVideoViewLayout
        mVideoView?.setVideoURI(Uri.parse(url))
//        mVideoView?.setVideoPath("http://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4")
 /*       mediaController= MediaController(context)
        mediaController?.setAnchorView(mVideoView)
        mVideoView?.setMediaController(mediaController)
        mVideoView?.start()*/

        mVideoView?.setOnPreparedListener(OnPreparedListener { mp -> // TODO Auto-generated method stub
            mp.setOnVideoSizeChangedListener { mp, width, height -> /*
                             * add media controller
                             */
                mediaController = MediaController(context)
                mVideoView?.setMediaController(mediaController)
                /*
                             * and set its position on screen
                             */mediaController?.setAnchorView(mVideoView)
                (mediaController?.parent as ViewGroup).removeView(mediaController)
                (videoViewWrapper as FrameLayout)
                    .addView(mediaController)
                mediaController?.setVisibility(View.VISIBLE)
            }
            mVideoView?.start()
        })

    }



    private fun clicks() {
      /*  floatingActionDelete.setOnClickListener {
            this.dismiss()
        }*/
    }

    override fun onDestroy() {
        super.onDestroy()
    }


}

