package com.autumnsun.sunchatapp.core.utils

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

/*
 Created by Fatih Kurcenli on 12/22/2021
*/


@BindingAdapter(value = ["imageUrl", "cornerRadius"])
fun ImageView.bindLoadRoundedImage(
    usersImageUrl: String,
    radius: Int,
) {
    Glide.with(this.context)
        .load(usersImageUrl)
        .apply(RequestOptions().transform(RoundedCorners(radius)))
        .into(this)
}

@BindingAdapter("circleAvatar")
fun ImageView.circleAvatar(
    usersImageUrl: String
) {
    Glide.with(this.context)
        .load(usersImageUrl)
        .circleCrop()
        .into(this)
}

@BindingAdapter("isHasNotification")
fun View.isHasNotification(
    isHas: Boolean
) {
    if (isHas) {
        this.visibility = View.VISIBLE
    } else {
        this.visibility = View.GONE
    }
}