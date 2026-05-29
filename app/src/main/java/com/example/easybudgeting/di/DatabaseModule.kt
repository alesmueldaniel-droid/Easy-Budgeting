package com.example.easybudgeting.di

import android.content.Context
import androidx.room.Room
import com.example.easybudgeting.data.database.BudgetDao
import com.example.easybudgeting.data.database.ExpenseDao
import com.example.easybudgeting.data.database.ExpenseDatabase
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
    fun provideExpenseDatabase(
        @ApplicationContext context: Context
    ): ExpenseDatabase {
        return Room.databaseBuilder(
            context,
            ExpenseDatabase::class.java,
            "easy_budgeting_db"
        ).build()
    }

    @Singleton
    @Provides
    fun provideExpenseDao(database: ExpenseDatabase): ExpenseDao {
        return database.expenseDao()
    }

    @Singleton
    @Provides
    fun provideBudgetDao(database: ExpenseDatabase): BudgetDao {
        return database.budgetDao()
    }
}
