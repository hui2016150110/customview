package com.example.customview.activity

import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.customview.R
import com.example.customview.dp
import com.example.customview.view.CircleView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun gotoAvatar(view: View) {
        val intent = Intent(this, AvatarViewActivity::class.java)
        startActivity(intent)
    }

    fun gotoCamera(view: View) {
        val intent = Intent(this, CameraViewActivity::class.java)
        startActivity(intent)
    }

    fun gotoSport(view: View) {
        val intent = Intent(this, SportViewActivity::class.java)
        startActivity(intent)
    }

    fun gotoDashboard(view: View) {
        val intent = Intent(this, DashboardViewActivity::class.java)
        startActivity(intent)
    }

    fun gotoMultiline(view: View) {
        val intent = Intent(this, MultilineTextViewActivity::class.java)
        startActivity(intent)
    }

    fun gotoCircle(view: View) {
        val intent = Intent(this, CircleViewActivity::class.java)
        startActivity(intent)
    }

    fun gotoAnimatorSet(view: View) {
        val intent = Intent(this, AnimatorSetActivity::class.java)
        startActivity(intent)
    }

    fun gotoPointAnimator(view:View) {
        val intent = Intent(this, PointViewActivity::class.java)
        startActivity(intent)
    }

    fun gotoStringAnimator(view:View) {
        val intent = Intent(this, ProvinceActivity::class.java)
        startActivity(intent)
    }

}