package skrla.githubrestapi.data

import retrofit2.http.GET
import retrofit2.http.Path
import skrla.githubrestapi.data.models.DBGithubUser

interface GithubUserApi {
    @GET("{username}")
    suspend fun getUserInfo(@Path("username") username: String): DBGithubUser
}
