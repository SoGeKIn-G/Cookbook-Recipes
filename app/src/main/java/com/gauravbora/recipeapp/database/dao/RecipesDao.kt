package com.gauravbora.recipeapp.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.gauravbora.recipeapp.database.entities.main_category.Category
import com.gauravbora.recipeapp.database.entities.sub_category.Meal
import com.gauravbora.recipeapp.pojo.onboarding.meal_details.MealData


@Dao
interface RecipesDao {

    //Category
    @get:Query("SELECT * FROM category ORDER BY id DESC")
    val getAllCategory:List<Category>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategory(category: Category)
    @Query("DELETE  FROM category")
    suspend fun clearCategoryDatabase()

    //Meals
    @get:Query("SELECT * FROM meal ORDER BY id DESC")
    val getAllMeals:List<Meal>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMeal(mealsItems: Meal)
    @Query("DELETE  FROM meal")
    suspend fun clearMealDatabase()
    @Query("SELECT * FROM meal WHERE categoryName =:category ORDER BY id DESC")
    suspend fun getCategoryMeals(category: String):List<Meal>

    //MealDetails
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMealDetails(mealDetails: MealData)
    @Query("SELECT * FROM meal_details WHERE idMeal =:idMeal")
    suspend fun getMealDetails(idMeal: String): MealData
    @Query("DELETE  FROM meal_details")
    suspend fun clearMealDetailsDatabase()

}