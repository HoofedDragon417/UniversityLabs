package com.example.labs.classes

class Machine(var coffeeBeans: Int = 0, var milk: Int = 0, var water: Int = 0, var cash: Int = 0) {

    private fun subtractResources() {
        coffeeBeans -= 50
        water -= 100
    }

    fun makeCoffee(coffeeType: Coffees) {
        when (coffeeType) {
            Coffees.Espresso -> if ((coffeeBeans - 50 >= 0) && (water - 100 >= 0)) subtractResources() else return
            Coffees.Cappuccino -> return
        }
    }
}