package skrla.githubrestapi.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import skrla.githubrestapi.data.api.UserApi
import skrla.githubrestapi.data.models.FollowersApiData
import skrla.githubrestapi.data.models.FollowingApiData
import skrla.githubrestapi.data.models.GitRepositoryApiData
import skrla.githubrestapi.data.models.GithubUserApiData
import skrla.githubrestapi.databinding.FragmentUserDataBinding


class UserViewModel : ViewModel() {

    private var _binding: FragmentUserDataBinding? = null
    private val binding get() = _binding!!

    private val _githubUserApiData: MutableLiveData<GithubUserApiData> =
        MutableLiveData<GithubUserApiData>()
    val githubUserApiData: MutableLiveData<GithubUserApiData> = _githubUserApiData


    private val _followersApi: MutableLiveData<List<FollowersApiData>> =
        MutableLiveData<List<FollowersApiData>>()
    val followersApi: LiveData<List<FollowersApiData>> = _followersApi

    private val _followingApi: MutableLiveData<List<FollowingApiData>> =
        MutableLiveData<List<FollowingApiData>>()
    val followingApi: LiveData<List<FollowingApiData>> = _followingApi

    private val _repositoryApi: MutableLiveData<List<GitRepositoryApiData>> =
        MutableLiveData<List<GitRepositoryApiData>>()
    val repositoryApi: LiveData<List<GitRepositoryApiData>> = _repositoryApi

    fun setUser(githubUser: String) {
        viewModelScope.launch {
            try {
                _githubUserApiData.value = UserApi.retrofitUser.getUserInfo(githubUser)
                _followersApi.value = UserApi.retrofitUser.getFollowersInfo(githubUser)
                _followingApi.value = UserApi.retrofitUser.getFollowingInfo(githubUser)
                _repositoryApi.value = UserApi.retrofitUser.getRepoInfo(githubUser)

            } catch (e: Exception) {

            }
        }
    }


}