package com.changesNewDesignsDiary

/*import android.support.v4.app.Fragment*/

import android.R
import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import cn.pedant.SweetAlert.SweetAlertDialog
import com.bkc.myeducationapp.utility.MyProgressDialog
import com.example.demod.RXCalling.ServiceModel
import java.util.*


abstract class BaseFragmentKot : Fragment(), Observer {
    abstract val model: Observable?
    val serviceModel: ServiceModel = ServiceModel()
    var toolbar: Toolbar? = null
    var mycustomdialog: Dialog? = null

    // method use for create fragment view
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mycustomdialog=MyProgressDialog().progressDialog(context)
        val model = model
        model?.addObserver(this)
        return onCreateViewPost(inflater, container, savedInstanceState)
    }

    @SuppressLint("ServiceCast")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(requireView().windowToken, 0)
    }

    abstract fun onCreateViewPost(
        inflater: LayoutInflater?,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View


    open fun initToolbar(view: View): Toolbar? {
        toolbar = view.findViewById(com.bkc.myeducationapp.R.id.toolbar)
        toolbar!!.setNavigationIcon(ContextCompat.getDrawable(view.context, com.bkc.myeducationapp.R.drawable.ic_back_arrow))

        toolbar!!.setTitleTextColor(resources.getColor(R.color.white))
        toolbar!!.setNavigationOnClickListener(View.OnClickListener { requireActivity().onBackPressed() })
        toolbar!!.setVisibility(View.GONE)
        return toolbar
    }


    open fun dialog(massage: String?, hading: String?, type: Int): SweetAlertDialog? {
        val dialog = SweetAlertDialog(context, type)
        dialog.titleText = hading
        dialog.setCancelable(false)
        dialog.setCanceledOnTouchOutside(false)
        dialog.setContentText(massage).show()
        return dialog
    }


    override fun onDestroyView() {
        super.onDestroyView()
    }


}