package com.melchikov.mycityapp.repository

import com.melchikov.mycityapp.R
import com.melchikov.mycityapp.model.Category
import com.melchikov.mycityapp.model.Recommendation

object CityRepository {
    private val categories = listOf(
        Category(1, "Кафе", R.drawable.ic_cafe),
        Category(2, "Рестораны", R.drawable.ic_restaurant),
        Category(3, "Парки", R.drawable.ic_park)
    )

    private val recommendations = mapOf(
        1 to listOf(
            Recommendation(
                1,
                "Кафе-пельменная \"Горячий Пельмень\"",
                "Уютное место с ароматным кофе",
                R.drawable.cafe1,
                "ул. Комунаров, 230",
                4.6f
            ),
            // другие кафе...
        ),
        2 to listOf(
            Recommendation(
                4,
                "Ресторан Pride",
                "Авторская кухня от шеф-повара",
                R.drawable.rest1,
                "Набережная им. И.Ф. Белобородова, 3",
                4.7f
            ),
            // другие рестораны...
        ),
        3 to listOf(
            Recommendation(
                7,
                "Парк Культуры и Отдыха имени Кирова",
                "Отличное место для прогулок",
                R.drawable.park1,
                "ул. Кирова, 8-а",
                4.6f
            ),
            // другие парки...
        )
    )

    fun getCategories(): List<Category> = categories
    fun getRecommendations(categoryId: Int): List<Recommendation> =
        recommendations[categoryId] ?: emptyList()

    fun getRecommendationById(id: Int): Recommendation? =
        recommendations.flatMap { it.value }.find { it.id == id }
}