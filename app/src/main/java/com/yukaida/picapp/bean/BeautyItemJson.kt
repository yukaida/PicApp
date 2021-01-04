package com.yukaida.picapp.bean

/**
 * @author yukaida
 * @DATE 2021/1/4.
 */


data class BeautyItemJson(val code: Int,
                     val message: String,
                     val result: List<ItemBeauty>) {

    data class ItemBeauty(val id: Int,
                          val time: String,
                          val img: String)
}