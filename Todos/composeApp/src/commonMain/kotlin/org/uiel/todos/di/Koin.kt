package org.uiel.todos.di

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.context.startKoin
import org.koin.dsl.module
import org.uiel.todos.HomeViewModel
import org.uiel.todos.NetworkRepository
import org.uiel.todos.data.KtorTodosApi

val provideClientModule = module {
    single {
        HttpClient {
            install(ContentNegotiation) {
                json(json = Json { ignoreUnknownKeys = true }, contentType = ContentType.Any)
            }
        }
    }
}

val provideRepositoryModule = module {
    factory { NetworkRepository(get()) }
}

val provideApiModule = module {
    factory { KtorTodosApi(get()) }
}

val provideViewModelModule = module {
    factory {
        HomeViewModel(get())
    }
}

fun appModule() = listOf(provideClientModule, provideRepositoryModule, provideViewModelModule, provideApiModule)

fun initKoin() {
    startKoin {
        modules(appModule())
    }
}