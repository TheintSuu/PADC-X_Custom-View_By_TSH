package com.padcmyanmar.padcx.padc_x_recyclerview_ypst.veiws.component

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import androidx.recyclerview.widget.RecyclerView
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.veiws.viewpods.EmptyViewPod

class SmartRecyclerView @JvmOverloads constructor(
    context : Context, attrs : AttributeSet, defStyleAttr : Int =0
) : RecyclerView(context, attrs, defStyleAttr){

    private  var mEmpytView : View?= null

    private val dataObserver = object : RecyclerView.AdapterDataObserver(){
        override fun onChanged() {
            super.onChanged()
        }

        override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
            super.onItemRangeInserted(positionStart, itemCount)
            checkIfEmpty()
        }

        override fun onItemRangeRemoved(positionStart: Int, itemCount: Int) {
            super.onItemRangeRemoved(positionStart, itemCount)
            checkIfEmpty()
        }
    }

    override fun setAdapter(adapter: Adapter<*>?) {
        val oldAdapter = getAdapter()
        oldAdapter?.unregisterAdapterDataObserver(dataObserver)

        adapter?.registerAdapterDataObserver(dataObserver)
        super.setAdapter(adapter)
        checkIfEmpty()
    }

    private fun checkIfEmpty(){
        val isEmpty = adapter?.itemCount == 0

        mEmpytView.let {
            it!!.visibility = if (isEmpty) View.VISIBLE else View.INVISIBLE
            visibility = if(isEmpty) View.INVISIBLE else View.VISIBLE
        }
    }

    fun setEmptyView(emptyView : View){
        mEmpytView = emptyView
    }
}