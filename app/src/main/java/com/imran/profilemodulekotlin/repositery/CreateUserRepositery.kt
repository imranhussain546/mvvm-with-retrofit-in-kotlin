package com.imran.profilemodulekotlin.repositery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.imran.profilemodulekotlin.model.CreateUserResponse
import com.imran.profilemodulekotlin.model.Data
import com.imran.profilemodulekotlin.network.ApiInterface
import com.imran.profilemodulekotlin.network.RetrofitClient
import com.kotlinapp.swiggyclone.auth.model.SignupInputBody
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import javax.security.auth.callback.Callback

class CreateUserRepositery() {

/*    suspend fun loginUserCoroutine(loginInputBody: CreateUserResponse) = RetrofitClient.getInstance()
    private val createData = MutableLiveData<CreateUserResponse>()
    val userLive:LiveData<CreateUserResponse>
        get()=createData

   suspend fun createUser(deviceToken:String,userNmae:String,userEmail:String,userPhone:String,userGender:String,userPassword:String,userCnfrmPassword:String,userDeviceType:String){
       CoroutineScope(Dispatchers.IO).launch {
           val result = apiInterface.createUser(deviceToken,userNmae,userEmail,userPhone,userGender,userPassword,userCnfrmPassword,userDeviceType)
           if (result.body() !=null)
           {
               createData.postValue(result.body())
           }
       }


    }*/
 suspend fun SignupUser(signupInput:SignupInputBody) = RetrofitClient().apiInterface.createUser(signupInput)


}