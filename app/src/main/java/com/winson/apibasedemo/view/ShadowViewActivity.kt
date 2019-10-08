package com.winson.apibasedemo.view

import android.animation.AnimatorSet
import android.animation.ValueAnimator
import android.os.Bundle
import android.os.Handler
import android.util.TypedValue
import android.view.View
import android.view.animation.BounceInterpolator
import android.view.animation.DecelerateInterpolator
import com.winson.apibasedemo.R
import com.winson.apibasedemo.base.BaseActivity


/**
 *@date on 2019/1/21
 *@Author Winson
 */
class ShadowViewActivity:BaseActivity(){

    override fun onBind(savedInstanceState: Bundle?) {
        super.onBind(savedInstanceState)
        setContentView(R.layout.act_shadow_view)

        val handler = Handler()
        val start_bg = findViewById<View>(R.id.start_bg)
        val start_desc = findViewById<View>(R.id.start_desc)
        val start_desc2 = findViewById<View>(R.id.start_desc_2)
        val start_logo = findViewById<View>(R.id.start_logo)
        val start_shan = findViewById<View>(R.id.start_shan)
        val start_person = findViewById<View>(R.id.start_person)
        val start_hb = findViewById<View>(R.id.start_hb)
        val tranX =
            TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 300f, resources.displayMetrics)
        val tranY =
            TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 300f, resources.displayMetrics)
        val tranY2 =
            TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 200f, resources.displayMetrics)

        val logoAnimator = ValueAnimator.ofFloat(0f, 1f)
        logoAnimator.duration = 800
        logoAnimator.interpolator = BounceInterpolator()
        logoAnimator.addUpdateListener {
            val offset = it.animatedValue as Float
            start_desc.translationY = offset * tranY2
        }

        val tranAnimator = ValueAnimator.ofFloat(0f, 1f)
        tranAnimator.duration = 500
        tranAnimator.interpolator = DecelerateInterpolator()
        tranAnimator.addUpdateListener {
            val offset = it.animatedValue as Float
//            start_hb.translationX = -offset * tranX
//            start_hb.translationY = offset * tranY
        }

        val alphaAnimator = ValueAnimator.ofFloat(0f, 1f)
        alphaAnimator.duration = 1200
        alphaAnimator.interpolator = DecelerateInterpolator()
        alphaAnimator.addUpdateListener {
            val offset = it.animatedValue as Float
//            start_desc2.alpha = offset
//            start_desc.alpha = 1f - offset
//            start_bg_light.alpha = 1f - offset
            start_logo.alpha = 1f - offset
            start_shan.alpha = 1f - offset
            start_person.alpha = 1f - offset
            start_hb.alpha = 1f - offset

        }

        val animatorSet = AnimatorSet()
//        animatorSet.playTogether(tranAnimator,alphaAnimator)
        animatorSet.playSequentially(tranAnimator, alphaAnimator, logoAnimator)

        handler.postDelayed({
            animatorSet.start()
        }, 500)

    }

}