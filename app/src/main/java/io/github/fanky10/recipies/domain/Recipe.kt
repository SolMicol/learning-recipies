package io.github.fanky10.recipies.domain

data class Recipe (
    val name: String,
    val ingredients: List<Ingredient>,
    val steps: List<Step>,
    val mealType: String,
    val time: String,
    val portion: String,
    val imageRes: Int

)