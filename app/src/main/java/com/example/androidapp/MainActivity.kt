package com.example.androidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidapp.databinding.MainActivityBinding
import com.example.androidapp.ui.main.MainFragment
import com.example.androidapp.BR.mainActivity
import com.example.androidapp.adapter.DrawerMenuAdapter
import com.example.androidapp.model.DrawerMenuItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var binding: MainActivityBinding
    lateinit var drawerListItem: ArrayList<DrawerMenuItem>
    lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.main_activity)

        binding = DataBindingUtil.setContentView(this,R.layout.main_activity)
        binding.lifecycleOwner = this
        binding.setVariable(mainActivity,this)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
        setupDrawer()


    }
    fun setupDrawer(){
        drawerListItem = arrayListOf()

        drawerListItem.add(
            DrawerMenuItem(
                DrawerMenuItem.ROW_HEADER
            )
        )

        val menuIcon : ImageView = findViewById(R.id.menu_icon);
        val drawerRecyclerView: RecyclerView = findViewById(R.id.drawer_list);

        linearLayoutManager = LinearLayoutManager(this)

        var adapterDrawer  = DrawerMenuAdapter(
            drawerListItem,
            this
        )

        drawerRecyclerView.layoutManager = linearLayoutManager
        drawerRecyclerView.adapter = adapterDrawer
    }
    fun openCloseDrawer(){
        if (drawer_layout.isDrawerOpen(GravityCompat.START)){
            drawer_layout.closeDrawer(GravityCompat.START)
        }else{
            drawer_layout.openDrawer(GravityCompat.START)
        }
    }



}
