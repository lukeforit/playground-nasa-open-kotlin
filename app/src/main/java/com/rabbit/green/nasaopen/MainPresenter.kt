package com.rabbit.green.nasaopen

import com.rabbit.green.nasaopen.data.model.Item
import com.rabbit.green.nasaopen.data.source.IRepository
import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainPresenter @Inject constructor() : SingleObserver<Item> {

    @Inject
    lateinit var repository: IRepository

    @Inject
    lateinit var viewModel: MainViewModel

    internal fun setup() {
        Single.fromCallable<Item> { repository.getItem() }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(this)
    }

    override fun onSuccess(item: Item) {
        viewModel.setData(item)
    }

    override fun onSubscribe(d: Disposable) {
    }

    override fun onError(e: Throwable) {
        e.printStackTrace()
    }
}
