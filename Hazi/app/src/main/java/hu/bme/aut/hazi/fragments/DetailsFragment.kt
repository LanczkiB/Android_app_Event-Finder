package hu.bme.aut.hazi.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import hu.bme.aut.hazi.ItemManager
import hu.bme.aut.hazi.ListItem
import hu.bme.aut.hazi.databinding.DetailBinding

class DetailsFragment() : DialogFragment(){
    private lateinit var binding: DetailBinding

    companion object {
        const val TAG = "DetailsDialogFragment"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DetailBinding.inflate(inflater, container, false)
        binding.Name.text=ItemManager.Item.name
        binding.Desc.text=ItemManager.Item.description
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}