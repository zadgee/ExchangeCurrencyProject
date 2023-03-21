package screen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.currencyapp.R
import retrofit.CashItems

class RecViewForCash:RecyclerView.Adapter<RecViewForCash.CashViewHolder>() {
    var cashList  = ArrayList<CashItems>()
    class CashViewHolder(view:View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CashViewHolder {
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.item_money_layout,parent,false)
        return CashViewHolder(view)
    }

    override fun getItemCount(): Int {
   return cashList.size
    }

    override fun onBindViewHolder(holder: CashViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.item_name).text = cashList[position].ccy
        holder.itemView.findViewById<TextView>(R.id.item_buy).text = cashList[position].buy
        holder.itemView.findViewById<TextView>(R.id.item_sale).text = cashList[position].sale
    }
    fun setlist(list:List<CashItems>){
       cashList.addAll(list)
        notifyDataSetChanged()
    }
}