package uz.nurlibaydev.ecommerce.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 *  Created by Nurlibay Koshkinbaev on 07/11/2022 14:45
 */

@HiltAndroidApp
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        lateinit var instance: App
    }
}