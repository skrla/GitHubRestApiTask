package skrla.githubrestapi.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import skrla.githubrestapi.R
import skrla.githubrestapi.databinding.FragmentStartingBinding
import skrla.githubrestapi.viewmodels.UserViewModel

class StartingFragment : Fragment() {

    private val userViewModel: UserViewModel by viewModels()

    private var _binding: FragmentStartingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStartingBinding.inflate(inflater, container, false)
        val enteredUser = binding.enterUsernameNameEdit.toString()
        binding.enterStartingBtn.setOnClickListener {
            if (enteredUser.trim().isNotEmpty()) {
                userViewModel.setUser(enteredUser)
                findNavController().navigate(R.id.action_startingFragment_to_userDataFragment)
            } else {
                Toast.makeText(
                    activity,
                    "Error",
                    Toast.LENGTH_SHORT
                )
                    .show()
            }
        }

        return binding.root

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}