package com.melchikov.mycityapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.melchikov.mycityapp.model.Category
import com.melchikov.mycityapp.model.Recommendation
import com.melchikov.mycityapp.repository.CityRepository

class CityViewModel : ViewModel() {
    private val repository = CityRepository

    val categories: List<Category> = repository.getCategories()

    fun getRecommendations(categoryId: Int): List<Recommendation> {
        return repository.getRecommendations(categoryId)
    }

    fun getRecommendation(id: Int): Recommendation? {
        return repository.getRecommendationById(id)
    }
}