package hu.bme.aut.hazi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.widget.ImageView
import hu.bme.aut.hazi.databinding.ActivityLoadBinding

class LoadActvity : AppCompatActivity() {
    private lateinit var binding: ActivityLoadBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        val backgroundImage: ImageView = binding.SplashScreenImage
        val slideAnimation = AnimationUtils.loadAnimation(this, R.anim.rotation)

        backgroundImage.startAnimation(slideAnimation)

        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }


}