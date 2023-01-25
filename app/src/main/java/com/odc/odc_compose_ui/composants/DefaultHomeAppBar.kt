package com.odc.odc_compose_ui.composants


import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.odc.odc_compose_ui.composants.FiltreCategorieAction
import com.odc.odc_compose_ui.composants.MenuActionBtn
import com.odc.odc_compose_ui.composants.SearchActionBtn
import com.odc.odc_compose_ui.lib.utils.Categorie
import com.odc.odc_compose_ui.ui.theme.topAppBarBackGroundColor
import com.odc.odc_compose_ui.ui.theme.topAppBarContentColor

@Composable
@Preview(showBackground = false)
fun DefaultHomeAppBar(
    onOpenSearchClick: () -> Unit = {},
    onFiltreClick: (Categorie) -> Unit = {},
) {
    TopAppBar(
        title = { Text("Activités", color = MaterialTheme.colors.topAppBarContentColor) },
        elevation = 0.dp, backgroundColor = MaterialTheme.colors.topAppBarBackGroundColor,
        actions = {
            MenuActionBtn()
            FiltreCategorieAction(onFiltreClick)
            SearchActionBtn(onOpenSearchClick)
        }
    )
}
