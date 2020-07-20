package com.padcmyanmar.padcx.padc_x_recyclerview_ypst.mvp.presenters

import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.data.models.NewsModelImpl
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.mvp.views.MainView

class MainPresenterImpl() : MainPresenter, AbstractBasePresenter<MainView>() {

    private val mNewsModel = NewsModelImpl

    constructor(parcel: Parcel) : this() {
    }

    override fun onTapNewsItem(newsId: Int) {
        mView?.navigateToNewsDetails(newsId)
    }

    override fun onTapLike() {
        Log.d ("TAG", "Like ")
    }

    override fun onTapComment() {
        Log.d ("TAG", "Comment ")

    }

    override fun onTapShare() {
        Log.d ("TAG", "Share ")

    }

    override fun onTapTryAgain() {
      loadAllNewsFromApi()
    }

    override fun onSwipeRefresh(lifecycleOwner: LifecycleOwner) {
        requestAllNews(lifecycleOwner)
    }

    override fun onUiReady(lifeCycleOwner: LifecycleOwner) {
        requestAllNews(lifeCycleOwner)
    }

    private fun requestAllNews(lifeCycleOwner: LifecycleOwner) {
        mView?.enableSwipeRefresh()
        mNewsModel.getAllNews(onError = {
            mView?.disableSwipeRefresh()
        // mView?.displayEmptyView()
        }).observe(lifeCycleOwner, Observer {
            mView?.disableSwipeRefresh()
     //  if (it.isEmpty()) mView?.displayEmptyView() else mView?.displayNewsList(it)
            mView?.displayNewsList(it)
        })
    }

    private fun loadAllNewsFromApi(){
        mNewsModel.getAllNewsFromApiAndSaveToDatabase(
            onSuccess = {    },
            onError = {  }
        )
    }



}