package com.imran.profilemodulekotlin.network

import com.imran.profilemodulekotlin.model.CreateUserResponse
import com.imran.profilemodulekotlin.model.Data
import com.kotlinapp.swiggyclone.auth.model.SignupInputBody
import retrofit2.Call
import retrofit2.Response

import retrofit2.Retrofit
import retrofit2.http.Body
import retrofit2.http.Headers

import retrofit2.http.POST
import retrofit2.http.Query

interface ApiInterface {

  /*  @POST("create_user")
   suspend fun createUser(@Query("deviceToken") deviceToken:String,
                   @Query("userName") userName:String,
                   @Query("email") userEmail: String,
                   @Query("phoneno") userPhone: String,
                   @Query("gender") userGender: String,
                   @Query("password") userPassword: String,
                   @Query("password_confirm") userCnfmPassword: String,
                   @Query("deviceType") userDeviceType :String,) :Response<CreateUserResponse>*/

    @POST("create_user")
    fun createUser(@Body signupInput:SignupInputBody ) :Call<CreateUserResponse>
}