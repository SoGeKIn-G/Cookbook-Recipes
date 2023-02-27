package com.gauravbora.recipeapp.data

import com.gauravbora.recipeapp.database.entities.main_category.MainCategoryItems
import com.gauravbora.recipeapp.pojo.onboarding.meal_details.MealDetails
import com.gauravbora.recipeapp.database.entities.sub_category.MealsItems
import retrofit2.http.GET
import retrofit2.http.Query

interface MainCategoryInterface {
    @GET("categories.php")
    suspend fun getCategoriesData(): MainCategoryItems

    @GET("filter.php")
    suspend fun filterCategoriesData(@Query("c") filterName: String): MealsItems

    @GET("lookup.php")
    suspend fun getMealDetailsData(@Query("i") idMeal: Int): MealDetails
}