package com.cresonnglobal.mdcp.photo

import android.Manifest
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.cresonnglobal.mdcp.R
import com.cresonnglobal.mdcp.widgets.image.ImageFragment
import kotlinx.android.synthetic.main.image_fragment.*
import java.io.File
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class PhotoActivity : AppCompatActivity() {
    companion object {
        public final val QUESTION = "com.cresonnglobal.mdcp.photo.PhotoActivity.QUESTION"
        private const val TAG = "ImageFragment"
        private const val FILENAME_FORMAT = "yyyy-MM-dd-HH-mm-ss-SS"
        private const val REQUEST_CODE_PERMISSIONS = 34
        private val REQUIRED_PERMISSIONS = arrayOf(Manifest.permission.CAMERA)
    }

    //    Camera variables
    private var imageCapture: ImageCapture? = null
    private lateinit var outputDirectory: File
    private lateinit var cameraExecutor: ExecutorService


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo)

        if (allPermissionsGranted()) {
            startCamera()
        } else {
            this.let {
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

    private fun getOutputDirectory(): File {
        val mediaDir = externalMediaDirs.firstOrNull()?.let {
            File(it, resources.getString(R.string.app_name)).apply {
                mkdirs()
            }
        }
        return if (mediaDir != null && mediaDir.exists()) mediaDir else filesDir
    }

    private fun takePhoto() {
        val imageCapture = imageCapture ?: return

        val photoFile = File (
            outputDirectory,
            SimpleDateFormat(FILENAME_FORMAT, Locale.US).format(System.currentTimeMillis()) + ".jpg"
        )

        val outputOptions = ImageCapture.OutputFileOptions.Builder(photoFile).build()

        imageCapture.takePicture(
            outputOptions, ContextCompat.getMainExecutor(this), object : ImageCapture.OnImageSavedCallback {
                override fun onImageSaved(outputFileResults: ImageCapture.OutputFileResults) {
                    val savedUri = Uri.fromFile(photoFile)
                    val msg = "Photo capture succeeded: $savedUri"
                    Toast.makeText(this@PhotoActivity, msg, Toast.LENGTH_LONG).show()
                }

                override fun onError(exception: ImageCaptureException) {
                    Log.e(TAG, "Photo Captured Failed")
                }

            }
        )
    }

    private fun startCamera() {
        val cameraProviderFuture = ProcessCameraProvider.getInstance(this)
        cameraProviderFuture.addListener(Runnable {
            val cameraProvider: ProcessCameraProvider = cameraProviderFuture.get()

            val preview = Preview.Builder()
                .build()
                .also {
                    it.setSurfaceProvider(viewfinder.createSurfaceProvider())
                }

            imageCapture = ImageCapture.Builder().build()

            val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA

            try {
                cameraProvider.bindToLifecycle(this, cameraSelector, preview)
            } catch (exception: Exception) {
                Log.e(PhotoActivity.TAG, "Use case binding failed", exception)
            }
        }, ContextCompat.getMainExecutor(this))

//        imageCapture = ImageCapture.Builder().build()
    }

    private fun  allPermissionsGranted() = PhotoActivity.REQUIRED_PERMISSIONS.all {
        ContextCompat.checkSelfPermission(this, it) == PackageManager.PERMISSION_GRANTED
    }

    override fun onDestroy() {
        super.onDestroy()
        cameraExecutor.shutdown()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if (requestCode == PhotoActivity.REQUEST_CODE_PERMISSIONS) {
            if (allPermissionsGranted()) {
                startCamera()
            } else {
                Toast.makeText(this, "Permissions not granted by the user", Toast.LENGTH_SHORT).show()
            }
        }
    }
}