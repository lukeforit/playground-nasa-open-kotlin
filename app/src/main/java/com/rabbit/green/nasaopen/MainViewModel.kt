package com.rabbit.green.nasaopen

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.databinding.BindingAdapter
import android.text.TextUtils
import android.widget.ImageView
import com.rabbit.green.nasaopen.data.model.Item
import com.squareup.picasso.Picasso
import javax.inject.Inject

class MainViewModel @Inject constructor() : BaseObservable() {

    private var item: Item? = null

    internal fun setData(item: Item) {
        this.item = item
        notifyPropertyChanged(BR.title)
        notifyPropertyChanged(BR.explanation)
        notifyPropertyChanged(BR.url)
    }

    @Bindable
    fun getTitle(): String {
        return item?.title ?: ""
    }

    @Bindable
    fun getExplanation(): String {
        return item?.explanation ?: ""
    }

    @Bindable
    fun getUrl(): String {
        return item?.url ?: ""
    }
}

@BindingAdapter("url")
fun bindUrl(imageView: ImageView, url: String) {
    if (!TextUtils.isEmpty(url)) {
        Picasso.get().load(url).fit().centerCrop().into(imageView)
    }
}