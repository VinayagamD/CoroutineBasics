package com.vinaylogics.coroutinebasics.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.vinaylogics.coroutinebasics.R
import com.vinaylogics.coroutinebasics.databinding.ActivityCoroutineBinding
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.time.Duration.Companion.seconds

class CoroutineActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCoroutineBinding
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoroutineBinding.inflate(layoutInflater)
        setContentView(binding.root)
        GlobalScope.launch (Dispatchers.IO){
            Log.d(TAG, "Starting coroutine in thread ${Thread.currentThread().name}")
            val answer = doNetworkCall()
            withContext(Dispatchers.Main){
                Log.d(TAG, "Setting text in thread ${Thread.currentThread().name}")
                binding.tvDummy.text = answer
            }
        }
    }

    suspend fun doNetworkCall(): String{
        delay(3.seconds)
        return "This is the answer"
    }
    suspend fun doNetworkCall2(): String{
        delay(3.seconds)
        return "This is the answer"
    }

    companion object {
         val TAG = CoroutineActivity::class.java.simpleName
    }
}