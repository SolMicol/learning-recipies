package io.github.fanky10.recipies

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import io.github.fanky10.recipies.domain.Recipe

class MainActivity : AppCompatActivity() {

    private val recipe: Recipe = RecipiesRepository.get()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.txtIngredientsList).text = getIngredientsContent()
        findViewById<TextView>(R.id.txtStepsList).text = getStepsContent()
        findViewById<Button>(R.id.btnEdit).setOnClickListener {
            editRecipe()
        }
    }

    override fun onResume() {
        super.onResume()
        findViewById<TextView>(R.id.txtTitle).text = recipe.name
    }

    private fun editRecipe() {
        startActivity(Intent(this, EditRecipeActivity::class.java))
    }

    private fun getIngredientsContent() = recipe.ingredients.map {
        "${it.quantity} ${it.name}\n"
    }.toString()

    private fun getStepsContent() = recipe.steps
        .sortedBy { it.order }
        .map {
            "(${it.order}) - ${it.description}\n"
        }.toString()
}