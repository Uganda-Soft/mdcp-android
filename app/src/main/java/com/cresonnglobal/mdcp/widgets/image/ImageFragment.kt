package com.cresonnglobal.mdcp.widgets.image

import android.Manifest
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.camera.core.ImageCapture
import androidx.core.app.ActivityCompat
import com.cresonnglobal.mdcp.R
import com.cresonnglobal.mdcp.data.question.Question
import kotlinx.android.synthetic.main.image_fragment.*
import java.io.File
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class ImageFragment(val question: Question) : Fragment() {
    companion object {
        private const val TAG = "ImageFragment"
        private const val FILENAME_FORMAT = "yyyy-MM-dd-HH-mm-ss-SS"
        private const val REQUEST_CODE_PERMISSIONS = 34
        private val REQUIRED_PERMISSIONS = arrayOf(Manifest.permission.CAMERA)
    }

//    Camera variables
    private var imageCapture: ImageCapture? = null
    private var outputDirectory: File? = null
    private lateinit var cameraExecutor: ExecutorService

    private lateinit var viewModel: ImageViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.image_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ImageViewModel::class.java)

        if (allPermissionsGranted()) {
            startCamera()
        } else {
            activity?.let {
                ActivityCompat.requestPermissions(
                    it,
                    REQUIRED_PERMISSIONS,
                    REQUEST_CODE_PERMISSIONS
                )
            }
        }

        camera_capture_button.setOnClickListener {
            takePhoto()
        }
        outputDirectory = getOutputDirectory()
        cameraExecutor = Executors.newSingleThreadExecutor()
    }

    private fun getOutputDirectory(): File? {
        val mediaDir = activity?.let {
            it.externalCacheDirs.firstOrNull()?.let { file ->
                File(file, resources.getString(R.string.app_name)).apply {
                    mkdirs()
                }
            }
        }

        return if (mediaDir != null && mediaDir.exists()) mediaDir else activity?.filesDir
    }

    private fun takePhoto() {

    }

    private fun startCamera() {

    }

    private fun allPermissionsGranted(): Boolean {

    }

    override fun onDestroy() {
        super.onDestroy()
        cameraExecutor.shutdown()
    }
}