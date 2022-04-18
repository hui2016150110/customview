package com.example.customview.activity

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.customview.R
import com.example.customview.view.CameraView

class AnimatorSetActivity : AppCompatActivity() {
    lateinit var cameraView: CameraView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animator_set)
        cameraView = findViewById(R.id.camera_view)

        val bottomFlipAnimator = ObjectAnimator.ofFloat(cameraView,"bottomFlip",60f)
        bottomFlipAnimator.startDelay = 1000
        bottomFlipAnimator.duration = 1000

        val rotationAnimator = ObjectAnimator.ofFloat(cameraView,"flipRotation",270f)
        rotationAnimator.startDelay = 200
        rotationAnimator.duration = 1000

        val topFlipAnimator = ObjectAnimator.ofFloat(cameraView,"topFlip",-60f)
        topFlipAnimator.startDelay = 200
        topFlipAnimator.duration = 1000

        val animatorSet = AnimatorSet()
        animatorSet.playSequentially(bottomFlipAnimator,rotationAnimator,topFlipAnimator)
        animatorSet.start()


    }
}