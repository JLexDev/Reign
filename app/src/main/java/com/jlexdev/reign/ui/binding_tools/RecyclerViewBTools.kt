package com.jlexdev.reign.ui.binding_tools

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jlexdev.reign.ui.main.adapter.HitsAdapter

/**
 * @author Joe Ramírez (@JLexDev) on 18/09/2021.
 * 1jlex3@gmail.com
 * ·
 * Trujillo - Perú
 **/

@BindingAdapter("hitsAdapter")
fun setHitsAdapter(recyclerView: RecyclerView, adapter: HitsAdapter){
    recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
    recyclerView.adapter = adapter
}