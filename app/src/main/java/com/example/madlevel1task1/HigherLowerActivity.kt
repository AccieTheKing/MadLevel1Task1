package com.example.madlevel1task1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.madlevel1task1.databinding.ActivityHigherLowerBinding

class HigherLowerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHigherLowerBinding
    private var currentThrow: Int = 1;
    private var lastThrow: Int = 1;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHigherLowerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    /**
     * This method will set the initialisation of the UI state
     */
    private fun initViews(){
        updateUI();
    }

    /**
     * This method will update the dice image with the correct resource update
     * the last throw text with the new throw text
     */
    private fun updateUI(){
        binding.lastThrowLabel.text = getString(R.string.last_throw_label, lastThrow)
    }
}