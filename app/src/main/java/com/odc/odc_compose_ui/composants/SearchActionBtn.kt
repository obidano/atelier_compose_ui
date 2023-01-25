package com.odc.odc_compose_ui.composants


import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.odc.odc_compose_ui.ui.theme.topAppBarContentColor

@Composable
@Preview(showBackground = false, widthDp = 300)
fun SearchActionBtn(onOpenSearchClick: () -> Unit = {}) {
    IconButton(onClick = { onOpenSearchClick() }) {
        Icon(Icons.Filled.Person, "", tint = MaterialTheme.colors.topAppBarContentColor)
    }
}