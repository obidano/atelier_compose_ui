package com.odc.odc_compose_ui


import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.odc.odc_compose_ui.ui.theme.Odc_compose_uiTheme


@Composable
fun TemplatePage(navC: NavHostController) {

    val naviguer = { route: String ->
        navC.navigate(route)
    }

    val retourArriere: () -> Unit = {
        navC.popBackStack()
    }

    TemplateBody(naviguer, retourArriere)

}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
private fun TemplateBody(naviguer: (String) -> Unit={}, retourArriere: () -> Unit={}) {
    val context = LocalContext.current
    Scaffold() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(1.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {


        }
    }

}

@Composable
@Preview(showBackground = true)
private fun PreviewTemplatePage() {
    Odc_compose_uiTheme {
        TemplateBody()
    }
}


