package com.example.androidapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidapp.R
import com.example.androidapp.model.MenuHeaderItem

class DrawerHeaderAdapter(var context: Context, var list: ArrayList<MenuHeaderItem>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

      return  ViewHolder(LayoutInflater.from(context).inflate(R.layout.row_drawer_header_item,parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    }
}