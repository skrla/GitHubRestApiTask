package skrla.githubrestapi.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import skrla.githubrestapi.data.models.DBGithubUser
import skrla.githubrestapi.repository.RepositoryUserApi

class UserViewModel : ViewModel() {

    private val _githubUser: MutableLiveData<String> = MutableLiveData()

    val githubUser: LiveData<DBGithubUser> = Transformations.switchMap(_githubUser) { username ->
        RepositoryUserApi.getUserInfo(username)

    }

    private val _username: MutableLiveData<String> = MutableLiveData()
    val username: LiveData<String> get() = _username

    private val _profilePic: MutableLiveData<String> = MutableLiveData()
    val profilePic: LiveData<String> get() = _profilePic

    private val _userGitApi: MutableLiveData<String> = MutableLiveData()
    val userGitApi: LiveData<String> get() = _userGitApi

    private val _followers: MutableLiveData<String> = MutableLiveData()
    val followers: LiveData<String> get() = _followers

    private val _following: MutableLiveData<String> = MutableLiveData()
    val following: LiveData<String> get() = _following

    private val _organizations: MutableLiveData<String> = MutableLiveData()
    val organizations: LiveData<String> get() = _organizations

    private val _repositories: MutableLiveData<String> = MutableLiveData()
    val repositories: LiveData<String> get() = _repositories

    private val _realName: MutableLiveData<String> = MutableLiveData()
    val realName: LiveData<String> get() = _realName

    private val _company: MutableLiveData<String> = MutableLiveData()
    val company: LiveData<String> get() = _company

    private val _location: MutableLiveData<String> = MutableLiveData()
    val location: LiveData<String> get() = _location

    private val _email: MutableLiveData<String> = MutableLiveData()
    val email: LiveData<String> get() = _email

    private val _hireable: MutableLiveData<Boolean> = MutableLiveData()
    val hireAble: LiveData<Boolean> get() = _hireable

    private val _bio: MutableLiveData<String> = MutableLiveData()
    val bio: LiveData<String> get() = _bio

    private val _numberOfFollowers: MutableLiveData<Int> = MutableLiveData()
    val numberOfFollowers: LiveData<Int> get() = _numberOfFollowers

    private val _numberOfFollowing: MutableLiveData<Int> = MutableLiveData()
    val numberOfFollowing: LiveData<Int> get() = _numberOfFollowing

    fun setUser(githubUser: String) {
        if (_githubUser.value == githubUser) {
            return
        }
        _githubUser.value = githubUser
    }
}