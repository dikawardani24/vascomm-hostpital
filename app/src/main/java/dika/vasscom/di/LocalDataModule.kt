package dika.vasscom.di

import dika.vasscom.core.local.UserPreference
import dika.vasscom.core.local.impl.UserPreferenceImpl
import org.koin.dsl.module

object LocalDataModule {
    fun get() = module {
        single<UserPreference> { UserPreferenceImpl(get()) }
    }
}