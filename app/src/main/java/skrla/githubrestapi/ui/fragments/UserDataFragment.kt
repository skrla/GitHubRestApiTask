package skrla.githubrestapi.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import skrla.githubrestapi.databinding.FragmentUserDataBinding
import skrla.githubrestapi.viewmodels.UserViewModel

class UserDataFragment : Fragment() {

    private val userViewModel: UserViewModel by viewModels()

    private var _binding: FragmentUserDataBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUserDataBinding.inflate(inflater)

        binding.lifecycleOwner = this

        binding.userDataFragment = userViewModel

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}