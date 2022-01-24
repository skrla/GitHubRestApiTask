package skrla.githubrestapi.data.models

import com.squareup.moshi.Json

data class GitRepositoryApiData(
    val name: String,
    val description: String?,
    @Json(name = "html_url") val gitUrl: String,
    val language: String?
)
