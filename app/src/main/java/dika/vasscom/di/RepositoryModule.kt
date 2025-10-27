package dika.vasscom.di

import dika.vasscom.core.domain.repository.AuthRepository
import dika.vasscom.core.domain.repository.HospitalRepository
import dika.vasscom.core.domain.repository.impl.AuthRepositoryImpl
import dika.vasscom.core.domain.repository.impl.HospitalRepositoryImpl
import org.koin.dsl.module

object RepositoryModule {
    fun get() = module {
        single<AuthRepository> { AuthRepositoryImpl(get()) }
        single<HospitalRepository> { HospitalRepositoryImpl() }
    }
}