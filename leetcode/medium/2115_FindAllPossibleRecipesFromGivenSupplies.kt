/*
    Array, Hash Table, String, Graph, Topological Sort
    2115. Find All Possible Recipes from Given Supplies
    https://leetcode.com/problems/find-all-possible-recipes-from-given-supplies/description/
 */

package leetcode.medium

import java.util.LinkedList

private fun findAllRecipes(recipes: Array<String>, ingredients: List<List<String>>, supplies: Array<String>): List<String> {
    val supps = supplies.toMutableSet()
    val recipeToIndex = recipes.withIndex().associate { it.value to it.index }
    val dependecies = mutableMapOf<String, MutableSet<String>>()
    val depsCount = IntArray(recipes.size)
    val res = mutableListOf<String>()

    for (i in ingredients.indices) {
        for (ingredient in ingredients[i]) {
            if (ingredient !in supps) {
                dependecies.computeIfAbsent(ingredient) { mutableSetOf() }.add(recipes[i])
                ++depsCount[i]
            }
        }
    }

    val queue = LinkedList(depsCount.indices.filter { depsCount[it] == 0 })
    while (queue.isNotEmpty()) {
        val recipeIndex = queue.poll()
        val recipe = recipes[recipeIndex]
        res.add(recipe)

        for (ingridient in dependecies.getOrDefault(recipe, emptySet())) {
            if (--depsCount[recipeToIndex[ingridient]!!] == 0)
                queue.add(recipeToIndex[ingridient]!!)
        }
    }

    return res
}

fun main() {
    val recipes = arrayOf("bread","sandwich","burger")
    val ingredients = listOf(listOf("yeast","flour"),listOf("bread","meat"),listOf("sandwich","meat","bread"))
    val supplies = arrayOf("yeast","flour","meat")

    println(findAllRecipes(recipes, ingredients, supplies))
}
