package com.ankkumar.trendingrepo.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ankkumar.trendingrepo.R
import com.ankkumar.trendingrepo.model.RepoEntity
import kotlinx.android.synthetic.main.item_repo.view.*

class RepoAdapter(var context: Context, private val albumList: ArrayList<RepoEntity>) :
    RecyclerView.Adapter<RepoAdapter.ViewHolder>() {


    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_repo, parent, false)
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(albumList[position])
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return albumList.size
    }

    //the class is hodling the list view
    open inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(dashBoardModel: RepoEntity) {
            itemView.heading.text = dashBoardModel.author
        }
    }

    fun addList(list: List<RepoEntity>) {
        albumList.clear()
        albumList.addAll(list)
        notifyDataSetChanged()
    }

}