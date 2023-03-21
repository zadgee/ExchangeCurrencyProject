package screen
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.currencyapp.databinding.FragmentWithOutCashBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WithOutCashFragment : Fragment() {
 private lateinit var binding:FragmentWithOutCashBinding
    lateinit var recView: RecyclerView
    lateinit var adapter:RecViewWithOutCash
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
      binding = FragmentWithOutCashBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewmodel = ViewModelProvider(this).get(WithOutCashViewModel::class.java)
       adapter = RecViewWithOutCash()
        binding.recviewwithoutcash.layoutManager = LinearLayoutManager(context)
       binding.recviewwithoutcash.adapter = adapter
       viewmodel.getMoneyWithOutCash()
        viewmodel.listwithoutcash.observe(viewLifecycleOwner){
           list->
            list.body()?.let { adapter.setlist(it) }
        }
    }

}