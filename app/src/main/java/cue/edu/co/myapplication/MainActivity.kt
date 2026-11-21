package cue.edu.co.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import cue.edu.co.myapplication.ui.screens.HomeScreen
import cue.edu.co.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    HomeScreen(
                        onRegisterClick = {
                            startActivity(Intent(this, RegisterProductActivity::class.java))
                        },
                        onListClick = {
                            startActivity(Intent(this, ProductListActivity::class.java))
                        },
                        modifier = Modifier,
                    )
                }
            }
        }
    }
}
