package com.odc.odc_compose_ui.composants


import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.odc.odc_compose_ui.models.ArticlesModel
import com.odc.odc_compose_ui.ui.theme.rowTextColor
import com.odc.odc_compose_ui.ui.theme.topAppBarContentColor

@Composable
@Preview
fun AddArticleButtonVue(ajouterArticle: (ArticlesModel) -> Unit={}) {
    val open = remember {
        mutableStateOf(false)
    }
    TextButton(onClick = { open.value = true }) {
        Icon(Icons.Filled.Add, "", tint = MaterialTheme.colors.topAppBarContentColor)
        Spacer(modifier = Modifier.width(5.dp))
        Text("Ne pas Créer", color = MaterialTheme.colors.topAppBarContentColor)
    }

    if (open.value)
        FormulaireArticleDialog(onClose = { open.value = false }, ajouterArticle)

}

@Composable
@Preview(showBackground = true)
fun FormulaireArticleDialog(
    onClose: () -> Unit = {},
    ajouterArticle: (ArticlesModel) -> Unit = {},
) {
    val nom = remember {
        mutableStateOf("")
    }
    val prixVente = remember {
        mutableStateOf("1")
    }
    val context = LocalContext.current


    Dialog(onDismissRequest = { }
    ) {
        Card() {
            Column(
                Modifier
                    .fillMaxWidth()
                    .scrollable(rememberScrollState(), Orientation.Vertical),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                Text("Formulaire Article")

                ChampsNomArticle(nom)

                ChampsPrixVenteArticle(prixVente)

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 20.dp, bottom = 20.dp)
                ) {

                    Button(onClick = { onClose() }) {
                        Text("Annuler")
                    }
                    Spacer(modifier = Modifier.width(15.dp))

                    Button(onClick = {
                        if (nom.value.isEmpty() || prixVente.value.isEmpty() || prixVente.value.toDoubleOrNull() == null) {
                            Toast.makeText(
                                context,
                                "Certains champs sont obligatoires",
                                Toast.LENGTH_SHORT
                            ).show()
                            return@Button
                        }
                        val newData =
                            ArticlesModel(nom = nom.value, prixVente = prixVente.value.toDouble())
                        Log.d("FORM", "FormulaireArticleDialog: $newData")
                        onClose()
                        ajouterArticle(newData)
                    }) {
                        Text("Ajouter")
                    }
                }
            }

        }
    }


}


@Composable
private fun ChampsNomArticle(nom: MutableState<String>) {
    val focusRequester = FocusRequester()

    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }

    TextField(modifier = Modifier
        .padding(top = 50.dp)
        .focusRequester(focusRequester),
        value = nom.value,
        onValueChange = { nom.value = it },
        label = {
            Text("Nom", color = MaterialTheme.colors.rowTextColor)
        })
}


@Composable
private fun ChampsPrixVenteArticle(prixVente: MutableState<String>) {
    TextField(modifier = Modifier.padding(top = 20.dp, bottom = 50.dp),
        value = prixVente.value,
        onValueChange = { prixVente.value = it },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        label = {
            Text("Prix de Vente", color = MaterialTheme.colors.rowTextColor)
        })
}