package com.jlexdev.reign.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.jlexdev.reign.BR
import com.jlexdev.reign.R
import com.jlexdev.reign.databinding.ItemHitsBinding
import com.jlexdev.reign.model.HitsModel

/**
 * @author Joe Ramírez (@JLexDev) on 17/09/2021.
 * 1jlex3@gmail.com
 * ·
 * Trujillo - Perú
 **/

class HitsAdapter(private val items: MutableList<HitsModel>,
                  val callback:(model: HitsModel, position: Int) -> Unit) : RecyclerView.Adapter<HitsAdapter.HitsHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HitsHolder {
        val binding: ItemHitsBinding? =
            DataBindingUtil.bind(LayoutInflater.from(parent.context).inflate(R.layout.item_hits, parent, false))
        return HitsHolder(binding!!)
    }

    override fun onBindViewHolder(holder: HitsHolder, position: Int) {
        val hitsModel = items[position]
        holder.bind(model = hitsModel)
        holder.itemBinding.root.setOnClickListener {
            callback(hitsModel, position)
        }
    }

    override fun getItemCount() = items.size

    fun addItems(newItem: List<HitsModel>) {
        items.clear()
        items.addAll(newItem)
        notifyDataSetChanged()
    }

    inner class HitsHolder(val itemBinding: ItemHitsBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(model: HitsModel) {
            itemBinding.setVariable(BR.model, model)
            itemBinding.executePendingBindings()
        }
    }
}