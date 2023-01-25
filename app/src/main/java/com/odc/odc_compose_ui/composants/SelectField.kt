@file:OptIn(ExperimentalMaterialApi::class)

package com.odc.odc_compose_ui.composants


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.odc.odc_compose_ui.models.SelectModel

@Composable
fun SelectField(
    modifier: Modifier = Modifier,
    label: String,
    value: () -> String,
    onValueChange: (String) -> Unit,
    options: List<SelectModel>,
) {

    var selectedItem by remember {
        mutableStateOf(value())
    }

    var expanded by remember {
        mutableStateOf(false)
    }

    // the box
    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = {
            expanded = !expanded
        }
    ) {

        // text field
        OutlinedTextField(
            modifier = modifier
                .fillMaxWidth(),
            value = selectedItem,
            onValueChange = {},
            readOnly = true,
            label = { Text(text = label) },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(
                    expanded = expanded
                )
            },
            // colors = ExposedDropdownMenuDefaults.textFieldColors()
        )

        // menu
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.background(Color.Transparent)
        ) {
            options.forEach { selectedOption ->
                // menu item
                DropdownMenuItem(onClick = {
                    selectedItem = selectedOption.label
                    onValueChange(selectedOption.value)
                    expanded = false
                }) {
                    Text(text = selectedOption.label)
                }
            }
        }
    }
}