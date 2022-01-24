package skrla.githubrestapi.data.models

import com.squareup.moshi.Json

data class FollowersApiData(
    @Json(name = "login") val username: String,
    @Json(name = "avatar_url") val profilePic: String?
)
