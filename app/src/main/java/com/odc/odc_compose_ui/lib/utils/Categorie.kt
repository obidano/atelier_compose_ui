package com.odc.odc_compose_ui.lib.utils

import androidx.compose.ui.graphics.Color
import com.odc.odc_compose_ui.ui.theme.AllActivitesColor
import com.odc.odc_compose_ui.ui.theme.DepensesColor
import com.odc.odc_compose_ui.ui.theme.RevenusColor

enum class Categorie(val color: Color, val display: String) {
    All(AllActivitesColor, "Tous"),
    Depenses(DepensesColor, "Depenses"),
    Revenus(RevenusColor, "Revenus"),
}