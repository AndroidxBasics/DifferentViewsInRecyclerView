package com.example.mylynx.multipleviewsrecyclerview.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import android.view.LayoutInflater
import android.widget.ImageView
import com.example.mylynx.multipleviewsrecyclerview.R
import com.example.mylynx.multipleviewsrecyclerview.model.Person
import kotlinx.android.synthetic.main.list_row_name.view.*
import android.support.v4.view.ViewCompat.setActivated




/**
 * Created by mylynx on 21.02.18.
 */
class RecyclerViewAddSubAdapter(private var list: ArrayList<Person>, private val context: Context):
        RecyclerView.Adapter<RecyclerViewAddSubAdapter.MainViewHolder>() {
    //    było TYPE_IMAGE
    val TYPE_IMAGE = 0
    //    było TYPE_GROUP
    val TYPE_LARGETXT = 1


    override fun getItemViewType(position: Int): Int {
        var viewType: Int? = null


        if (list[position].picture != null) {
            viewType = TYPE_IMAGE

        } else {
            viewType = TYPE_LARGETXT
        }

        return viewType
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MainViewHolder {
        val mInflater = LayoutInflater.from(parent!!.getContext())
        when (viewType) {

            TYPE_IMAGE -> {
                val vImage = mInflater.inflate(R.layout.list_row_picture, parent, false)
                return ImageViewHolder(vImage)
            }
            TYPE_LARGETXT -> {
                val vGroup = mInflater.inflate(R.layout.list_row_name, parent, false)
                return TxtViewHolder(vGroup)
            }
            else -> {
                val vGroup0 = mInflater.inflate(R.layout.list_row_name, parent, false)
                return TxtViewHolder(vGroup0)
            }
        }
    }

    override fun onBindViewHolder(holder: MainViewHolder?, position: Int) {
        when (holder!!.getItemViewType()) {

            TYPE_IMAGE -> {

                val imageViewHolder = holder as ImageViewHolder

                imageViewHolder.bindView(list[position])
            }

            TYPE_LARGETXT -> {

                val groupViewHolder = holder as TxtViewHolder

                groupViewHolder.bindView(list[position])
            }
        }



    }

    override fun getItemCount(): Int {
        return list.size
    }

    open class MainViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    inner class TxtViewHolder(itemView: View) : MainViewHolder(itemView) {


        fun bindView(person: Person) {
            var name = itemView.findViewById<TextView>(R.id.onlynameId)

            name.text = person.name
        }


    }


    inner class ImageViewHolder(itemView: View) : MainViewHolder(itemView) {

        fun bindView(person: Person) {
            var name = itemView.findViewById<TextView>(R.id.namenPictId)
            var picture = itemView.findViewById<ImageView>(R.id.personPictureId)

            var idImage = context.resources.getIdentifier("com.example.mylynx.multipleviewsrecyclerview:drawable/${person.picture}", null, null)
            var drawable = context.resources.getDrawable(idImage, null)

            picture.setImageDrawable(drawable)
            name.text = person.name
        }

    }
}