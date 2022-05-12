package hu.bme.aut.hazi.adapter

import android.content.ClipData
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import hu.bme.aut.hazi.data.UserListDatabase
import hu.bme.aut.hazi.data.entities.ActivityItem

import android.content.Intent
import hu.bme.aut.hazi.*
import hu.bme.aut.hazi.data.entities.UserActivityCrossRef
import hu.bme.aut.hazi.databinding.ActivityFavouritesBinding
import hu.bme.aut.hazi.fragments.DetailsFragment
import kotlin.concurrent.thread


class FavAdapter(fragmentManager: FragmentManager, context:Context) :
    RecyclerView.Adapter<FavAdapter.ActivityViewHolder>() {
    var con:Context=context
    var fragmentMana: FragmentManager=fragmentManager
    private var items =mutableListOf<ActivityItem>()

    private lateinit var database: UserListDatabase
    var list =mutableListOf<ActivityItem>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ActivityViewHolder(
        ActivityFavouritesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ActivityViewHolder, position: Int) {
        items= ItemManager.activities as MutableList<ActivityItem>
        database = UserListDatabase.getDatabase(con)
        val activityItem = items[position]
        holder.binding.ibFavourite.setImageResource(R.drawable.star2)
        var j=1

            thread{
                val listhelp=database.UserItemDao().getActivysOfUser(ItemManager.User.email.toString()).get(0).activites
                j=1
                for(i in listhelp){
                    if(i.name.toString()==activityItem.name.toString())j=2
                }
                if(j==2)holder.binding.ibFavourite.setImageResource(R.drawable.yellow_star)
            }

        holder.binding.activityPic.setImageResource(activityItem.picture)
        holder.binding.activityName.text=activityItem.name
        holder.binding.activityParti.text=activityItem.parti
        holder.binding.activityDate.text=activityItem.date


        holder.binding.ibMore.setOnClickListener {
            ItemManager.Item=ListItem(activityItem.id,activityItem.name,activityItem.description,activityItem.picture,activityItem.type,activityItem.date,activityItem.parti)
            DetailsFragment().show(fragmentMana,
                DetailsFragment.TAG)
        }

        holder.binding.ibFavourite.setOnClickListener {
            ItemManager.Item=ListItem(activityItem.id,activityItem.name,activityItem.description,activityItem.picture,activityItem.type,activityItem.date,activityItem.parti)


            if(j==1){
                holder.binding.ibFavourite.setImageResource(R.drawable.yellow_star)
                thread {
                    database.UserItemDao().insertUserActivityCrossRef(UserActivityCrossRef(ItemManager.User.email,activityItem.name))
                }
                j=2
            }

            else {
                holder.binding.ibFavourite.setImageResource(R.drawable.star2)

                thread{
                    database.UserItemDao().deleteCrossRef(ItemManager.User.email.toString(),activityItem.name.toString())
                }
                j=1

            }
        }
        holder.binding.ibPlus.setOnClickListener {
            ItemManager.Item=ListItem(activityItem.id,activityItem.name,activityItem.description,activityItem.picture,activityItem.type,activityItem.date,activityItem.parti)
            holder.binding.ibFavourite.setImageResource(R.drawable.yellow_star)

            holder.binding.ibPlus.setImageResource(R.drawable.yellow_plus)
            val intent = Intent(con, PlusActivity::class.java)
            intent.putExtra(PlusActivity.KEY_Activity_TYPE,activityItem.name)
            con.startActivity(intent)
        }
    }

    fun update(shoppingItems: List<ActivityItem>) {
        items.clear()
        items.addAll(shoppingItems)
        notifyDataSetChanged()
    }
    interface ActivityItemClickListener {
        fun onItemChanged(item: ActivityItem)
    }

    override fun getItemCount(): Int = items.size


    inner class ActivityViewHolder(val binding: ActivityFavouritesBinding) : RecyclerView.ViewHolder(binding.root)
}