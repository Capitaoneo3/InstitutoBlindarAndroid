package com.br.app5m.institutoblindarandroid.ui.fragment.others.sendingaudio

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.br.app5m.institutoblindarandroid.R
import android.media.MediaRecorder
import android.os.Build

import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.sending_audio_fragment.*
import android.util.Log
import android.view.ViewTreeObserver
import android.view.ViewTreeObserver.OnGlobalLayoutListener
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.navigation.fragment.findNavController
import com.tyorikan.voicerecordingvisualizer.RecordingSampler
import android.os.CountDownTimer








class SendingAudioFragment : Fragment(),

    RecordingSampler.CalculateVolumeListener {
    var myAudioRecorder: MediaRecorder? = null
    var recordingSampler: RecordingSampler? = null
    var cTimer: CountDownTimer? = null

    companion object {
        fun newInstance() = SendingAudioFragment()
    }

    private lateinit var viewModel: SendingAudioViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.sending_audio_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SendingAudioViewModel::class.java)
        // TODO: Use the ViewModel
    }

    @SuppressLint("WrongConstant")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



  /*      myAudioRecorder?.prepare();
        myAudioRecorder?.start();
        var outputFile = Environment.getExternalStorageDirectory().absolutePath + "/recording.3gp"

        myAudioRecorder = MediaRecorder()
        myAudioRecorder!!.setAudioSource(MediaRecorder.AudioSource.MIC)
        myAudioRecorder!!.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP)
        myAudioRecorder!!.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB)
       //save file
        myAudioRecorder!!.setOutputFile(outputFile)*/
//vizualizer
     var   mVisualizerView2 = visualizer
        val observer: ViewTreeObserver = mVisualizerView2.getViewTreeObserver()
        observer.addOnGlobalLayoutListener(object : OnGlobalLayoutListener {
            override fun onGlobalLayout() {
//                mVisualizerView2.setBaseY(mVisualizerView2.getHeight() / 5)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    mVisualizerView2.getViewTreeObserver().removeOnGlobalLayoutListener(this)
                } else {
                    mVisualizerView2.getViewTreeObserver().removeGlobalOnLayoutListener(this)
                }
            }
        })

        if (ContextCompat.checkSelfPermission(requireContext(),
                Manifest.permission.RECORD_AUDIO)
            == PackageManager.PERMISSION_GRANTED) {
      /*      ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.RECORD_AUDIO),
                1234);*/

        }
        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(requireContext(),
                Manifest.permission.RECORD_AUDIO)
            != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(requireActivity(),
                arrayOf(Manifest.permission.RECORD_AUDIO),
                1234);
            findNavController().navigateUp()
            // Permission is not granted
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(),
                    Manifest.permission.RECORD_AUDIO)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
            } else {
                // No explanation needed; request the permission
                      ActivityCompat.requestPermissions(requireActivity(),
                   arrayOf(Manifest.permission.RECORD_AUDIO),
                   1234);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        } else {
            // Permission has already been granted
            recordingSampler = RecordingSampler()
            recordingSampler?.setVolumeListener(this);  // for custom implements
            recordingSampler?.setSamplingInterval(100); // voice sampling interval
            recordingSampler?.link(mVisualizerView2)     // link to visualizer
            recordingSampler?.startRecording()
            startTimer()
            sendBt.setOnClickListener { findNavController().navigateUp() }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            1234 -> {

                // If request is cancelled, the result arrays are empty.
                if (grantResults.size > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED
                ) {

                } else {
                    Log.d("tchurusbango", "permission denied by user")
//                    Toast.makeText(requireContext(), "asdasd", Toast.LENGTH_SHORT).show()

                }
                return
            }
        }
    }
    override fun onCalculateVolume(volume: Int) {
    }

    fun startTimer() {
        cTimer = object : CountDownTimer(60000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                if (isAdded){

                    countDownText.setText("Tempo Restante: " + millisUntilFinished / 1000 +" s");
                }


            }
            override fun onFinish() {
                if (isAdded){

                    recordingSampler?.stopRecording()
                }

            }
        }
        (cTimer as CountDownTimer).start()
    }
    override fun onPause() {
        recordingSampler?.stopRecording()
        super.onPause()
    }
     override fun onDestroy() {
         recordingSampler?.release()
        super.onDestroy()
    }
}