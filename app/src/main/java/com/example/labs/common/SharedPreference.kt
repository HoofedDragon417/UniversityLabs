package com.example.labs.common

import android.content.Context

private const val PREF_NAME = "coffee_machine"

private const val KEY_BEANS = "beans"
private const val KEY_WATER = "water"
private const val KEY_MILK = "milk"
private const val KEY_CASH = "cash"

class SharedPreference(ctx: Context) {
    private val data = ctx.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    fun saveCoffeeBeans(value: Int) = data.edit().putInt(KEY_BEANS, value).apply()

    fun getCoffeeBeans() = data.getInt(KEY_BEANS, 0)

    fun saveMilk(value: Int) = data.edit().putInt(KEY_MILK, value).apply()

    fun getMilk() = data.getInt(KEY_MILK, 0)

    fun saveWater(value: Int) = data.edit().putInt(KEY_WATER, value).apply()

    fun getWater() = data.getInt(KEY_WATER, 0)

    fun saveCash(value: Int) = data.edit().putInt(KEY_CASH, value).apply()

    fun getCash() = data.getInt(KEY_CASH, 0)
}