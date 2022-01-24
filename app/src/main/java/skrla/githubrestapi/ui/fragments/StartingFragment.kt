package skrla.githubrestapi.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import skrla.githubrestapi.R
import skrla.githubrestapi.databinding.FragmentStartingBinding
import skrla.githubrestapi.viewmodels.UserViewModel

class StartingFragment : Fragment() {

    private val userViewModel: UserViewModel by activityViewModels()

    private var _binding: FragmentStartingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStartingBinding.inflate(inflater, container, false)
        binding.enterStartingBtn.setOnClickListener {
            userViewModel.setUser(binding.enterUsernameNameEdit.text.toString())
            findNavController().navigate(R.id.action_startingFragment_to_userDataFragment)
        }


        return binding.root
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}