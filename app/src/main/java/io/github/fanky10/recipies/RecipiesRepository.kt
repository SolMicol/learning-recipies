package io.github.fanky10.recipies

import io.github.fanky10.recipies.domain.Ingredient
import io.github.fanky10.recipies.domain.Recipe
import io.github.fanky10.recipies.domain.Step

object RecipiesRepository {
    // from: https://cookpad.com/eeuu/recetas/5999222-chuletas-de-cerdo-con-papas-y-romero-al-horno
    private var n: Int = 0
    var recipes = mutableListOf(
            Recipe(
            "Chuletas de cerdo con papas y romero al horno",
            listOf(
                    Ingredient("chuletas de cerdo", "4"),
                    Ingredient("papas", "2"),
                    Ingredient("cebolla", "1"),
                    Ingredient("sal y pimienta", "a gusto"),
                    Ingredient("romero", "a gusto"),
                    Ingredient("salsa de soja", "1 chorrito"),
                    Ingredient("aceite de oliva", "1 chorrito")
            ),
            listOf(
                    Step(
                            1, "Precalentar el horno. En un bol marinar las chuletas con la sal, pimienta, ajo en polvo, la mitad del romero, aceite de oliva y la salsa de soja"
                    ),
                    Step(
                            2, "En una fuente colocamos la papa cortada en rodajas y la cebolla cortada en julianas. Todo condimentado con sal, pimienta, la mitad del romero y aceite de oliva. Mezclar bien"
                    ),
                    Step(
                            3, "Añadir las chuletas encima de las papas y llevar al horno a fuego medio. A media cocción (aprox unos 15 min) sacar y dar vuelta a las chuletas y dejar 15 min más"
                    )
            ),
                    "Cena y almuerzo", "1 hora", "5 porciones.", R.drawable.chops
    ),
            Recipe(
            "Choco caliente",
            listOf(
                    Ingredient("Chocolate Nesquick™", "2 cucharadas"),
                    Ingredient("Leche", "200ml"),
                    Ingredient("Azúcar", "A gusto")
            ),
            listOf(
                    Step(
                            1, "Colocar la leche en un recipiente y calentar a gusto."
                    ),
                    Step(
                            2, "En una taza, agregar 2 cucharadas de chocolate Nesquick™."
                    ),
                    Step(
                            3, "Cuando la leche esté caliente, ir vertiendo con cuidado mientras se mezcla evitando grumos."
                    ),
                    Step(
                            4, "Colocar azúcar si se desea."
                            )
            ), "Desayuno y merienda", "1 minuto", "1 porción", R.drawable.chocolatada
    ),
            Recipe(
                    "Tamagoyaki",
            listOf(
                    Ingredient("Huevos", "2"),
                    Ingredient("Salsa de soja", "Un chorrito"),
                    Ingredient("Azúcar", "A gusto"),
                    Ingredient("Aceite", "Un chorrito")
            ),
            listOf(
                    Step(
                            1, "Romper y colocar los 2 huevos en un recipiente."
                    ),
                    Step(
                            2, "Agregar azúcar a gusto y mezclar bien."
                    ),
                    Step(
                            3, "Echar un chorrito de salsa de soja y terminar de mezclar"
                    ),
                    Step(
                            4, "Colocar aceite en un sartén y cocinar la mezcla."
                    )
            ), "Almuerzo y cena", "30 minutos", "4 porciones.", R.drawable.tamagoyaki
    )
    )

    fun setRecipe(r: Int) {
        n = r
    }

    fun get() = recipes[n]

    fun saveAll(name: String, ing: Ingredient, step: Step) {
        recipes[n] = Recipe(name,
                recipes[n].ingredients,
                recipes[n].steps, recipes[n].mealType, recipes[n].time, recipes[n].portion, recipes[n].imageRes
        )
        recipes[n].ingredients.toMutableList()[0] = ing
        recipes[n].steps.toMutableList()[0] = step
    }

    fun getRecipesNames() : List<String> = listOf(
        "Chuletas de cerdo con papas y romero al horno",
        "Choco caliente",
        "Tamagoyaki"
    )
}