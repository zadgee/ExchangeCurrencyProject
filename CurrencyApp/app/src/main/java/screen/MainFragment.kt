package screen

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import com.example.currencyapp.R
import com.example.currencyapp.databinding.FragmentMainBinding
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import viewpager.ViewPagerAdapter

@AndroidEntryPoint
class MainFragment : Fragment() {
   private lateinit var binding:FragmentMainBinding
    var ctx:Context? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding  = FragmentMainBinding.inflate(inflater)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
ctx = context
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewpager.adapter = ViewPagerAdapter(ctx as FragmentActivity)
        binding.tablayout.tabIconTint = null
        TabLayoutMediator(binding.tablayout,binding.viewpager){
            tab,pos-> when(pos){
                0->{
                    tab.setIcon(R.drawable.baseline_monetization_on_24)
                }
            1->{
                tab.setIcon(R.drawable.baseline_attach_money_24)
            }
            }
        }.attach()

    }
}