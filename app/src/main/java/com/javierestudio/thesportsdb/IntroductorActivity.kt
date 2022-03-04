package com.javierestudio.thesportsdb

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import com.javierestudio.thesportsdb.databinding.ActivityIntroductorBinding

class IntroductorActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityIntroductorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityIntroductorBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        // TODO: Una función que haga eso para los tres a la vez (equal code)

        moveAnimationsToNextScreen(mBinding.tvTittle, mBinding.view, mBinding.lottie)
    }

    private fun moveAnimationsToNextScreen(
        tvTittle: TextView,
        view: View,
        lottie: LottieAnimationView
    ) {
        tvTittle.animate()
            .setStartDelay(2000)
            .translationX(-1500F).duration = 1000

        view.animate()
            .setStartDelay(2000)
            .translationX(-1500F).duration = 1000

        lottie.animate()
            .setStartDelay(2000)
            .translationX(-1500F).duration = 1000

        // TODO: Alternativa para Handler (esperar a aplicar coroutines)

        Handler().postDelayed(Runnable {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 3400)
    }
}