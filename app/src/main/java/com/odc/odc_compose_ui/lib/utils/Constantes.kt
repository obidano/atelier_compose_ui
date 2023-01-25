package com.odc.odc_compose_ui.lib.utils

import android.annotation.SuppressLint
import com.odc.odc_compose_ui.models.ActivitesModel
import com.odc.odc_compose_ui.models.ArticlesModel
import java.text.SimpleDateFormat
import java.util.*

object Constantes {
    const val DATABASE_NAME = "DB"
    const val TB_TODO_NAME = "tb_dodo"
    const val TB_ACTIVITES = "tb_activites"
    const val TB_ARTICLES = "tb_articles"

    const val LIST_SCREEN = "list/{action}"
    const val TASK_SCREEN = "task/{taskId}"

    const val LIST_ARG_KEY = "action"
    const val TASK_ARG_KEY = "taskId"

    val FakeArticles = listOf<ArticlesModel>(
        ArticlesModel(id = 1, nom = "Lait", prixVente = 10.0)
    )

    @SuppressLint("SimpleDateFormat")
    val dateFormatter = SimpleDateFormat("dd-MM-yyyy HH:mm")

    val FakeActivites = listOf<ActivitesModel>(
        ActivitesModel(
            description = "Lorem Ipsum Achat",
            category = Categorie.Revenus,
            montant = 100.00,
            date = dateFormatter.format(Calendar.getInstance().time), // "13/01/2022 12:00",
            article = FakeArticles[0],
            quantite = 10
        )
    )

}