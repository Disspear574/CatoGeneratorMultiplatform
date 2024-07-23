package di

import cats.data.dataModule
import cats.domain.domainModule
import cats.presentation.CatsViewModel
import cats.presentation.PlaySound
import cats.presentation.presentationModule
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.core.logger.Logger
import org.koin.dsl.module

class KoinInjector(playSound: PlaySound) {
    val mod = module {
        single<PlaySound> {
            playSound
        }
    }
    val koinApp = startKoin {
        printLogger()
        loadKoinModules(
            listOf(
                dataModule,
                domainModule,
                presentationModule,
                mod
            )
        )
    }
    val koin = koinApp.koin

    val catsViewModel = koin.get<CatsViewModel>()
}
