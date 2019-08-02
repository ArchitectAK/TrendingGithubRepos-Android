package com.ankkumar.trendingrepo.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ankkumar.trendingrepo.R
import com.ankkumar.trendingrepo.model.RepoEntity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_repo.view.*

class RepoAdapter(var context: Context, private val list: ArrayList<RepoEntity>) :
    RecyclerView.Adapter<RepoAdapter.ViewHolder>() {


    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_repo, parent, false)
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(list[position])
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return list.size
    }

    //the class is hodling the list view
    open inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(repoEntity: RepoEntity) {
            itemView.author.text = repoEntity.author
            itemView.repoName.text = repoEntity.name

            Glide
                .with(itemView.avatar.context)
                .load(repoEntity.avatar)
                .fitCenter()
                .into(itemView.avatar)
        }
    }

    fun addList(list: List<RepoEntity>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

}