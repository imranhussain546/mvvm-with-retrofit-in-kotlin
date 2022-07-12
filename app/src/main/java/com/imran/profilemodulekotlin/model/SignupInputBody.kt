package com.kotlinapp.swiggyclone.auth.model

import com.google.gson.annotations.SerializedName

data class SignupInputBody(@SerializedName("deviceToken" ) var deviceToken : String? = null,
                           @SerializedName("userName" ) var userName : String? = null,
                           @SerializedName("email" ) var userEmail : String? = null,
                          @SerializedName("phoneno" ) var pNo : String? = null,
                          @SerializedName("gender" ) var gender : String? = null,
                          @SerializedName("password" ) var password : String? = null,
                          @SerializedName("password_confirm" ) var cnfrm_password : String? = null,
                          @SerializedName("deviceType" ) var deviceType : String? = null
){

}
