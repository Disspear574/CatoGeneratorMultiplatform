package cats.domain.usecase

import cats.domain.repository.CatRepository

class GenerateNewCatUseCase(
    private val repository: CatRepository
) {
    suspend fun execute() = repository.generateNewCat()
}