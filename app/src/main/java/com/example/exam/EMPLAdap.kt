package com.example.exam

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.card.view.*

class EMPAdapter(val context: Context, var arr:ArrayList<EMPL>)
    : RecyclerView.Adapter<EMPAdapter.PersonViewHolde>()

{


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolde {
        var inflater= LayoutInflater.from(parent.context)
        var view= inflater.inflate(R.layout.card,parent,false)
        return PersonViewHolde(view)
    }

    override fun onBindViewHolder(holder: PersonViewHolde, position: Int) {
        holder.bind(arr[position])

    }

    override fun getItemCount(): Int {
        return  arr.size
    }

    class PersonViewHolde(var view: View):RecyclerView.ViewHolder(view)
    {
        fun bind(p:EMPL)
        {
            view.tvname.setText(p.empl_name)
            view.tvpassword.setText(p.empl_password)

        }
    }
}