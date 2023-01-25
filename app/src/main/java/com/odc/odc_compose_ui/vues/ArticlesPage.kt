package com.odc.odc_compose_ui.vues

import android.annotation.SuppressLint
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
import com.odc.odc_compose_ui.lib.utils.Constantes
import com.odc.odc_compose_ui.models.ArticlesModel
import com.odc.odc_compose_ui.ui.theme.Odc_compose_uiTheme
import com.odc.odc_compose_ui.ui.theme.topAppBarBackGroundColor
import com.odc.odc_compose_ui.ui.theme.topAppBarContentColor
import com.odc.odc_compose_ui.vue_models.SharedVueModel


@Composable
fun ArticlesPage(navC: NavHostController, shareVM: SharedVueModel) {
    val allArticles by shareVM.allArticles.collectAsState()

    val retourArriere: () -> Unit = {
        navC.popBackStack()
    }

    val ajouterArticle = { data: ArticlesModel ->
        shareVM.saveArticle(data)
    }

    ArticlesBody(allArticles, retourArriere, ajouterArticle)

}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
private fun ArticlesBody(
    allArticles: List<ArticlesModel>,
    retourArriere: () -> Unit = {},
    ajouterArticle: (ArticlesModel) -> Unit = {},
) {
    val context = LocalContext.current
    Scaffold(topBar = { ArticleAppBar(allArticles, retourArriere, ajouterArticle) }) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {

            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("Articles Page")
            }
        }
    }

}

@Composable
fun ArticleAppBar(
    allArticles: List<ArticlesModel>,
    retourArriere: () -> Unit,
    ajouterArticle: (ArticlesModel) -> Unit,
) {
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
                "Articles (000)",
                color = MaterialTheme.colors.topAppBarContentColor
            )
        },
        elevation = 0.dp, backgroundColor = MaterialTheme.colors.topAppBarBackGroundColor,
        actions = {

        }
    )
}





@Composable
@Preview(showBackground = true)
private fun PreviewArticlesPage() {
    Odc_compose_uiTheme {
        ArticlesBody(Constantes.FakeArticles)
    }
}


