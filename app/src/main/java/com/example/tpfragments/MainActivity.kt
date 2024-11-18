package com.example.tpfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.tpfragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private var number: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        binding.numberField.setText("0")
//
//        binding.buttonPlus.setOnClickListener {
//            number = binding.numberField.text.toString().toInt() + 1
//            binding.numberField.setText(number.toString())
//        }
//
//        binding.buttonMoins.setOnClickListener {
//            number = binding.numberField.text.toString().toInt() - 1
//            binding.numberField.setText(number.toString())
//        }

        binding.button1.setOnClickListener {
            remplaceFragment(Fragment1())
            Toast.makeText(this@MainActivity, "Fragment 1 is changed", Toast.LENGTH_SHORT).show()
        }
        binding.button2.setOnClickListener {
            remplaceFragment(Fragment2())
            Toast.makeText(this@MainActivity, "Fragment 2 is changed", Toast.LENGTH_SHORT).show()
        }
    }
    private fun remplaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(binding.fragmentContainerView1.id, fragment)
        fragmentTransaction.commit()
    }
}