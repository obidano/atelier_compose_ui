package com.odc.odc_compose_ui.composants


import androidx.compose.foundation.layout.size
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CarCrash
import androidx.compose.material.icons.filled.Inventory
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.odc.odc_compose_ui.ui.theme.fabBackGroundColor
import com.odc.odc_compose_ui.ui.theme.iconTintColor

@Composable
@Preview(showBackground = false, widthDp = 300, heightDp = 300)
fun FloatingBtn(naviguerVersOperation: () -> Unit = {}) {
    FloatingActionButton(
        onClick = { naviguerVersOperation() },
        backgroundColor = MaterialTheme.colors.fabBackGroundColor
    ) {
        Icon(
            Icons.Filled.CarCrash,
            "",
            tint = MaterialTheme.colors.iconTintColor,
            modifier = Modifier.size(20.dp)
        )
    }
}