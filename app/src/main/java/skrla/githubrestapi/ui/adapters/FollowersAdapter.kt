package skrla.githubrestapi.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import skrla.githubrestapi.data.models.FollowersApiData
import skrla.githubrestapi.databinding.UserFollowersBinding

class FollowersAdapter : ListAdapter<FollowersApiData, FollowersAdapter.ViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<FollowersApiData>() {
        override fun areItemsTheSame(
            oldItem: FollowersApiData,
            newItem: FollowersApiData
        ): Boolean {
            return oldItem.username == newItem.username
        }

        override fun areContentsTheSame(
            oldItem: FollowersApiData,
            newItem: FollowersApiData
        ): Boolean {
            return oldItem.username == newItem.username
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            UserFollowersBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val usernameFollower = getItem(position)
        holder.bind(usernameFollower)
    }


    class ViewHolder(private var binding: UserFollowersBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(follower: FollowersApiData) {
            binding.followers = follower

            binding.executePendingBindings()
        }
    }
}