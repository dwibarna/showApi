package com.sobarna.testmidas

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ResAdapter: RecyclerView.Adapter<ResAdapter.ItemViewHolder>() {

    private val arrayList = ArrayList<MenusItem>()



    fun showList(newArray: List<MenusItem>?){
        if (newArray !=null){
            //arrayList.clear()
            arrayList.addAll(newArray)
            notifyDataSetChanged()
        }
    }


    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(menusItem: MenusItem) {

            with(itemView){
                val image = findViewById<ImageView>(R.id.imageView)
                val tvTitle = findViewById<TextView>(R.id.tvTitle)
                val tvInd = findViewById<TextView>(R.id.tvInd)
                val tvPrice = findViewById<TextView>(R.id.tvPrice)
                val tvDiscPrice = findViewById<TextView>(R.id.tvDiscPrice)


                Log.d(this.toString(),menusItem.image!!)


                    Glide.with(itemView.context)
                        .load(menusItem.image)
                        .into(image)

                    tvTitle.text = menusItem.title
                    tvDiscPrice.text = menusItem.discPrice.toString()
                tvPrice.text = menusItem.discPrice.toString()
                tvInd.text = menusItem.ind.toString()

            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(arrayList[position])
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }
}