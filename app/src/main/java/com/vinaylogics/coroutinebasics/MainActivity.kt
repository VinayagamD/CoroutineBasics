package com.vinaylogics.coroutinebasics

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.vinaylogics.coroutinebasics.ui.theme.CoroutineBasicsTheme
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.seconds

class MainActivity : ComponentActivity() {

    val TAG = MainActivity::class.java.simpleName

    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            CoroutineBasicsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }

        GlobalScope.launch {
            delay(1.seconds)
            val networkCallAnswer = doNetworkCall()
            val networkCallAnswer2 = doNetworkCall2()
            Log.d(TAG, networkCallAnswer)
            Log.d(TAG, networkCallAnswer2)
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

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CoroutineBasicsTheme {
        Greeting("Android")
    }
}