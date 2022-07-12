package com.imran.profilemodulekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.imran.profilemodulekotlin.databinding.ActivityMainBinding
import com.imran.profilemodulekotlin.model.Data
import com.imran.profilemodulekotlin.network.ApiInterface
import com.imran.profilemodulekotlin.network.RetrofitClient
import com.imran.profilemodulekotlin.repositery.CreateUserRepositery
import com.imran.profilemodulekotlin.viewmodel.ViewModel
import com.imran.profilemodulekotlin.viewmodel.ViewModelFactory
import com.kotlinapp.swiggyclone.auth.model.SignupInputBody

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var viewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        val repository = CreateUserRepositery()
        var factory = ViewModelFactory(application,repository)
        viewModel = ViewModelProvider(this,factory).get(ViewModel::class.java)

        binding.signupBtn.setOnClickListener {
            val signupInputBody = SignupInputBody("shgghd","test12","testLIP@yopmail.com","8877654122",
            "Male","123456","123456")

            viewModel.signupUser(signupInputBody)
        }

        viewModel.signupResponse.observe(this, Observer { event->
            var resourceData = event.peekContent().data

//            if (event.peekContent().data?.status!!.contains("true")){
                Log.d("responseSignup", "onCreate: "+event.peekContent().data?.message)
                Log.d("responseSignup", "onCreate: "+event.peekContent().data?.data?.email)
//                }else{
//
//                Toast.makeText(this,"Login Failed", Toast.LENGTH_SHORT).show()
//            }
        })

    }



}