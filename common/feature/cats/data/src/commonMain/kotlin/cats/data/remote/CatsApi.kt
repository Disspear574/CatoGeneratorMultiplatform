package cats.data.remote

import cats.data.remote.dto.CatDto

interface CatsApi {
    suspend fun getRandomCat(): List<CatDto>
}