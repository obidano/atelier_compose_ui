package com.odc.odc_compose_ui.composants


import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.odc.odc_compose_ui.composants.SelectField
import com.odc.odc_compose_ui.lib.utils.Constantes
import com.odc.odc_compose_ui.models.ArticlesModel
import com.odc.odc_compose_ui.models.SelectModel

@Composable
@Preview(showBackground = true)
fun ChampsArticle(
    articleSelectionne: MutableState<ArticlesModel?> = mutableStateOf(null),
    allArticles: List<ArticlesModel> = Constantes.FakeArticles,
) {

    SelectField(modifier = Modifier.padding(top = 30.dp),
        label = "Article",
        value = {
            val a = articleSelectionne.value?.id
            if (a != null) "$a" else ""
        },
        onValueChange = { newValue ->
            articleSelectionne.value =
                allArticles.find { it.id.toString().equals(newValue) }
        },
        options = allArticles.map { SelectModel(label = it.nom, value = "${it.id}") })

}