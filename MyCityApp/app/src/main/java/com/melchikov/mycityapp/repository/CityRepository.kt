package com.melchikov.mycityapp.repository

import com.melchikov.mycityapp.R
import com.melchikov.mycityapp.model.Category
import com.melchikov.mycityapp.model.Recommendation

object CityRepository {
    private val categories = listOf(
        Category(1, "Кафе", R.drawable.ic_cafe),
        Category(2, "Рестораны", R.drawable.ic_restaurant),
        Category(3, "Парки", R.drawable.ic_park),
        Category(4, "Торговые центры", R.drawable.ic_mall)
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
            Recommendation(
                2,
                "Мамины блины",
                "Очень хорошее место чтобы перекусить в обед",
                R.drawable.cafe2,
                "ул. Максима Горького, 84",
                4.1f
            ),
            Recommendation(
                3,
                "Позимь",
                "В основном зале кафе, выдержанном в элегантном классическом стиле, действует линия самообслуживания с 11.00 до 22.00 (в теплое время года переносится на летнюю террасу)",
                R.drawable.cafe3,
                "ул. Владимира Краева, 35а",
                4.2f
            ),
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
            Recommendation(
                5,
                "Бобровая долина",
                "Ресторан «Бобровая долина» — это аутентичное место, выполненное в староудмуртском стиле. На территории ресторана есть небольшой пруд и летняя беседка.",
                R.drawable.rest2,
                "ул. Свердлова, 4",
                5.0f
            ),
            Recommendation(
                6,
                "Кипарис",
                "Ресторан «Кипарис» — это место, где вы можете насладиться уютной атмосферой, разнообразным меню и живой музыкой.",
                R.drawable.rest3,
                "ул. Владимира Краева, 45",
                4.6f
            ),
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
            Recommendation(
                8,
                "Парк им. М. Горького",
                "Шикарное место. Аттракционы на любой возраст, кафешки с разнообразным меню, красивая набережная с волшебной иллюминацией.",
                R.drawable.park2,
                "ул. Милиционная, 4",
                4.9f
            ),
            Recommendation(
                9,
                "Парк Космонавтов",
                "Парк культуры и отдыха «Парк Космонавтов» — это место, где можно провести время всей семьей.",
                R.drawable.park3,
                "ул. Воткинское ш., 118",
                4.4f
            ),
        ),
        4 to listOf(
            Recommendation(
                10,
                "Талисман",
                "Хороший торговый центр, уютный, удобное расположение, большая парковка. Все есть для хорошего отдыха. Удобно с детьми посещать",
                R.drawable.mall1,
                "ул. Холмогорова, 11",
                4.6f
            ),
            Recommendation(
                11,
                "Молл Матрица",
                "Торговый центр посещаю с разными целями: внизу Лента, правда иногда не хватает кассиров, и приходится стоять в очередях, вверху фитнес house: хороший большой спортзал, большой удобный раздевалки, отличный бассейн, в спа зоне отличный хамам, ещё три парных.",
                R.drawable.mall2,
                "ул. Баранова, 87",
                4.9f
            ),
            Recommendation(
                12,
                "Петровский",
                "Много классных магазинов.\n" +
                        "Хороший фут корт.\n" +
                        "Для детей КИДО.",
                R.drawable.mall3,
                "ул. Михаила Петрова, 29",
                4.9f
            ),
        )
    )

    fun getCategories(): List<Category> = categories
    fun getRecommendations(categoryId: Int): List<Recommendation> =
        recommendations[categoryId] ?: emptyList()

    fun getRecommendationById(id: Int): Recommendation? =
        recommendations.flatMap { it.value }.find { it.id == id }
}