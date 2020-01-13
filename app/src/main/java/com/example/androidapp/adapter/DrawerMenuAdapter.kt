package com.example.androidapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidapp.model.DrawerMenuItem
import com.example.androidapp.R
import com.example.androidapp.model.MenuHeaderItem

class DrawerMenuAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var items: ArrayList<DrawerMenuItem>? = null
    lateinit var context: Context

    constructor(items: ArrayList<DrawerMenuItem>, context: Context) : this() {
        this.context = context
        this.items = items
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == DrawerMenuItem.ROW_HEADER) {
            ViewHolderHeader(
                LayoutInflater.from(context).inflate(
                    R.layout.row_drawable_header,
                    parent,
                    false
                )
            )
        } else if (viewType == DrawerMenuItem.ROW_BODY) {
            ViewHolderBody(
                LayoutInflater.from(context).inflate(
                    R.layout.row_drawer_body,
                    parent,
                    false
                )
            )
        } else ViewHolderFooter(
            LayoutInflater.from(context).inflate(
                R.layout.row_drawable_header,
                parent,
                false
            )
        )

    }

    override fun getItemCount(): Int {
        return items?.size!!
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is ViewHolderHeader){
            val holderView = holder
            var listHeader = arrayListOf<MenuHeaderItem>()
            listHeader.add(MenuHeaderItem())
            listHeader.add(MenuHeaderItem())
            listHeader.add(MenuHeaderItem())
            listHeader.add(MenuHeaderItem())
            holder.recyclerView.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
            var adapter = DrawerHeaderAdapter(context,listHeader)
            holder.recyclerView.adapter = adapter
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (items != null)
            return items!![position].itemType
        else
            return 0
    }

    private inner class ViewHolderHeader internal constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        internal var recyclerView: RecyclerView

        init {
            recyclerView = itemView.findViewById(R.id.recycler_view)
        }
    }

    private inner class ViewHolderBody internal constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        internal var recyclerView: RecyclerView

        init {
            recyclerView = itemView.findViewById(R.id.recycler_view);
        }

    }

    private inner class ViewHolderFooter internal constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

    }

}
