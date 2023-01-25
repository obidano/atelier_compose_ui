package com.odc.odc_compose_ui.lib.di

import android.content.Context
import androidx.room.Room
import com.odc.odc_compose_ui.lib.db.MyDatabase
import com.odc.odc_compose_ui.lib.utils.Constantes
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun providesDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, MyDatabase::class.java, Constantes.DATABASE_NAME).build()


    @Singleton
    @Provides
    fun provideArticleDao(database: MyDatabase) = database.articlesQueries()

    @Singleton
    @Provides
    fun provideActiviteDao(database: MyDatabase) = database.activitesQueries()

}