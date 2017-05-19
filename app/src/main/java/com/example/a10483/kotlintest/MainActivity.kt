package com.example.a10483.kotlintest

import android.content.Context
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.view.Window
import android.widget.Adapter
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item.*
import java.security.AccessControlContext


class MainActivity : AppCompatActivity() {


    private var itemList=ArrayList<String>()
    private var adapter:MyAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        hello.setText("This is a kotlin android app")

        itemList.getData()
        adapter= MyAdapter(itemList,this)
        listview.adapter=adapter
        bt.setOnClickListener {
            tv.setText("shit!")
        }


    }

    fun ArrayList<String>.getData(){
        for (i in 0..20){
            this.add("str:"+i)
        }
    }

    class MyAdapter(val list: ArrayList<String>,val context: Context):BaseAdapter(){

        override fun getCount(): Int {
            TODO("not implemented")
            return list.size//To change body of created functions use File | Settings | File Templates.
        }

        override fun getItem(position: Int): Any {
            TODO("not implemented")
            return list.get(position)//To change body of created functions use File | Settings | File Templates.
        }

        override fun getItemId(position: Int): Long {
            TODO("not implemented")
            return position.toLong()//To change body of created functions use File | Settings | File Templates.
        }

        override fun getView(position: Int, contertView: View?, parent: ViewGroup?): View {
            TODO("not implemented")
            var holder:TestViewHolder
            var view:View
            if (contertView==null){
                view=View.inflate(context,R.layout.item,null)
                holder=TestViewHolder(view)
                view.tag=holder//To change body of created functions use File | Settings | File Templates.
            }else{
                view=contertView
                holder=view.tag as TestViewHolder
            }

            holder.tv.text=list[position]
            return view
        }
    }

    class TestViewHolder(var Item:View){
        var tv:TextView=Item.findViewById(R.id.tv) as TextView
        var bt:Button=Item.findViewById(R.id.bt) as Button
    }
}
