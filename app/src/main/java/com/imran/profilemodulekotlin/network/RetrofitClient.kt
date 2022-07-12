package com.imran.profilemodulekotlin.network

import com.imran.profilemodulekotlin.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

 class RetrofitClient {

        private  val BASEURL="add your base url"
//        private lateinit var mApiInterface: ApiInterface
//        private var mInstance: RetrofitClient?= null

       /* fun getIntance():RetrofitClient{
            if (mInstance==null){
                synchronized(this)   // one thread call at one time
                {
                    mInstance= RetrofitClient
                }

            }
            return mInstance!!
        }*/

    val retrofitClient: Retrofit.Builder by lazy {
        val levelType: HttpLoggingInterceptor.Level
        if (BuildConfig.BUILD_TYPE.contentEquals("debug"))
            levelType = HttpLoggingInterceptor.Level.BODY else levelType = HttpLoggingInterceptor.Level.NONE
        val loggingInterceptor= HttpLoggingInterceptor()
        loggingInterceptor.setLevel(levelType)
        val okHttpClient = OkHttpClient.Builder()
        okHttpClient.addInterceptor(loggingInterceptor)
        Retrofit.Builder().baseUrl(BASEURL).client(okHttpClient.build()).addConverterFactory(GsonConverterFactory.create())

    }

     val apiInterface:ApiInterface by lazy {
         retrofitClient.build().create(ApiInterface::class.java)
     }

   /* init {
        val okHttpClient = OkHttpClient().newBuilder().connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder().baseUrl(BASEURL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        mApiInterface = retrofit.create(ApiInterface::class.java)
    }*/


}