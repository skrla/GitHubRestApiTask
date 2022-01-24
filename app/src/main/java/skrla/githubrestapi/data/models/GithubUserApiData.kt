package skrla.githubrestapi.data.models

import com.squareup.moshi.Json

data class GithubUserApiData(
    @Json(name = "login") val username: String,
    @Json(name = "avatar_url") val profilePic: String?,
    @Json(name = "followers_url") val followers: String,
    @Json(name = "following_url") val following: String,
    @Json(name = "repos_url") val repositories: String,
    @Json(name = "name") val realName: String?,
    @Json(name = "company") val company: String?,
    @Json(name = "location") val location: String?,
    @Json(name = "email") val email: String?,
    @Json(name = "bio") val bio: String?,
    @Json(name = "followers") val numberOfFollowers: Int,
    @Json(name = "following") val numberOfFollowing: Int
)

