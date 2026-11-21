package cue.edu.co.myapplication.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cue.edu.co.myapplication.model.ProductType
import cue.edu.co.myapplication.ui.components.AppHeader
import cue.edu.co.myapplication.ui.components.TypeBadge

@Composable
fun HomeScreen(
    onRegisterClick: () -> Unit,
    onListClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier.fillMaxSize()) {
        AppHeader(title = "Product Manager", subtitle = "Register products and browse your catalog")

        Column(
            modifier = Modifier.weight(1f).padding(24.dp).navigationBarsPadding(),
            verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                ProductType.entries.forEach { TypeBadge(it, size = 64.dp) }
            }
            Spacer(Modifier.height(16.dp))
            Button(
                onClick = onRegisterClick,
                shape = RoundedCornerShape(16.dp),
                contentPadding = ButtonDefaults.ContentPadding,
                modifier = Modifier.fillMaxWidth().height(56.dp),
            ) { Text("Register product", style = MaterialTheme.typography.titleMedium) }
            FilledTonalButton(
                onClick = onListClick,
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.fillMaxWidth().height(56.dp),
            ) { Text("View products", style = MaterialTheme.typography.titleMedium) }
        }
    }
}
