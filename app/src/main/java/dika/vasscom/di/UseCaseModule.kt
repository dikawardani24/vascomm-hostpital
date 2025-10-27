package dika.vasscom.di

import dika.vasscom.core.domain.useCase.GetHealthInformationsUseCase
import dika.vasscom.core.domain.useCase.GetHealthServiceOfferUseCase
import dika.vasscom.core.domain.useCase.LoginUseCase
import dika.vasscom.core.domain.useCase.SaveTokenUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

object UseCaseModule {
    fun get() = module {
        factoryOf(::LoginUseCase)
        factoryOf(::GetHealthInformationsUseCase)
        factoryOf(::GetHealthServiceOfferUseCase)
        factoryOf(::SaveTokenUseCase)
    }
}