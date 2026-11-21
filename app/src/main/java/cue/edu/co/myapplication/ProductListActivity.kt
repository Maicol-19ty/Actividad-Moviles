package cue.edu.co.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import cue.edu.co.myapplication.ui.screens.ProductListScreen
import cue.edu.co.myapplication.ui.theme.MyApplicationTheme

class ProductListActivity : ComponentActivity() {
    private val viewModel by lazy { (application as ProductApp).productViewModel }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    ProductListScreen(
                        products = viewModel.products,
                        onBack = { finish() },
                        modifier = Modifier,
                    )
                }
            }
        }
    }
}
