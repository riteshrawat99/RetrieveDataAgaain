package com.pupup.retrievedataagaain

import android.provider.CalendarContract.Colors
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.collection.LLRBNode.Color

class MyAdapter(val listItem : ArrayList<User>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_design,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
       return listItem.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val p0 = listItem[position]
        holder.get_name.text=p0.name
        holder.get_email.text=p0.email
        holder.get_phone.text=p0.phone.toString()
        var color = "#706f6f"
        if (position % 2 ==0){
            color = "#052538"
        }
//        holder.container.setBackgroundColor(android.graphics.Color.parseColor(color)) // set background color
//        holder.container.cardElevation=10f
        holder.container.radius=20f

    }
            class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
                val get_name : TextView = itemView.findViewById(R.id.get_name)
                val get_email : TextView = itemView.findViewById(R.id.get_email)
                val get_phone : TextView = itemView.findViewById(R.id.get_phone)
                val container : CardView = itemView.findViewById(R.id.container)
            }
}