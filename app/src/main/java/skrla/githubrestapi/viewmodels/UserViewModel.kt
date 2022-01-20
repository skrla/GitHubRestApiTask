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

    val _username: MutableLiveData<String> = MutableLiveData()
    private val username: LiveData<String> get() = _username

    val _profilePic: MutableLiveData<String> = MutableLiveData()
    private val profilePic: LiveData<String> get() = _profilePic

    val _userGitApi: MutableLiveData<String> = MutableLiveData()
    private val userGitApi: LiveData<String> get() = _userGitApi

    val _followers: MutableLiveData<String> = MutableLiveData()
    private val followers: LiveData<String> get() = _followers

    val _following: MutableLiveData<String> = MutableLiveData()
    private val following: LiveData<String> get() = _following

    val _organizations: MutableLiveData<String> = MutableLiveData()
    private val organizations: LiveData<String> get() = _organizations

    val _repositories: MutableLiveData<String> = MutableLiveData()
    private val repositories: LiveData<String> get() = _repositories

    val _realName: MutableLiveData<String> = MutableLiveData()
    private val realName: LiveData<String> get() = _realName

    val _company: MutableLiveData<String> = MutableLiveData()
    private val company: LiveData<String> get() = _company

    val _location: MutableLiveData<String> = MutableLiveData()
    private val location: LiveData<String> get() = _location

    val _email: MutableLiveData<String> = MutableLiveData()
    private val email: LiveData<String> get() = _email

    val _hireable: MutableLiveData<Boolean> = MutableLiveData()
    private val hireAble: LiveData<Boolean> get() = _hireable

    val _bio: MutableLiveData<String> = MutableLiveData()
    private val bio: LiveData<String> get() = _bio

    val _numberOfFollowers: MutableLiveData<Int> = MutableLiveData()
    private val numberOfFollowers: LiveData<Int> get() = _numberOfFollowers

    val _numberOfFollowing: MutableLiveData<Int> = MutableLiveData()
    private val numberOfFollowing: LiveData<Int> get() = _numberOfFollowing
}