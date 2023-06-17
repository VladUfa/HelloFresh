package com.example.hellofresh.data

/**
 * Data class that represents the current UI state
 */
data class UiState(
    /** Selected recipe */
    val selectedRecipe: Recipe = Recipe(name = "")
)

/**
 * This data class defines recipe from JSON.
 */
data class Recipe(
    val name: String,
    val headline: String = "",
    val description: String = "",
    val calories: String = "0 kcal",
    val carbos: String = "0g",
    val fats: String = "0g",
    val proteins: String = "0g",
    val difficulty: Int = 0,
    val id: String = "",
    val image: String = "",
    val thumb: String = "",
    val time: String = "PT35MIN"
)

/**
 * Test instances of Recipe and List<Recipe> used for preview purpose
 */
val testRecipe = Recipe(
    name = "Marvelous deer tails",
    headline = "with something special",
    description = "Experience the exquisite blend of tender deer tails infused with aromatic herbs, including rosemary and thyme. This dish boasts a hidden surprise—a pocket of melted truffle butter within each tail, creating a decadent harmony of flavors. Served atop silky cauliflower puree and garnished with microgreens and a wild berry reduction, the Marvelous Deer Tails with Something Special is a culinary masterpiece that tantalizes the senses.",
    carbos = "15 g",
    fats = "90 g",
    proteins = "7 g",
    difficulty = 2,
    time = "PT90MIN",
    id = "0",
    calories = "178 kcal",
    image = "https://img.hellofresh.com/f_auto,q_auto/hellofresh_s3/image/533143aaff604d567f8b4571.jpg",
    thumb = "https://img.hellofresh.com/f_auto,q_auto,w_300/hellofresh_s3/image/53314276ff604d28828b456b.jpg"
)

val testDataList =
    listOf(
        Recipe(name = "Crispy Fish Goujons", image = "https://img.hellofresh.com/f_auto,q_auto/hellofresh_s3/image/533143aaff604d567f8b4571.jpg", thumb = "https://img.hellofresh.com/f_auto,q_auto,w_300/hellofresh_s3/image/53314276ff604d28828b456b.jpg", headline = "with Sweet Potato Wedges and Minted Snap Peas", description = "There’s nothing like the simple things in life - the smell of freshly cut grass, sitting outside on a nice sunny day, spending time with friends and family. Well here is a recipe that delivers simple culinary pleasures - some nice fresh fish with a crispy crust, crunchy potato wedges and some delightfully sweet sugar snap peas flavoured with cooling mint. Slip into something comfortable and relax into a delicious dinner!"),
        Recipe(name = "Moroccan Skirt Steak", difficulty = 1, headline = "with Roasted Rocket Potatoes", description = "Nostalgia is a powerful thing. For some it\\u2019s triggered by the smell of freshly cut grass, for others by the sound of a love song from their heady teenage years. For Head Chef Patrick it\\u2019s all about Swiss Roll. A firm dinnertime favourite from his primary school years, we still see him go all misty eyed at the mere mention of it. We\\u2019re pretty sure that was the inspiration behind this little number. Tonight, prepare to create a little nostalgia that the little \\u2018uns will remember for years!"),
        testRecipe
    )