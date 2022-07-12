package com.imran.profilemodulekotlin.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import androidx.lifecycle.ViewModel
import com.imran.profilemodulekotlin.model.CreateUserResponse
import com.imran.profilemodulekotlin.model.Data
import com.imran.profilemodulekotlin.repositery.CreateUserRepositery
import com.kotlinapp.swiggyclone.auth.model.SignupInputBody
import com.kotlinapp.swiggyclone.utils.Event
import com.kotlinapp.swiggyclone.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.awaitResponse
import java.io.IOException

class ViewModel(app: Application, private val appRepository: CreateUserRepositery) : AndroidViewModel(app){
    /*val signupData : LiveData<CreateUserResponse>
        get() = createUserRepositery.userLive


    fun createUser(deviceToken:String,userNmae:String,userEmail:String,userPhone:String,userGender:String,userPassword:String,userCnfrmPassword:String,userDeviceType:String)
    {
        viewModelScope.launch(Dispatchers.IO)
        {
            createUserRepositery.createUser(deviceToken,userNmae,userEmail,userPhone,
                userGender,userPassword,userCnfrmPassword,userDeviceType)
        }
    }*/

    private val _signupResponse = MutableLiveData<Event<Resource<CreateUserResponse>>>()
    val signupResponse: LiveData<Event<Resource<CreateUserResponse>>> =_signupResponse


    fun signupUser(body: SignupInputBody) = viewModelScope.launch {
        signup(body)
    }

    private suspend fun signup(body: SignupInputBody) {
        // THE BELOW LINE WILL SEND THE DATA NULL. SO MANAGE IT ACCORDINGLY IN THE VIEW.
        _signupResponse.postValue(Event(Resource.Loading()))
        try {
            val response = appRepository.SignupUser(body)
            //change here from response
            _signupResponse.postValue(handlerloginResponse(response.awaitResponse()) as Event<Resource<CreateUserResponse>>?)


        } catch (t: Throwable) {
            when (t) {
                is IOException -> {
                    _signupResponse.postValue(
                        Event(Resource.Error("EXCEPTION >>"+t.message)
                        ))
                    Log.i("SWIGGY_CLONE",t.message!!)

                }
                else -> {
                    _signupResponse.postValue(
                        Event(Resource.Error("Conversion Error"+t.message))
                    )
                    Log.i("SWIGGY_CLONE",t.message!!)
                }
            }
        }
    }
    private fun handlerloginResponse(response: Response<CreateUserResponse>): Any {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Event(Resource.Success(resultResponse))
            }
        }
        return ""
    }
}

