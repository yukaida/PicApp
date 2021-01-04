package com.yukaida.picapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.yukaida.picapp.databinding.ActivityMainBinding
import com.yukaida.picapp.fragment.BeautyFragment
import com.yukaida.picapp.fragment.EmptyFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentA = BeautyFragment()
        val fragmentB = EmptyFragment()
        val fragmentC = EmptyFragment()

        val listFragment = listOf(fragmentA, fragmentB, fragmentC)

        with(binding) {
//            mainAtBottomNavigationView.
            mainAtViewPager2.adapter=ViewPagerFragmentStateAdapter(listFragment,this@MainActivity)

        }
    }


    class ViewPagerFragmentStateAdapter(private val listFragment: List<Fragment>, fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {
        override fun getItemCount(): Int {
          return listFragment.size
        }

        override fun createFragment(position: Int): Fragment {
            return listFragment[position]
        }
    }
}