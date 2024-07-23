package cats.domain

import cats.domain.usecase.GenerateNewCatUseCase
import cats.domain.usecase.GetCatUseCase
import org.koin.dsl.module

val domainModule = module {
    factory<GetCatUseCase> {
        GetCatUseCase(get())
    }

    factory<GenerateNewCatUseCase> {
        GenerateNewCatUseCase(get())
    }
}