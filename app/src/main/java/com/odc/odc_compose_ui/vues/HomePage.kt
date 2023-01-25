@file:OptIn(ExperimentalMaterialApi::class)

package com.odc.odc_compose_ui.vues


import android.annotation.SuppressLint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Shop
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.odc.odc_compose_ui.composants.*
import com.odc.odc_compose_ui.lib.utils.Categorie
import com.odc.odc_compose_ui.lib.utils.Constantes
import com.odc.odc_compose_ui.lib.utils.SearchAppBarState
import com.odc.odc_compose_ui.lib.utils.Urls
import com.odc.odc_compose_ui.models.ActivitesModel
import com.odc.odc_compose_ui.vue_models.SharedVueModel
import com.odc.odc_compose_ui.ui.theme.Odc_compose_uiTheme

@Composable
fun HomePage(navC: NavHostController, shareVM: SharedVueModel) {
    val allActivites by shareVM.allActivites.collectAsState()


    val naviguerVersDetail = { id: Int ->
        navC.navigate("task/${id}")
    }

    val naviguerVersOperation: () -> Unit = {
        navC.navigate(Urls.TypeOperationsPage.name)
    }

    val onOpenSearchClick = {
        shareVM.searchAppBarState.value = SearchAppBarState.Opened
    }

    val onFiltreClick = { p: Categorie -> }

    val onTextSearchChange = { text: String ->
        shareVM.searchText.value = text
    }

    val onSearchCloseClick = {
        shareVM.searchText.value = ""
        shareVM.searchAppBarState.value = SearchAppBarState.Closed
    }
    val onSearchClicked = {}


    HomeBody(
        allActivites,
        naviguerVersDetail,
        onOpenSearchClick,
        onFiltreClick,
        shareVM.searchText.value,
        onTextSearchChange,
        shareVM.searchAppBarState.value,
        onSearchCloseClick, naviguerVersOperation
    )

}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
private fun HomeBody(
    listActivites: List<ActivitesModel>,
    naviguerVersDetail: (Int) -> Unit = {},
    onOpenSearchClick: () -> Unit = {},
    onFiltreClick: (Categorie) -> Unit = {},
    searchText: String,
    onTextSearchChange: (String) -> Unit = {},
    searchState: SearchAppBarState = SearchAppBarState.Closed,
    onSearchCloseClick: () -> Unit = {},
    naviguerVersOperation: () -> Unit = {},
) {
    val context = LocalContext.current
    Scaffold(
        topBar = {
            when (searchState) {
                SearchAppBarState.Opened -> SearchHomeAppBar(
                    searchText,
                    onTextSearchChange,
                    onSearchCloseClick
                )
                else -> DefaultHomeAppBar(onOpenSearchClick, onFiltreClick)
            }
        },
        floatingActionButton = {}) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {

            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("Home Page")
            }

        }
    }

}


@Composable
@Preview(showBackground = true)
private fun PreviewHomePage() {
    Odc_compose_uiTheme {
        HomeBody(
            listActivites = Constantes.FakeActivites,
            searchText = "",

            )
    }
}


