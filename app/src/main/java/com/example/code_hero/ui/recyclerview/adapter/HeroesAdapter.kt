package com.example.code_hero.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.code_hero.R
import com.example.code_hero.model.data.Character
import kotlinx.android.synthetic.main.item_hero.view.*

class HeroesAdapter(
    val context : Context,
    var items : MutableList<Character> = mutableListOf()
):  RecyclerView.Adapter<HeroesAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.item_hero, parent, false)

        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(itemView : View) :  RecyclerView.ViewHolder(itemView){

        private lateinit var item: Character

        init {
            itemView.setOnClickListener {
                if (::item.isInitialized){
              //      onClickItem(item)
                }
            }
        }


        fun bind(item: Character) {
            this.item = item
            itemView.item_hero_name.text = item.name
            itemView.item_hero_desc.text = item.description
        }
    }

    fun updateList(newItems: MutableList<Character>) {

        val diff = DiffUtil.calculateDiff(object: DiffUtil.Callback(){
            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean
                    = items[oldItemPosition] == newItems[newItemPosition]

            override fun getOldListSize(): Int = items.size

            override fun getNewListSize(): Int = newItems.size

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean
                    = items[oldItemPosition].id == newItems[newItemPosition].id
        })

        this.items = newItems
        diff.dispatchUpdatesTo(this@HeroesAdapter)
    }

}