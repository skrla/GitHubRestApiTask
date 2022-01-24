package skrla.githubrestapi.ui.adapters

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import skrla.githubrestapi.data.models.FollowersApiData
import skrla.githubrestapi.data.models.FollowingApiData
import skrla.githubrestapi.data.models.GitRepositoryApiData

@BindingAdapter("imageUrl")
fun bindProfilePic(imgView: ImageView, profilePic: String?) {
    profilePic?.let {
        val profilePicUri = profilePic.toUri().buildUpon().scheme("https").build()
        imgView.load(profilePicUri)
    }
}

@BindingAdapter("listFollowers")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<FollowersApiData>?) {
    val adapter = recyclerView.adapter as FollowersAdapter
    adapter.submitList(data)
}

@JvmName("bindRecyclerView1")
@BindingAdapter("listFollowing")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<FollowingApiData>?) {
    val adapter = recyclerView.adapter as FollowingAdapter
    adapter.submitList(data)
}

@JvmName("bindRecyclerView2")
@BindingAdapter("listRepositories")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<GitRepositoryApiData>?) {
    val adapter = recyclerView.adapter as GitRepositoryAdapter
    adapter.submitList(data)
}



