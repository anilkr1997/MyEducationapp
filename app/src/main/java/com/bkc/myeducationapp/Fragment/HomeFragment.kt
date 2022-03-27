package com.bkc.myeducationapp.Fragment

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bkc.myeducationapp.Adopter.AdopterCourcelist
import com.bkc.myeducationapp.LoginActivity
import com.bkc.myeducationapp.ModelClass.courcelist.Courcelist
import com.bkc.myeducationapp.R
import com.bkc.myeducationapp.utility.NetworkUtils
import com.bkc.myeducationapp.utility.Utility.GETALLCOURCES
import com.changesNewDesignsDiary.BaseActivityKot.Companion.setFragment
import com.changesNewDesignsDiary.BaseFragmentKot
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class HomeFragment(context: Context) : BaseFragmentKot() ,AdopterCourcelist.Operation{
    @SuppressLint("NonConstantResourceId")
    private lateinit var recyclerView: RecyclerView
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var myadopterReciver: com.bkc.myeducationapp.BroadCastReciver.MyadopterReciver;
    private lateinit var adopterCourcelist: AdopterCourcelist
  private lateinit var  operation : AdopterCourcelist.Operation;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override val model: Observable
        get()= serviceModel


    override fun onCreateViewPost(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view= inflater!!.inflate(R.layout.fragment_home, container, false)
        return view
    }
    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar(view)
          recyclerView=view.findViewById(R.id.recycleview)
//        myadopterReciver=com.bkc.myeducationapp.BroadCastReciver.MyadopterReciver()
//        context?.let { LocalBroadcastManager.getInstance(it).registerReceiver(myadopterReciver, IntentFilter("sendrequest")) }

        recyclerView.layoutManager=LinearLayoutManager(context)
        recyclerView.hasFixedSize().and(true)

        if(NetworkUtils.isOnline(context)){
            mycustomdialog!!.show()
            serviceModel.doPostJSonRequest(GETALLCOURCES)
        }

    }

    @SuppressLint("NotifyDataSetChanged")
    override fun update(observable: Observable?, obj: Any?) {
        mycustomdialog!!.dismiss()
        if(obj is Courcelist){
            val courcelist=obj as Courcelist
            if(!courcelist.error){
                recyclerView.adapter=AdopterCourcelist(context, courcelist.data,this)
                adopterCourcelist.notifyDataSetChanged()
            }

        }
//        f(arg is Loginresponce){
//            val loginresponce= arg as? Loginresponce;

    }


    companion object {

        @JvmStatic
        fun newInstance(context: Context) = HomeFragment(context).apply {

                }
            }

    override fun videoonClick() {
        Toast.makeText(context,"underprocessing",Toast.LENGTH_LONG).show()
    }

    override fun registationonClick() {
        Toast.makeText(context,"underprocessing",Toast.LENGTH_LONG).show()

    }

    override fun sylaburceonClick(syllabus: String) {
       setFragment(OpenPdfFragment.newInstance(requireContext(),syllabus),false, requireActivity(),R.id.flFragment)
    }
}
