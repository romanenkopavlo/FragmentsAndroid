package com.example.tpfragments
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.tpfragments.databinding.Fragment2Binding
import com.example.tpfragments.view_model.DataViewModel


class Fragment2 : Fragment(R.layout.fragment_2) {
    private lateinit var dataViewModelPartage : DataViewModel
    private lateinit var binding : Fragment2Binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dataViewModelPartage = ViewModelProvider(requireActivity()).get(DataViewModel::class.java)
        binding = Fragment2Binding.inflate(inflater, container, false)
        binding.lifecycleOwner = this@Fragment2

        binding.buttonPlus.setOnClickListener {
            dataViewModelPartage.updateData(dataViewModelPartage.getDataValue() + 1)
        }

        binding.buttonMoins.setOnClickListener {
            dataViewModelPartage.updateData(dataViewModelPartage.getDataValue() - 1)
        }

        dataViewModelPartage.data.observe(viewLifecycleOwner) { data ->
            binding.numeroVariable.text = data.compteur.toString()
        }

        return binding.root
    }
}