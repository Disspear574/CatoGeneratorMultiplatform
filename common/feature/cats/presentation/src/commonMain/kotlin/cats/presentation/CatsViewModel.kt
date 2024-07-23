package cats.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cats.domain.usecase.GenerateNewCatUseCase
import cats.domain.usecase.GetCatUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class CatsViewModel: ViewModel(), KoinComponent {
    private val getCatUseCase: GetCatUseCase by inject()
    private val generateNewCatUseCase: GenerateNewCatUseCase by inject()
    val playSound: PlaySound by inject()

    private val _state = MutableStateFlow(CatsState())
    val state: StateFlow<CatsState> = _state

    init {
        getCats()
    }

    private fun getCats() {
        viewModelScope.launch {

            try {
                val result = getCatUseCase.execute()
                if (result.image.isNotEmpty()) {
                    _state.update { it.copy(cat = result) }
                }
            } catch (e: Exception) {
                val error = e.message
                _state.update {
                    it.copy(error = "Exception : $error, \n Проверьте подключение к интернету")
                }
            }

        }
    }

    fun generateNewCat() {
        viewModelScope.launch {
            try {
                generateNewCatUseCase.execute()
                getCats()
            } catch (_: Exception) {
            }
            println(playSound)

        }
    }
}
