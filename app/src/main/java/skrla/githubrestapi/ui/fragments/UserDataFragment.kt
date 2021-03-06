package skrla.githubrestapi.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import skrla.githubrestapi.databinding.FragmentUserDataBinding
import skrla.githubrestapi.ui.adapters.FollowersAdapter
import skrla.githubrestapi.ui.adapters.FollowingAdapter
import skrla.githubrestapi.ui.adapters.GitRepositoryAdapter
import skrla.githubrestapi.viewmodels.UserViewModel

class UserDataFragment : Fragment() {

    private val userViewModel: UserViewModel by activityViewModels()

    private var _binding: FragmentUserDataBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUserDataBinding.inflate(inflater)

        binding.let {
            it.lifecycleOwner = this
            it.userDataFragment = userViewModel
            it.followersRecyclerView.adapter = FollowersAdapter()
            it.followingRecyclerView.adapter = FollowingAdapter()
            it.repositoryRecyclerView.adapter = GitRepositoryAdapter()
        }

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}