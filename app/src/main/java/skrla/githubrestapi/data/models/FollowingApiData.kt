package skrla.githubrestapi.data.models

import com.squareup.moshi.Json

data class FollowingApiData(
    @Json(name = "login") val username: String,
    @Json(name = "avatar_url") val profilePic: String?
)
