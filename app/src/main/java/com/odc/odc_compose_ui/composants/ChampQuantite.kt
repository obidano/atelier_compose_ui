package com.odc.odc_compose_ui.composants


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.odc.odc_compose_ui.ui.theme.rowTextColor

@Composable
@Preview(showBackground = true)
fun ChampQuantite(label: String = "Quantité", qte: MutableState<Int> = mutableStateOf(0)) {

    val focusRequester = FocusRequester()

    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }

    OutlinedTextField(modifier = Modifier
        .padding(top = 20.dp)
        .fillMaxWidth()
        .focusRequester(focusRequester),
        value = qte.value.toString(),
        onValueChange = { qte.value = it.toIntOrNull() ?: 0 },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        label = {
            Text(label, color = MaterialTheme.colors.rowTextColor)
        })


}