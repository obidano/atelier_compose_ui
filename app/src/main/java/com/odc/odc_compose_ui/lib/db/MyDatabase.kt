package com.odc.odc_compose_ui.lib.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.odc.odc_compose_ui.models.ActivitesModel
import com.odc.odc_compose_ui.models.ArticlesModel
import com.odc.odc_compose_ui.models.TodoModel
import com.odc.odc_compose_ui.lib.dao.ActivitesDao
import com.odc.odc_compose_ui.lib.dao.ArticlesDao

@Database(
    entities = [ArticlesModel::class, ActivitesModel::class],
    version = 4,
    exportSchema = false
)
@TypeConverters(RoomConverters::class)
abstract class MyDatabase : RoomDatabase() {

    abstract fun articlesQueries(): ArticlesDao
    abstract fun activitesQueries(): ActivitesDao

}