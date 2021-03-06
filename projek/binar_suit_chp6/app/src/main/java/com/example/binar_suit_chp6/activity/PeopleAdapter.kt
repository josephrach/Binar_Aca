package com.example.binar_suit_chp6.activity

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.binar_suit_chp6.R

class PeopleAdapter : RecyclerView.Adapter<PeopleViewHolder>(){
    private val dataPeople: MutableList<People> = mutableListOf()

    //add function to add item list
    fun addList(dataList:List<People>){
        dataPeople.addAll(dataList)
        notifyDataSetChanged()
        sort()
    }

    //add function to add item single
    fun addItem(dataSingle: People){
        dataPeople.add(dataSingle)
        notifyDataSetChanged()
        sort()
    }

    fun sort(){
        dataPeople.sortBy { it.name }
        notifyDataSetChanged()
    }


    //membuat item view dari xml secara sequental untuk view holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleViewHolder {
        val context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_people,parent,false)
        val viewHolder = PeopleViewHolder(view)
        return viewHolder
    }

    //event dimana item di binding
    override fun onBindViewHolder(holder: PeopleViewHolder, position: Int) {
        val people = dataPeople.get(position)
        holder.bind(people)
    }

    //set jumlah data dari list
    override fun getItemCount(): Int {
        return dataPeople.size
    }

}