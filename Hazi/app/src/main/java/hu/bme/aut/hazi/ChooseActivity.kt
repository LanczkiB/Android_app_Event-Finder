package hu.bme.aut.hazi

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import hu.bme.aut.hazi.databinding.ActivityChooseBinding

class ChooseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChooseBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityChooseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEtkezes.setOnClickListener {

            val intent = Intent(this, EtkezesActivity::class.java)
            val extras = Bundle()
            extras.putString(EtkezesActivity.KEY_Activity_TYPE, 1.toString())
            extras.putString(EtkezesActivity.KEY_Activity_TITLE, "Étkezés")
            intent.putExtras(extras)
            startActivity(intent)
        }
        binding.btnIszogatas.setOnClickListener {
            val intent = Intent(this, EtkezesActivity::class.java)
            val extras = Bundle()
            extras.putString(EtkezesActivity.KEY_Activity_TYPE, 2.toString())
            extras.putString(EtkezesActivity.KEY_Activity_TITLE, "Iszogatás")
            intent.putExtras(extras)
            startActivity(intent)
        }
        binding.btnBelter.setOnClickListener {
            val intent = Intent(this, EtkezesActivity::class.java)
            val extras = Bundle()
            extras.putString(EtkezesActivity.KEY_Activity_TYPE, 4.toString())
            extras.putString(EtkezesActivity.KEY_Activity_TITLE, "Beltéri programok")
            intent.putExtras(extras)
            startActivity(intent)
        }
        binding.btnKulter.setOnClickListener {
            val intent = Intent(this, EtkezesActivity::class.java)
            val extras = Bundle()
            extras.putString(EtkezesActivity.KEY_Activity_TYPE, 3.toString())
            extras.putString(EtkezesActivity.KEY_Activity_TITLE, "Kültéri programok")
            intent.putExtras(extras)
            startActivity(intent)
        }
        binding.btnfab.setOnClickListener {
            val intent = Intent(this, FavouritesActivity::class.java)
            startActivity(intent)
        }
    }

}