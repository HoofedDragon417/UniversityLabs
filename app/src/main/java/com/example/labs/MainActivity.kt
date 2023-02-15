package com.example.labs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.androidx.AppNavigator

class MainActivity : AppCompatActivity() {

    /**
     *@param cicerone объявляет библиотеку навигации [Cicerone]
     * @param router используется для высокоуровневой навигации, выполняя необходимые переходы.
     * @param navigatorHolder используются для подключения [navigator] к Cicerone.
     * @param navigator используется для запуска activity или fragment.
     *
     **/
    private val cicerone = Cicerone.create()
    private val router get() = cicerone.router
    private val navigatorHolder get() = cicerone.getNavigatorHolder()
    private val navigator = AppNavigator(this, R.id.root_fragment_container)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        router.newRootScreen(Screens.Main())
    }

    override fun onResumeFragments() {
        navigatorHolder.setNavigator(navigator)
        super.onResumeFragments()
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }
}