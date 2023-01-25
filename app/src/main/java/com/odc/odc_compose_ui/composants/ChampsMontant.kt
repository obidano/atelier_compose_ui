package com.odc.odc_compose_ui.composants


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.odc.odc_compose_ui.ui.theme.rowTextColor

@Composable
@Preview(showBackground = true)
fun ChampsMontant(montant: MutableState<Double> = mutableStateOf(0.0)) {
    OutlinedTextField(modifier = Modifier
        .padding(top = 20.dp)
        .fillMaxWidth(),
        value = montant.value.toString(),
        readOnly = true,
        onValueChange = { montant.value = it.toDouble() },
        label = {
            Text("Montant total", color = MaterialTheme.colors.rowTextColor)
        })
}