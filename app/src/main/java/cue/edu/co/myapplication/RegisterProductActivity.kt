package cue.edu.co.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import cue.edu.co.myapplication.ui.screens.RegisterScreen
import cue.edu.co.myapplication.ui.theme.MyApplicationTheme

class RegisterProductActivity : ComponentActivity() {
    private val viewModel by lazy { (application as ProductApp).productViewModel }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { _ ->
                    RegisterScreen(
                        onRegister = viewModel::addProduct,
                        onBack = { finish() },
                        modifier = Modifier,
                    )
                }
            }
        }
    }
}
