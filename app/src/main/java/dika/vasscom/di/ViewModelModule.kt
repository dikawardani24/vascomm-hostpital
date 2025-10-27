package dika.vasscom.di

import dika.vasscom.ui.screens.home.HomeViewModel
import dika.vasscom.ui.screens.login.LoginViewModel
import dika.vasscom.ui.screens.register.RegisterViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

object ViewModelModule {
    fun get() = module {
        viewModelOf( ::LoginViewModel)
        viewModelOf(::RegisterViewModel )
        viewModelOf(::HomeViewModel)
    }
}