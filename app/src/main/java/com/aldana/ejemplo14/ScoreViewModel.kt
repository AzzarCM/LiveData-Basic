package com.aldana.ejemplo14

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreViewModel : ViewModel() {
    val scoreTeamA = MutableLiveData<Int>().apply { postValue(0) }
    val scoreTeamB = MutableLiveData<Int>().apply { postValue(0) }
}