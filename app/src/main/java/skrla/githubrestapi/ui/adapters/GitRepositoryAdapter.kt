package skrla.githubrestapi.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import skrla.githubrestapi.data.models.GitRepositoryApiData
import skrla.githubrestapi.databinding.UserRepositoryBinding

class GitRepositoryAdapter :
    ListAdapter<GitRepositoryApiData, GitRepositoryAdapter.ViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<GitRepositoryApiData>() {
        override fun areItemsTheSame(
            oldItem: GitRepositoryApiData,
            newItem: GitRepositoryApiData
        ): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(
            oldItem: GitRepositoryApiData,
            newItem: GitRepositoryApiData
        ): Boolean {
            return oldItem.name == newItem.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            UserRepositoryBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val repository = getItem(position)
        holder.bind(repository)
    }


    class ViewHolder(private var binding: UserRepositoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(repository: GitRepositoryApiData) {
            binding.repository = repository

            binding.executePendingBindings()
        }
    }
}