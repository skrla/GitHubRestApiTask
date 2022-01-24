package skrla.githubrestapi.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import skrla.githubrestapi.data.models.FollowingApiData
import skrla.githubrestapi.databinding.UserFollowingBinding

class FollowingAdapter : ListAdapter<FollowingApiData, FollowingAdapter.ViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<FollowingApiData>() {
        override fun areItemsTheSame(
            oldItem: FollowingApiData,
            newItem: FollowingApiData
        ): Boolean {
            return oldItem.username == newItem.username
        }

        override fun areContentsTheSame(
            oldItem: FollowingApiData,
            newItem: FollowingApiData
        ): Boolean {
            return oldItem.username == newItem.username
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            UserFollowingBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val usernameFollower = getItem(position)
        holder.bind(usernameFollower)
    }


    class ViewHolder(private var binding: UserFollowingBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(following: FollowingApiData) {
            binding.following = following

            binding.executePendingBindings()
        }
    }
}