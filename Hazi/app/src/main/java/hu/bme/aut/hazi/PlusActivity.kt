package hu.bme.aut.hazi


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import hu.bme.aut.hazi.data.UserListDatabase
import hu.bme.aut.hazi.data.entities.UserActivityCrossRef
import hu.bme.aut.hazi.databinding.ActivityPlusBinding
import kotlin.concurrent.thread
import android.content.Intent
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import hu.bme.aut.hazi.data.entities.ActivityItem


class PlusActivity : AppCompatActivity(){
    private lateinit var binding: ActivityPlusBinding
    private lateinit var database: UserListDatabase
    companion object {
        var KEY_Activity_TYPE="KEY_Activity_TYPE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlusBinding.inflate(layoutInflater)
        database = UserListDatabase.getDatabase(applicationContext)
        setContentView(binding.root)
        val simpleDatePicker = binding.datepick
        val simpleTimePicker = binding.timepicker
        simpleDatePicker.minDate=System.currentTimeMillis()
        var torolt=0
        KEY_Activity_TYPE = intent.extras?.getString("KEY_Activity_TYPE").toString()
        binding.btnDel.setOnClickListener{
            if(ItemManager.Item.parti=="") Toast.makeText(this,"Nincsen résztvevő hozzáadva", Toast.LENGTH_LONG).show()
            else Toast.makeText(this,"A résztvevő tényleges törléséhez katttintson a Hozzáad gombra!", Toast.LENGTH_LONG).show()
            ItemManager.Item.parti=""
            torolt=1
        }
        binding.btnSave.setOnClickListener {

                    var hm=""
                    if(torolt==0){
                        hm = if(ItemManager.Item.parti=="")
                            binding.nev.text.toString()
                        else ItemManager.Item.parti+","+binding.nev.text.toString()
                    }
                    torolt=0

                    thread {
                        database.UserItemDao().insertActivity(ActivityItem(ItemManager.Item.id,
                            ItemManager.Item.name,ItemManager.Item.description,ItemManager.Item.picture,ItemManager.Item.type,simpleDatePicker.year.toString()+"."+simpleDatePicker.month.toString()+"."+simpleDatePicker.dayOfMonth.toString()+".   "+simpleTimePicker.hour.toString()+":"+simpleTimePicker.minute.toString(),hm))

                        database.UserItemDao().insertUserActivityCrossRef(
                            UserActivityCrossRef(ItemManager.User.email,
                                ItemManager.Item.name)
                        )
                    }
                Snackbar.make(it, R.string.warn_message, Snackbar.LENGTH_LONG).show()
                return@setOnClickListener

                }
        binding.btnfab.setOnClickListener{
            val intent = Intent(this, FavouritesActivity::class.java)
            startActivity(intent)
        }


    }
}
