package com.imran.profilemodulekotlin.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import com.imran.profilemodulekotlin.repositery.CreateUserRepositery


class ViewModelFactory(val app: Application,
                       val appRepository: CreateUserRepositery) : ViewModelProvider.Factory {
    override fun <T : androidx.lifecycle.ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ViewModel::class.java)) {
            return ViewModel(app, appRepository) as T
        }else{
            throw IllegalArgumentException("Unknown class name")

        }
    }

}
