package uz.data.debts_apk.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import kotlinx.android.synthetic.main.item_design.view.*
import uz.data.debts_apk.model.User

class MyAdapter:RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    var users = mutableListOf<User>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    inner class MyViewHolder(view: View):RecyclerView.ViewHolder(view){
        fun setData(user: User){
            itemView.name.text = user.name
            itemView.rv_summa.text = user.summa.toString()
            itemView.givendate.text = user.givendate
            itemView.getday.text = user.getday
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_design,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.setData(users[position])
    }

    override fun getItemCount(): Int = users.size
}