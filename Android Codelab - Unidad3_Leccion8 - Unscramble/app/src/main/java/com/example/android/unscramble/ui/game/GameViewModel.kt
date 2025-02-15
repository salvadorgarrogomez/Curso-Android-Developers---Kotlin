package com.example.android.unscramble.ui.game

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    private val _score = MutableLiveData(0)
    val score: LiveData<Int>
        get() = _score

    private val _currentWordCount = MutableLiveData(0)
    val currentWordCount: LiveData<Int>
        get() = _currentWordCount

    private val _currentScrambledWord = MutableLiveData<String>()
    val currentScrambleWord: LiveData<String>
        get() = _currentScrambledWord

    /* En el caso de que se quiera implementar funcionalidades TalkBack
        private val _currentScrambledWord = MutableLiveData<String>()
    val currentScrambleWord: LiveData<Spannable> = Transformations.map(_currentScrambledWord) { scrambledWord ->
        if (scrambledWord.isNullOrEmpty()) {
            SpannableString("")
        } else {
            val spannable = SpannableString(scrambledWord)
            spannable.setSpan(
                TtsSpan.VerbatimBuilder(scrambledWord).build(),
                0,
                scrambledWord.length,
                Spannable.SPAN_INCLUSIVE_INCLUSIVE
            )
            spannable
        }
    }
     */

    private var wordsList: MutableList<String> = mutableListOf()
    private lateinit var currentWord: String

    // IMPORTANTE!!! El init siempre ha de ir despues de las variables
    init {
        Log.d("GameFragment","GameViewModel created!")
        getNextWord()
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("GameFragment", "GameViewModel destroyed!")
    }

    private fun getNextWord(){
        currentWord = allWordsList.random()
        val tempWord = currentWord.toCharArray()
        tempWord.shuffle()
        while (String(tempWord).equals(currentWord, false)){
            tempWord.shuffle()
        }
        if (wordsList.contains(currentWord)){
            getNextWord()
        } else {
            _currentScrambledWord.value = String(tempWord)
            _currentWordCount.value = (_currentWordCount.value)?.inc()
            wordsList.add(currentWord)
        }
    }

    fun nextWord(): Boolean{
        return if (_currentWordCount.value!! < MAX_NO_OF_WORDS){
            getNextWord()
            true
        } else false
    }

    private fun increaseScore(){
        _score.value = (_score.value)?.plus(SCORE_INCREASE)
    }
    fun isUserWordCorrect(playerWord: String): Boolean{
        if (playerWord.equals(currentWord, true)){
            increaseScore()
            return true
        }
        return false
    }

    /*
     Re-initializes the game data to restart the game
     */
    fun reinitializeData(){
        _score.value = 0
        _currentWordCount.value = 0
        wordsList.clear()
        getNextWord()
    }
}