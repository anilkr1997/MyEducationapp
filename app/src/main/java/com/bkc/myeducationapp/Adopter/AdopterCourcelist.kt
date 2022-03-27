package com.bkc.myeducationapp.Adopter

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bkc.myeducationapp.R

import com.bkc.myeducationapp.ModelClass.courcelist.Data
import com.bkc.myeducationapp.utility.Utility.IMG_BASE_URL
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target


class AdopterCourcelist: RecyclerView.Adapter<AdopterCourcelist.MyViewHolder> {
    lateinit var context:Context
  lateinit var  data: List<Data>
   lateinit var  opration:Operation;
    constructor(context: Context?, data: List<Data>, operation: Operation?){
        this.context= context!!;
        this.data= data;
        this.opration=operation!!
    }


    inner  class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val imageicon : AppCompatImageView=itemView.findViewById(R.id.imageicon);
    val corcename: AppCompatTextView =itemView.findViewById(R.id.courcename)
    val discraption:AppCompatTextView=itemView.findViewById(R.id.descraption)
    val discount:AppCompatTextView=itemView.findViewById(R.id.offer)
    val duration:AppCompatTextView=itemView.findViewById(R.id.courcecelavle)
    val registation: AppCompatButton =itemView.findViewById(R.id.btnregistation)
    val videio:AppCompatButton=itemView.findViewById(R.id.btnvideo)
    val btnsyllaburs:AppCompatButton=itemView.findViewById(R.id.btnsyllaburs)

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.contentlayout,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.corcename.setText(data.get(position).coursename)
        holder.duration.setText(data.get(position).level)
        holder.discraption.setText(data.get(position).topics)
        if(data.get(position).pack2_discount!="0"){
            holder.discount.setText(data.get(position).pack2_discount)

        }else{
            holder.discount.setText(data.get(position).pack3_discount)

        }
        holder.btnsyllaburs.setOnClickListener { it ->
          opration.sylaburceonClick(data.get(position).syllabus)

        }
        holder.registation.setOnClickListener { it ->
            opration.registationonClick()

        }
        holder.videio.setOnClickListener { opration.videoonClick() }

        val options = RequestOptions()
            .centerCrop()
            .override(200, 200)
            .fitCenter()
            .circleCrop()
            .error(R.drawable.no_image_available)
            .priority(Priority.HIGH)

        Glide.with(holder.imageicon.getContext()).applyDefaultRequestOptions(options).load(
            IMG_BASE_URL + data.get(position).logo
        )
            .listener(object : RequestListener<Drawable?> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any,
                    target: Target<Drawable?>,
                    isFirstResource: Boolean
                ): Boolean {
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any,
                    target: Target<Drawable?>,
                    dataSource: DataSource,
                    isFirstResource: Boolean
                ): Boolean {
                    return false
                }
            })
            .into(holder.imageicon)
    }

    override fun getItemCount(): Int {
    return data.size
    }
public interface Operation{
   fun videoonClick()
   fun registationonClick()
   fun sylaburceonClick(syllabus: String)
}
}