package com.odc.odc_compose_ui.lib.depot


import com.odc.odc_compose_ui.models.ActivitesModel
import com.odc.odc_compose_ui.lib.dao.ActivitesDao
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class ActivitesDepot @Inject constructor(private val query: ActivitesDao) {

    val getAllActivites = query.getAllData()
    fun filterActivitesByCat(cat:String) = query.filterByCategorie(cat)

    fun getSelectedActivites(rowId: Int) = query.getSelectedData(rowId)

    suspend fun addArticle(data: ActivitesModel) {
        query.add(data)
    }

    suspend fun updateArticle(data: ActivitesModel) {
        query.update(data)
    }

    suspend fun deleteArticle(data: ActivitesModel) {
        query.delete(data)
    }

    suspend fun deleteAllArticle() {
        query.deleteAll()
    }

    fun searchArticle(search: String) = query.search(search)
}