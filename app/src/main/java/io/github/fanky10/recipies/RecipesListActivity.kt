package io.github.fanky10.recipies

import android.app.ListActivity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView
import io.github.fanky10.recipies.domain.Recipe


class RecipesListActivity : ListActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        listAdapter = RecipesAdapter(this)
    }

    private fun openRecipeDetail(idx: Int = 0) {
        val bundle = Bundle()
        bundle.putInt("SELECTED_RECIPE_IDX", idx)
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtras(bundle)
        startActivity(intent)
    }

    inner class RecipesAdapter : ArrayAdapter<Recipe> {

        constructor(ctx: Context) : super(ctx, 0, RecipiesRepository.recipes)

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val recipe = getItem(position)
            val newView: View = convertView ?: LayoutInflater.from(context).inflate(R.layout.recipe_item_list, parent, false)
            newView.findViewById<TextView>(R.id.listTittle).text = recipe?.name
            newView.findViewById<TextView>(R.id.listCookTime).text = recipe?.time
            newView.findViewById<TextView>(R.id.listMealType).text = recipe?.mealType
            newView.findViewById<TextView>(R.id.listPortions).text = recipe?.portion
            val button = newView.findViewById<Button>(R.id.btn_recipe)
            button.setOnClickListener {
                openRecipeDetail(position)
            }
            return newView
        }

    }
}
