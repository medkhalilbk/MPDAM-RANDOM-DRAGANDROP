package com.example.mpdam_random_dragandrop
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class MainViewModel :ViewModel() {

    var isCurrentlyDragging by mutableStateOf(false)
        private set

    var items by mutableStateOf(emptyList<NumberUi>())
        private set

    var addedPersons = mutableStateListOf<NumberUi>()
        private set

    init {
        items = listOf(
            NumberUi(Random.nextInt(1, 101),"2",Color.Green),
            NumberUi(Random.nextInt(1, 101),"3",Color.Blue),
            NumberUi(Random.nextInt(1, 101),"1",Color.Red),
            NumberUi(Random.nextInt(1, 101),"3",Color.Magenta),
            NumberUi(Random.nextInt(1, 101),"1",Color.Cyan),
        )
    }

    fun startDragging(){
        isCurrentlyDragging = true
    }
    fun stopDragging(){
        isCurrentlyDragging = false
    }
    fun isNumbersInOrder(numbers: List<NumberUi>): Boolean {
        var boolVal = true // Move the declaration outside the loop

        for (i in 0 until numbers.size - 1) {
            if (numbers[i].Value> numbers[i + 1].Value) {
                boolVal = false
                break // You can exit the loop early once you find a pair out of order
            }
        }

        return boolVal
    }

    fun addPerson(personUiItem: NumberUi){
        addedPersons.add(personUiItem)
        val itemToRemove = items.find { it.id == personUiItem.id }

        // Create a new list without the identified item
        val updatedItems = items.toMutableList()
        itemToRemove?.let { updatedItems.remove(it) }

        // Update the state with the new list
        items = updatedItems
        if(addedPersons.size == 5) {
          items = emptyList()
            println(isNumbersInOrder(addedPersons))
        }
    }

}