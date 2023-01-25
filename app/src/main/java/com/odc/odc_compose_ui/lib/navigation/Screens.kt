package com.odc.odc_compose_ui.lib.navigation

import androidx.navigation.NavHostController
import com.odc.odc_compose_ui.lib.utils.Action
import com.odc.odc_compose_ui.lib.utils.Constantes

class Screens(navC: NavHostController) {

    val list: (Action) -> Unit = { action ->
        navC.navigate("list/${action.name}") {
            popUpTo(Constantes.LIST_SCREEN) { inclusive = true }
        }
    }

    val task: (Int) -> Unit = {
        navC.navigate("task/${it}")
    }


}