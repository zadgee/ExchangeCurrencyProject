package screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.currencyapp.R
import com.example.currencyapp.databinding.FragmentCashBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CashFragment : Fragment() {
    lateinit var recView: RecyclerView
    lateinit var binding : FragmentCashBinding
    lateinit var adapter:RecViewForCash

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCashBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
     adapter = RecViewForCash()
        binding.recviewCash.layoutManager = LinearLayoutManager(context)
        binding.recviewCash.adapter = adapter
        val viewmodel = ViewModelProvider(this).get(CashViewModel::class.java)
        viewmodel.getCashMoney()
        viewmodel.cashMoney.observe(viewLifecycleOwner){
            list->
            list.body()?.let { adapter.setlist(it)}
        }
    }
}