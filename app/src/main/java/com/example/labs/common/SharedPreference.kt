package com.example.labs.common

import android.content.Context
import com.example.labs.classes.Machine

private const val PREF_NAME = "coffee_machine"

private const val KEY_BEANS = "beans"
private const val KEY_WATER = "water"
private const val KEY_MILK = "milk"
private const val KEY_CASH = "cash"

class SharedPreference(ctx: Context) {
    private val data = ctx.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    fun saveMachine(machine: Machine) {
        saveCoffeeBeans(machine.coffeeBeans)
        saveCash(machine.cash)
        saveMilk(machine.milk)
        saveWater(machine.water)
    }

    fun getMachine() = Machine(
        getCoffeeBeans(), getMilk(), getWater(), getCash()
    )

    private fun saveCoffeeBeans(value: Int) = data.edit().putInt(KEY_BEANS, value).apply()

    private fun getCoffeeBeans() = data.getInt(KEY_BEANS, 0)

    private fun saveMilk(value: Int) = data.edit().putInt(KEY_MILK, value).apply()

    private fun getMilk() = data.getInt(KEY_MILK, 0)

    private fun saveWater(value: Int) = data.edit().putInt(KEY_WATER, value).apply()

    private fun getWater() = data.getInt(KEY_WATER, 0)

    private fun saveCash(value: Int) = data.edit().putInt(KEY_CASH, value).apply()

    private fun getCash() = data.getInt(KEY_CASH, 0)
}