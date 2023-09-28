package com.lulu.teoremus.view.quiz

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class QuizViewModelFactory ( val document: String) :ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(QuizViewModel::class.java)) {
            QuizViewModel(this.document) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}