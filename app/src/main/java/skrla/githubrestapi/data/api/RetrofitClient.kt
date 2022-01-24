package skrla.githubrestapi.data.api

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import skrla.githubrestapi.data.models.FollowersApiData
import skrla.githubrestapi.data.models.FollowingApiData
import skrla.githubrestapi.data.models.GitRepositoryApiData
import skrla.githubrestapi.data.models.GithubUserApiData

private const val GIT_URL = "https://api.github.com"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(GIT_URL)
    .build()

interface GithubUserApi {
    @GET("/users/{username}")
    suspend fun getUserInfo(@Path("username") username: String): GithubUserApiData

    @GET("/users/{username}/repos")
    suspend fun getRepoInfo(@Path("username") username: String): List<GitRepositoryApiData>

    @GET("/users/{username}/followers")
    suspend fun getFollowersInfo(@Path("username") username: String): List<FollowersApiData>

    @GET("/users/{username}/following")
    suspend fun getFollowingInfo(@Path("username") username: String): List<FollowingApiData>
}

object UserApi {
    val retrofitUser: GithubUserApi by lazy { retrofit.create(GithubUserApi::class.java) }
}


