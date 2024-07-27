package com.aah.newsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.aah.newsapp.R
import com.aah.newsapp.databinding.ActivityMainBinding
import com.aah.newsapp.ui.components.LoadingDialog
import com.aah.newsapp.ui.fragment.News
import com.aah.newsapp.ui.fragment.Saved
import com.aah.newsapp.ui.fragment.Search
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fragmentTransaction(News())
        binding.bottomNav.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.news -> fragmentTransaction(News())
                R.id.saved -> fragmentTransaction(Saved())
                R.id.search -> fragmentTransaction(Search())
            }
            true
        }

    }

    private fun fragmentTransaction(newFragment: Fragment) {
        val fragment = supportFragmentManager.beginTransaction()
        fragment.replace(R.id.container, newFragment)
        fragment.commit()
    }

}