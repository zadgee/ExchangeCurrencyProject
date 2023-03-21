package screen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.currencyapp.R
import retrofit.WithOutCashItems

class RecViewWithOutCash:RecyclerView.Adapter<RecViewWithOutCash.WithOutMoneyHolder>() {
    var listwithoutcash = ArrayList<WithOutCashItems>()
    class WithOutMoneyHolder(view:View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WithOutMoneyHolder {
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.item_money_layout,parent,false)
        return WithOutMoneyHolder(view)
    }

    override fun getItemCount(): Int {
       return listwithoutcash.size
    }

    override fun onBindViewHolder(holder: WithOutMoneyHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.item_name).text = listwithoutcash[position].ccy
        holder.itemView.findViewById<TextView>(R.id.item_buy).text = listwithoutcash[position].buy
        holder.itemView.findViewById<TextView>(R.id.item_sale).text = listwithoutcash[position].sale
    }

    fun setlist(list:List<WithOutCashItems>){
        listwithoutcash.addAll(list)
        notifyDataSetChanged()
    }
}