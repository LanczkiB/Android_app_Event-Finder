package hu.bme.aut.hazi


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import hu.bme.aut.hazi.data.entities.ActivityItem
import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import hu.bme.aut.hazi.adapter.FavAdapter
import hu.bme.aut.hazi.data.UserListDatabase
import hu.bme.aut.hazi.databinding.ActivityEtkezesBinding
import kotlin.concurrent.thread


class FavouritesActivity : AppCompatActivity(), FavAdapter.ActivityItemClickListener{
    private lateinit var binding: ActivityEtkezesBinding
    private lateinit var adapter: FavAdapter
    private lateinit var database: UserListDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEtkezesBinding.inflate(layoutInflater)
        database = UserListDatabase.getDatabase(applicationContext)
        setContentView(binding.root)
        initRecyclerView()

        binding.title.text="Kedvencek"
        binding.btnfab.setImageResource(R.drawable.house)
        binding.btnfab.setOnClickListener{
            val intent = Intent(this, ChooseActivity::class.java)
            startActivity(intent)
        }
    }

    private fun loadItemsInBackground() {
        thread {
            ItemManager.activities=database.UserItemDao().getActivysOfUser(ItemManager.User.email)[0].activites
            runOnUiThread {
                adapter.update(ItemManager.activities)
            }
        }
    }

    private fun initRecyclerView() {
        adapter = FavAdapter(this.supportFragmentManager,this)
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