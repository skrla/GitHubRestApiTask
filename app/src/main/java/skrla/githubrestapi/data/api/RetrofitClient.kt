package skrla.githubrestapi.data.api

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import skrla.githubrestapi.data.GithubUserApi

private const val GIT_URL = "https://api.github.com/users/"

private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(GIT_URL)
        .build()

object UserApi {
        val retrofitUser: GithubUserApi by lazy { retrofit.create(GithubUserApi::class.java) }
    }
