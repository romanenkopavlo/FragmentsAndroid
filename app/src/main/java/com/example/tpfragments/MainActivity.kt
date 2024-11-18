package com.example.tpfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.tpfragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

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
        fragmentTransaction.replace(binding.fragmentContainerView.id, fragment)
        fragmentTransaction.commit()
    }
}