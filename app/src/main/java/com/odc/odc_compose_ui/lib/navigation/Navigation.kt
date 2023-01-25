package com.odc.odc_compose_ui.lib.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.odc.odc_compose_ui.lib.navigation.Screens
import com.odc.odc_compose_ui.vues.*
import com.odc.odc_compose_ui.lib.utils.Urls
import com.odc.odc_compose_ui.vue_models.SharedVueModel
import com.odc.odc_compose_ui.vues.AchatPage

/*fun NavGraphBuilder.listComposable(navToTaskScreen: (Int) -> Unit) {
    composable(
        route = LIST_SCREEN,
        arguments = listOf(navArgument(LIST_ARG_KEY) {
            type = NavType.StringType
        })
    ) {

    }
}*/

@Composable
fun Navigation(navC: NavHostController, shareVM: SharedVueModel) {

    val screen = remember(navC) {
        Screens(navC)
    }

    LaunchedEffect(Unit) {
        shareVM.getAllActivites()
        shareVM.getAllArticles()
    }

    NavHost(navController = navC, startDestination = Urls.IntroPage.name) {

        composable(Urls.IntroPage.name) {
            IntroPage(navC)
        }

        composable(Urls.HomePage.name) {
            HomePage(navC, shareVM)
        }

        composable(Urls.TypeOperationsPage.name) {
            TypesOperationPage(navC)
        }

        composable(Urls.ArticlesPage.name) {
            ArticlesPage(navC, shareVM)
        }

        composable(Urls.AchatPage.name) {
            VentePage(navC, shareVM)
        }

        composable(Urls.VentePage.name) {
            AchatPage(navC, shareVM)

        }


    }

}