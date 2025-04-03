package com.melchikov.tipseverydayapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.melchikov.tipseverydayapp.adapter.RecipeAdapter
import com.melchikov.tipseverydayapp.model.Recipe

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recipesRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val recipes = createRecipesList()
        val adapter = RecipeAdapter(recipes) { recipe ->
            showRecipeDetails(recipe)
        }
        recyclerView.adapter = adapter
    }

    private fun createRecipesList(): List<Recipe> {
        return listOf(
            Recipe(
                id = 1,
                day = 1,
                title = "Салат Цезарь",
                shortDescription = "Классический салат с куриной грудкой и сухариками",
                fullDescription = "1. Обжарьте куриную грудку до золотистой корочки\n2. Нарежьте листья салата романо\n3. Приготовьте соус из майонеза, чеснока и пармезана\n4. Соберите салат, добавив гренки и тертый сыр",
                imageResId = R.drawable.salat_cezar
            ),
            Recipe(
                id = 2,
                day = 2,
                title = "Торт 'Черепаха'",
                shortDescription = "Нежный бисквитный торт с карамельным кремом",
                fullDescription = "1. Приготовьте бисквитные коржи\n2. Сделайте крем из сгущенки и масла\n3. Соберите торт, формируя панцирь черепахи\n4. Украсьте грецкими орехами",
                imageResId = R.drawable.tort_cherepaha
            ),
            Recipe(
                id = 3,
                day = 3,
                title = "Бурито",
                shortDescription = "Мексиканская лепешка с мясной начинкой",
                fullDescription = "1. Обжарьте фарш с луком и специями\n2. Добавьте фасоль и кукурузу\n3. Заверните начинку в тортилью\n4. Подавайте с соусом сальса",
                imageResId = R.drawable.burito
            ),
            Recipe(
                id = 4,
                day = 4,
                title = "Салат 'Мимоза'",
                shortDescription = "Нежный слоеный рыбный салат",
                fullDescription = "1. Отварите картофель, морковь и яйца\n2. Разомните консервированную рыбу\n3. Выкладывайте слоями: рыба, овощи, яйца\n4. Каждый слой промажьте майонезом",
                imageResId = R.drawable.salat_mimoza
            ),
            Recipe(
                id = 5,
                day = 5,
                title = "Пасхальный кулич",
                shortDescription = "Традиционная пасхальная выпечка",
                fullDescription = "1. Приготовьте дрожжевое тесто с изюмом\n2. Выпекайте в высоких формах\n3. Покройте глазурью\n4. Украсьте цветной посыпкой",
                imageResId = R.drawable.kulich
            )
        )
    }

    private fun showRecipeDetails(recipe: Recipe) {
        val intent = Intent(this, RecipeDetailActivity::class.java).apply {
            putExtra("recipe", recipe)
        }
        startActivity(intent)
    }
}