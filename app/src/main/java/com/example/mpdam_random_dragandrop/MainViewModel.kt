package com.example.mpdam_random_dragandrop
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel

class MainViewModel :ViewModel() {

    var isCurrentlyDragging by mutableStateOf(false)
        private set

    var items by mutableStateOf(emptyList<NumberUi>())
        private set

    var addedPersons = mutableStateListOf<NumberUi>()
        private set

    init {
        items = listOf(
            NumberUi(1,"2",Color.Green),
            NumberUi(2,"3",Color.Blue),
            NumberUi(4,"1",Color.Red),
            NumberUi(5,"3",Color.Magenta),
            NumberUi(3,"1",Color.Cyan),
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
        if(addedPersons.size == 5) {
          items = emptyList()
            println(isNumbersInOrder(addedPersons))
        }
    }

}