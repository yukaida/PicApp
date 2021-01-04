package com.yukaida.picapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yukaida.picapp.R
import com.yukaida.picapp.bean.BeautyItemJson

/**
 * @author yukaida
 * @DATE 2021/1/4.
 */
class BeautyFragmentAdapter(
    private val list: List<BeautyItemJson.ItemBeauty>,
    private val context: Context
) : RecyclerView.Adapter<BeautyFragmentAdapter.BeautyViewHolder>() {

    class BeautyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.item_beauty_imageView)
        val textView: TextView = view.findViewById(R.id.item_beauty_textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeautyViewHolder {
        return BeautyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_beauty_fm, parent, false)
        )
    }

    override fun onBindViewHolder(holder: BeautyViewHolder, position: Int) {
        holder.run {
            list[position].run {
                Glide.with(context).load(this@run.img).into(imageView)
                textView.text = this@run.time
            }

            imageView.setOnClickListener {

                val dialogView =
                    LayoutInflater.from(context).inflate(R.layout.dialog_image_full, null, false)

                Glide.with(context).load(list[position].img).into(dialogView.findViewById(R.id.dialog_imageView))


                val dialog = AlertDialog.Builder(context).run {
                    setView(dialogView)
                    setCancelable(true)
                    create()
                    show()
                }

                dialogView.setOnClickListener{
                    dialog.dismiss()
                }


            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}