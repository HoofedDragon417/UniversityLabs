package com.example.labs.common

import androidx.lifecycle.ViewModel
import com.github.terrakok.cicerone.Router

open class BaseVM : ViewModel() {
    private var routerNull: Router? = null
    val router get() = requireNotNull(routerNull)

    fun setRouter(router: Router) {
        routerNull = router
    }
}