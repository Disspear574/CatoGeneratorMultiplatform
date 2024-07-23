package cats.domain.usecase

import cats.domain.model.CatModel
import cats.domain.repository.CatRepository

class GetCatUseCase(
    private val repository: CatRepository
) {
    suspend fun execute(): CatModel = repository.getRandomCat()
}