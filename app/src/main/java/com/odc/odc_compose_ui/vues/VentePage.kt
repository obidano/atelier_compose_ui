@file:OptIn(ExperimentalMaterialApi::class)

package com.odc.odc_compose_ui.vues


import android.annotation.SuppressLint
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import androidx.navigation.NavHostController
import com.odc.odc_compose_ui.composants.*
import com.odc.odc_compose_ui.lib.utils.Categorie
import com.odc.odc_compose_ui.lib.utils.Constantes
import com.odc.odc_compose_ui.lib.utils.Constantes.dateFormatter
import com.odc.odc_compose_ui.lib.utils.Urls
import com.odc.odc_compose_ui.models.ActivitesModel
import com.odc.odc_compose_ui.models.ArticlesModel
import com.odc.odc_compose_ui.vue_models.SharedVueModel
import com.odc.odc_compose_ui.ui.theme.Odc_compose_uiTheme
import com.odc.odc_compose_ui.ui.theme.topAppBarBackGroundColor
import com.odc.odc_compose_ui.ui.theme.topAppBarContentColor
import java.util.*


@Composable
fun VentePage(navC: NavHostController, shareVM: SharedVueModel) {
    val allArticles = shareVM.allArticles.collectAsState().value

    val saveRevenuActivite = { data: ActivitesModel ->
        shareVM.saveActivite(data)
    }

    val naviguerVersHomePage = { ->
        navC.navigate(Urls.HomePage.name) {
            popUpTo(Urls.HomePage.name) {
                inclusive = true
            }
        }
    }

    val retourArriere: () -> Unit = {
        navC.popBackStack()
    }

    VenteBody(allArticles, naviguerVersHomePage, retourArriere, saveRevenuActivite)

}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
private fun VenteBody(
    allArticles: List<ArticlesModel>,
    naviguerVersHomePage: () -> Unit = {},
    retourArriere: () -> Unit = {},
    saveRevenuActivite: (ActivitesModel) -> Unit = {},
) {
    val context = LocalContext.current

    val articleSelectionne = remember {
        mutableStateOf<ArticlesModel?>(null)
    }

    val prixVente = remember {
        mutableStateOf(0.0)
    }

    val montant = remember {
        mutableStateOf(0.0)
    }

    val qte = remember {
        mutableStateOf(0)
    }

    val description = remember {
        mutableStateOf("")
    }

    LaunchedEffect(articleSelectionne.value) {
        prixVente.value = articleSelectionne.value?.prixVente ?: 0.0
    }

    LaunchedEffect(articleSelectionne.value, qte.value) {
        val pv = articleSelectionne.value?.prixVente ?: 0.0
        val q = qte.value
        if (pv > 0) {
            montant.value = q * pv
        }
    }



    Scaffold(topBar = { VenteAppBar(retourArriere) }) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {

            Box(Modifier.fillMaxHeight(0.9f).fillMaxWidth(), contentAlignment = Alignment.Center) {
                Text("Vente Page")
            }

            Button(
                onClick = {
                    if (articleSelectionne.value == null ||
                        qte.value <= 0
                        || description.value.isEmpty()
                    ) {
                        Toast.makeText(
                            context,
                            "Certains champs sont obligatoires",
                            Toast.LENGTH_SHORT
                        ).show()
                        return@Button
                    }

                    val newDAta = ActivitesModel(
                        description = description.value,
                        category = Categorie.Revenus,
                        article = articleSelectionne.value!!,
                        montant = montant.value,
                        quantite = qte.value,
                        date = dateFormatter.format(Calendar.getInstance().time)
                    )

                    saveRevenuActivite(newDAta)
                    naviguerVersHomePage()

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 1.dp, vertical = 30.dp)
            ) {
                Text("Enregistrer")
            }

        }
    }

}

@Composable
fun VenteAppBar(retourArriere: () -> Unit) {
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = { retourArriere() }) {
                Icon(
                    Icons.Default.Close,
                    "",
                    tint = MaterialTheme.colors.topAppBarContentColor
                )
            }
        },
        title = {
            Text(
                "Declaration Vente",
                color = MaterialTheme.colors.topAppBarContentColor
            )
        },
        elevation = 0.dp, backgroundColor = MaterialTheme.colors.topAppBarBackGroundColor,

        )
}


@Composable
@Preview(showBackground = true)
private fun PreviewVentePage() {
    Odc_compose_uiTheme {
        VenteBody(Constantes.FakeArticles)
    }
}

@Composable
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
private fun PreviewDarkVentePage() {
    Odc_compose_uiTheme {
        VenteBody(Constantes.FakeArticles)
    }
}


