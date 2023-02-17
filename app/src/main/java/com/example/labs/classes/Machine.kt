package com.example.labs.classes

class Machine(var coffeeBeans: Int, var milk: Int, var water: Int, var cash: Int) {

    private fun subtractResources() {
        coffeeBeans -= 50
        water -= 100
    }

    fun makeCoffee(coffeeType: Coffees) {
        when (coffeeType) {
            Coffees.Espresso -> if ((coffeeBeans - 50 > 0) && (water - 100 > 0)) subtractResources() else return
            Coffees.Cappuccino -> return
        }
    }
}