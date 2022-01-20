package skrla.githubrestapi.repository

import androidx.lifecycle.LiveData
import kotlinx.coroutines.*
import skrla.githubrestapi.data.api.UserApi
import skrla.githubrestapi.data.models.DBGithubUser

object RepositoryUserApi {
    var job: CompletableJob? = null

    fun getUserInfo(username: String): LiveData<DBGithubUser> {
        job = Job()

        return object : LiveData<DBGithubUser>() {
            override fun onActive() {
                super.onActive()
                job?.let { theJob ->
                    CoroutineScope(Dispatchers.IO + theJob).launch {

                        //fetch data from web service here
                        val user = UserApi.retrofitUser.getUserInfo(username)
                        withContext(Dispatchers.Main) {
                            value = user
                            theJob.complete()
                        }
                    }
                }
            }
        }
    }

    fun cancelJob() {
        job?.cancel()
    }
}