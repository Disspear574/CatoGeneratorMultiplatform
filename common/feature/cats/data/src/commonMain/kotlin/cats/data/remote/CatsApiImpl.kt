package cats.data.remote

import cats.data.remote.dto.CatDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.URLProtocol
import io.ktor.http.path

internal const val BASE_URL = "api.thecatapi.com"

class CatsApiImpl(
    private val httpClient: HttpClient
) : CatsApi {

    override suspend fun getRandomCat(): List<CatDto> {
        return httpClient.get {
            url {
                protocol = URLProtocol.HTTPS
                host = BASE_URL
                path("v1/images/search")
            }
        }.body()
    }
}