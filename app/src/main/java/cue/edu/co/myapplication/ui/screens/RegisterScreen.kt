package cue.edu.co.myapplication.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import cue.edu.co.myapplication.model.Product
import cue.edu.co.myapplication.model.ProductType
import cue.edu.co.myapplication.ui.components.AppHeader
import cue.edu.co.myapplication.ui.components.TypeBadge

@Composable
fun RegisterScreen(
    onRegister: (Product) -> Unit,
    onBack: () -> Unit,
    modifier: Modifier = Modifier,
) {
    var name by rememberSaveable { mutableStateOf("") }
    var price by rememberSaveable { mutableStateOf("") }
    var type by rememberSaveable { mutableStateOf(ProductType.TECHNOLOGY) }

    val parsedPrice = price.toDoubleOrNull()
    val priceInvalid = price.isNotEmpty() && (parsedPrice == null || parsedPrice < 0)
    val canRegister = name.isNotBlank() && parsedPrice != null && parsedPrice >= 0

    Column(modifier = modifier.fillMaxSize().imePadding()) {
        AppHeader(title = "Register product", subtitle = "Fill in the details below", onBack = onBack)

        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(20.dp)
                .navigationBarsPadding(),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Name") },
                singleLine = true,
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.fillMaxWidth(),
            )
            OutlinedTextField(
                value = price,
                onValueChange = { price = it },
                label = { Text("Price") },
                prefix = { Text("$") },
                isError = priceInvalid,
                supportingText = { if (priceInvalid) Text("Enter a valid number") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                singleLine = true,
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.fillMaxWidth(),
            )

            Text("Type", style = MaterialTheme.typography.titleMedium, modifier = Modifier.padding(top = 4.dp))
            ProductType.entries.forEach { option ->
                val selected = type == option
                Card(
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = if (selected) option.accent.copy(alpha = 0.10f)
                        else MaterialTheme.colorScheme.surfaceContainerLowest,
                    ),
                    border = BorderStroke(
                        width = if (selected) 2.dp else 1.dp,
                        color = if (selected) option.accent else MaterialTheme.colorScheme.outlineVariant,
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .selectable(selected = selected, onClick = { type = option }, role = Role.RadioButton),
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                    ) {
                        TypeBadge(option, size = 48.dp)
                        Text(option.label, style = MaterialTheme.typography.titleMedium, modifier = Modifier.weight(1f))
                        RadioButton(selected = selected, onClick = null)
                    }
                }
            }

            Button(
                onClick = {
                    onRegister(Product(name.trim(), parsedPrice!!, type))
                    name = ""
                    price = ""
                    type = ProductType.TECHNOLOGY
                },
                enabled = canRegister,
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.fillMaxWidth().height(56.dp).padding(top = 0.dp),
            ) { Text("Register", style = MaterialTheme.typography.titleMedium) }
        }
    }
}
