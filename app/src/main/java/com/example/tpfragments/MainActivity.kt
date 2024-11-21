package com.example.tpfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.tpfragments.databinding.ActivityMainBinding
import com.example.tpfragments.view_model.DataViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var dataViewModelPartage : DataViewModel
    private var isLaunched : Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        dataViewModelPartage = ViewModelProvider(this).get(DataViewModel::class.java)
        dataViewModelPartage.init()
        setContentView(binding.root)

        binding.button1.setOnClickListener {
            if (!isLaunched) {
                generateNumber()
            }
            remplaceFragment(Fragment1())
            Toast.makeText(this@MainActivity, "Fragment 1", Toast.LENGTH_SHORT).show()
        }
        binding.button2.setOnClickListener {
            if (!isLaunched) {
                generateNumber()
            }
            remplaceFragment(Fragment2())
            Toast.makeText(this@MainActivity, "Fragment 2", Toast.LENGTH_SHORT).show()
        }

        dataViewModelPartage.data.observe(this) { newValue ->
            Log.d("MainActivity", "Observed new value: ${newValue.compteur}")
        }

    }
    private fun generateNumber() {
        lifecycleScope.launch {
            isLaunched = true
            while (true) {
                val randomValue = Random.nextInt(0, 100)
                dataViewModelPartage.updateData(randomValue)
                delay(5000)
            }
        }
    }
    private fun remplaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(binding.fragmentContainerView1.id, fragment)
        fragmentTransaction.commit()
    }
}