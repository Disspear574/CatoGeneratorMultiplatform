package cats.data

import cats.data.remote.CatsApi
import cats.data.remote.CatsApiImpl
import cats.data.remote.httpClient
import cats.data.repository.CatRepositoryImpl
import cats.domain.repository.CatRepository
import io.ktor.client.HttpClient
import org.koin.dsl.module

val dataModule = module {
    single<HttpClient> {
        httpClient()
    }

    single<CatsApi> {
        CatsApiImpl(get())
    }

    single<CatRepository> {
        CatRepositoryImpl(get())
    }
}