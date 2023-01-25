package com.odc.odc_compose_ui.lib.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.odc.odc_compose_ui.models.ArticlesModel

class RoomConverters {
    @TypeConverter
    fun convertArticleToString(data: ArticlesModel): String {
        return Gson().toJson(data, ArticlesModel::class.java)
    }

    @TypeConverter
    fun convertStringToArticle(data: String): ArticlesModel {
        return Gson().fromJson(data, ArticlesModel::class.java)
    }
}