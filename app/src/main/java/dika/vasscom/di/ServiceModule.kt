package dika.vasscom.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dika.vasscom.core.domain.repository.AuthRepository
import dika.vasscom.core.domain.repository.impl.AuthRepositoryImpl
import dika.vasscom.core.domain.useCase.LoginUseCase
import dika.vasscom.core.network.AuthService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ServiceModule {

    private fun provideClient(): Retrofit {
        val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        return Retrofit.Builder()
            .baseUrl("https://reqres.in/api/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(client)
            .build()
    }

    fun get() = module {
        single<Retrofit> { provideClient() }
        single<AuthService> { get<Retrofit>().create(AuthService::class.java) }
    }
}