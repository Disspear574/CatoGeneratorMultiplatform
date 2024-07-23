package cats.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class CatDto(
    val height: Int,
    val id: String,
    val url: String,
    val width: Int
)