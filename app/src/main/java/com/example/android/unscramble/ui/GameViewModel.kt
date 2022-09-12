package com.example.android.unscramble.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.android.unscramble.ui.game.allWordsList

class GameViewModel : ViewModel() {

    private var score = 0
    private var _currentWordCount = 0
    private var _currentScrambledWord = "test"
    private var wordList: MutableList<String> = mutableListOf()
    private lateinit var currentWord: String
    val currentScrambledWord: String
        get() = _currentScrambledWord

    private fun getNextWord() {
        currentWord = allWordsList.random()
        val tempWord = currentWord.toCharArray()
        tempWord.shuffle()
        while (String(tempWord).equals(currentWord, false)) {
            tempWord.shuffle()
        }
        if (wordList.contains(currentWord)) {
            getNextWord()
        } else {
            _currentScrambledWord = String(tempWord)
            ++_currentWordCount
            wordList.add(currentWord)
        }
    }

    init {
        Log.d("GameFragment", "GameViewModel created!")
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("GameFragment", "GameViewModel destroyed!")
    }


}