package hu.bme.aut.hazi


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import hu.bme.aut.hazi.adapter.ActivityAdapter
import hu.bme.aut.hazi.data.UserListDatabase
import hu.bme.aut.hazi.data.entities.ActivityItem
import hu.bme.aut.hazi.databinding.ActivityEtkezesBinding
import kotlin.concurrent.thread

class EtkezesActivity : AppCompatActivity(), ActivityAdapter.ActivityItemClickListener  {

    private lateinit var binding: ActivityEtkezesBinding
    private lateinit var database: UserListDatabase
    companion object {
        var KEY_Activity_TYPE="KEY_Activity_TYPE"
        var KEY_Activity_TITLE="KEY_Activity_TITLE"
    }
    private lateinit var adapter: ActivityAdapter
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityEtkezesBinding.inflate(layoutInflater)
        database = UserListDatabase.getDatabase(applicationContext)
        val intent = intent
        val extras = intent.extras
        KEY_Activity_TYPE= extras?.getString("KEY_Activity_TYPE")!!.toString()
        KEY_Activity_TITLE = extras.getString("KEY_Activity_TITLE")!!.toString()

        //KEY_Activity_TYPE= intent.extras?.getString("KEY_Activity_TYPE")!!.toString()
        //KEY_Activity_TITLE= intent.extras?.getString("KEY_Activity_TITLE")!!.toString()
        setContentView(binding.root)
        binding.title.text= KEY_Activity_TITLE
        binding.btnfab.setImageResource(R.drawable.yellow_star)
        initRecyclerView()
        binding.btnfab.setOnClickListener{
            val intent1 = Intent(this, FavouritesActivity::class.java)
            startActivity(intent1)
        }

    }


    private fun loadItemsInBackground() {
        thread {
            ItemManager.activities = database.UserItemDao().getTypeActivity(KEY_Activity_TYPE.toInt())
            KEY_Activity_TYPE="KEY_Activity_TYPE"
            KEY_Activity_TITLE="KEY_Activity_TITLE"
            runOnUiThread {
                adapter.update(ItemManager.activities)
            }
        }
    }

    private fun initRecyclerView() {
        adapter = ActivityAdapter(this.supportFragmentManager,this)
        binding.rvMain.adapter=adapter
        binding.rvMain.layoutManager = LinearLayoutManager(this)
        loadItemsInBackground()
    }

    override fun onItemChanged(item: ActivityItem) {
        thread {
            database.UserItemDao().update(item)
        }
    }
}