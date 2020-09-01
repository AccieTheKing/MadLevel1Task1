package com.example.madlevel1task1

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.madlevel1task1.databinding.ActivityHigherLowerBinding

class HigherLowerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHigherLowerBinding
    private var currentThrow: Int = 1
    private var lastThrow: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHigherLowerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    /**
     * This method will set the initialisation of the UI state
     */
    private fun initViews() {
        updateUI()
    }

    /**
     * This method will update the dice image with the correct resource update
     * the last throw text with the new throw text
     */
    private fun updateUI() {
        binding.lastThrowLabel.text = getString(R.string.last_throw, lastThrow)
    }

    /**
     * This method will of course roll the dice. When one of the buttons are clicked this method
     * will be called and generates a new dice value
     */
    private fun rollDice() {
        lastThrow = currentThrow
        currentThrow = (1..6).random()
        updateUI()
    }

    /**
     * This methods will call the [rollDice] function and checks for the correct answer
     */
    private fun onLowerClick() {
        rollDice()

        if(currentThrow < lastThrow) onAnswerCorrect()
        else onAnswerIncorrect()
    }

    /**
     * This methods will call the [rollDice] function and checks for the correct answer
     */
    private fun onHigherClick() {
        rollDice()

        if(currentThrow > lastThrow) onAnswerCorrect()
        else onAnswerIncorrect()
    }

    /**
     * This methods will call the [rollDice] function and checks for the correct answer
     */
    private fun onEqualClick() {
        rollDice()

        if(currentThrow == lastThrow) onAnswerCorrect()
        else
    }

    /**
     * Display a successful Toast message
     */
    private fun onAnswerCorrect() {
        Toast.makeText(this, getString(R.string.correct), Toast.LENGTH_LONG).show()
    }

    /**
     * Display an incorrect Toast message
     */
    private fun onAnswerIncorrect() {
        Toast.makeText(this, getString(R.string.incorrect), Toast.LENGTH_LONG).show()
    }
}