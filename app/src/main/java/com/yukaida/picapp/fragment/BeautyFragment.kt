package com.yukaida.picapp.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.yukaida.picapp.R
import com.yukaida.picapp.adapter.BeautyFragmentAdapter
import com.yukaida.picapp.databinding.FragmentBeautyBinding
import com.yukaida.picapp.netWork.apiServer
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

/**
 * @author yukaida
 * @DATE 2021/1/4.
 */
class BeautyFragment: Fragment() {

    private lateinit var binding: FragmentBeautyBinding

    companion object{
        private const val TAG = "BeautyFragment"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentBeautyBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {

            MainScope().launch {
                val picListBean=apiServer.getPic(0, 10)
                Log.d(TAG, "onViewCreated:${picListBean}")

                if (picListBean.code == 200) {
                    beautyFMRecyclerview.run {
                        adapter= context?.let {
                            layoutManager=GridLayoutManager(context,2)
                            BeautyFragmentAdapter(picListBean.result, it) }
                    }
                }


            }


//            beautyFMRecyclerview.adapter=
        }
    }
}