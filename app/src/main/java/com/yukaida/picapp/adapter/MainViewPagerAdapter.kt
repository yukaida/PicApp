package com.yukaida.picapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.yukaida.picapp.R

/**
 * @author yukaida
 * @DATE 2021/1/4.
 */
class MainViewPagerAdapter : RecyclerView.Adapter<MainViewPagerAdapter.ViewPagerHolder>() {

    private val itemList = listOf<String>("1", "2", "3")

    class ViewPagerHolder(view: View) : RecyclerView.ViewHolder(view) {
//        val textView: TextView = view.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerHolder {
        return ViewPagerHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.fragment_beauty, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewPagerHolder, position: Int) {
//        holder.textView.text=itemList[position]
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

}