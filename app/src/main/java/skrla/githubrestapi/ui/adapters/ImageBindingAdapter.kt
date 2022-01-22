package skrla.githubrestapi.ui.adapters

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import coil.load

@BindingAdapter("imageUrl")
fun bindProfilPic(imgView: ImageView, profilPic: String?) {
    profilPic?.let{
        val profilPicUri = profilPic.toUri().buildUpon().scheme("https").build()
        imgView.load(profilPicUri)
    }
}