package com.jlexdev.reign.ui.main.adapter

import android.content.Context
import android.text.format.DateUtils
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.jlexdev.reign.BR
import com.jlexdev.reign.R
import com.jlexdev.reign.databinding.ItemHitsBinding
import com.jlexdev.reign.model.HitsModel
import com.jlexdev.reign.ui.main.MainActivity
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

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
            itemBinding.tvCreatedAt.text = getTimeAgo(model.createdAt)
        }
    }

    fun getTimeAgo(timeToParse: String) : String {
        val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
        sdf.timeZone = TimeZone.getTimeZone("GMT")
        var time: Long = 0
        try {
            time = sdf.parse(timeToParse).time
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        val now = System.currentTimeMillis()
        val ago = DateUtils.getRelativeTimeSpanString(time, now, DateUtils.MINUTE_IN_MILLIS)
        return "- $ago"
    }
}