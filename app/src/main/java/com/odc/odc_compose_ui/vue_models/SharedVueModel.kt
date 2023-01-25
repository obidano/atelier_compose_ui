package com.odc.odc_compose_ui.vue_models

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.odc.odc_compose_ui.lib.utils.SearchAppBarState
import com.odc.odc_compose_ui.lib.depot.ActivitesDepot
import com.odc.odc_compose_ui.models.ActivitesModel
import com.odc.odc_compose_ui.models.ArticlesModel
import com.odc.odc_compose_ui.lib.depot.ArticlesDepot

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedVueModel @Inject constructor(
    private val articleDepot: ArticlesDepot,
    private val activityDepot: ActivitesDepot,
) : ViewModel() {

    private val _allArticles = MutableStateFlow<List<ArticlesModel>>(emptyList())
    val allArticles: StateFlow<List<ArticlesModel>> = _allArticles

    private val _allActivites = MutableStateFlow<List<ActivitesModel>>(emptyList())
    val allActivites: StateFlow<List<ActivitesModel>> = _allActivites

    private val _fitlerActivites = MutableStateFlow<List<ActivitesModel>>(emptyList())
    val fitlerActivites: StateFlow<List<ActivitesModel>> = _fitlerActivites

    val searchAppBarState = mutableStateOf<SearchAppBarState>(SearchAppBarState.Closed)
    val searchText = mutableStateOf("")
    val filterCategorie = mutableStateOf("")

    fun getAllArticles() {
        viewModelScope.launch {
            articleDepot.getAllArticle.collect {
                _allArticles.value = it
            }
        }
    }

    fun saveArticle(data: ArticlesModel) {
        viewModelScope.launch {
            articleDepot.addArticle(data)
        }
    }

    fun getAllActivites() {
        viewModelScope.launch {
            activityDepot.getAllActivites.collect {
                _allActivites.value = it
            }
        }
    }

    fun getFitlerActivitesByCat(cat: String) {
        viewModelScope.launch {
            activityDepot.filterActivitesByCat(cat).collect {
                _fitlerActivites.value = it
            }
        }
    }

    fun saveActivite(data: ActivitesModel) {
        viewModelScope.launch {
            activityDepot.addArticle(data)
        }
    }

}