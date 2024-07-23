package cats.presentation

import org.koin.dsl.module

val presentationModule = module {
    single {
        CatsViewModel()
    }
}
