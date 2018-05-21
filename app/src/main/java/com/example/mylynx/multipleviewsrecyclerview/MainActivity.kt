package com.example.mylynx.multipleviewsrecyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.mylynx.multipleviewsrecyclerview.adapter.RecyclerViewAddSubAdapter

import com.example.mylynx.multipleviewsrecyclerview.model.Person
import kotlinx.android.synthetic.main.activity_main.*

import java.util.ArrayList
import com.google.common.collect.Lists.newArrayList

class MainActivity : AppCompatActivity() {

    var listOfPeople: ArrayList<Person>? = null
    var adapter: RecyclerViewAddSubAdapter? = null
    var layoutManager: RecyclerView.LayoutManager? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listOfPeople = newArrayList(

                Person("John", null),
                Person("Michael", "ic_add")
        )

        adapter = RecyclerViewAddSubAdapter(listOfPeople!!, this)
        layoutManager = LinearLayoutManager(this)


        recyclerViewId.adapter = adapter
        recyclerViewId.layoutManager = layoutManager

    }
}
