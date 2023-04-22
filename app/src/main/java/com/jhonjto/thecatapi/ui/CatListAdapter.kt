package com.jhonjto.thecatapi.ui

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jhonjto.domain.CatListItem
import com.jhonjto.thecatapi.R
import com.jhonjto.thecatapi.databinding.ViewCatsBinding
import com.jhonjto.thecatapi.ui.common.basicDiffUtil
import com.jhonjto.thecatapi.ui.common.inflate
import com.jhonjto.thecatapi.ui.common.loadUrl

class CatListAdapter: RecyclerView.Adapter<CatListAdapter.ViewHolder>() {

    var cats: List<CatListItem> by basicDiffUtil(
        emptyList(),
        areItemsTheSame = { old, new -> old.id == new.id }
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = parent.inflate(R.layout.view_cats, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = cats.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cats = cats[position]
        holder.bind(cats)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ViewCatsBinding.bind(view)
        fun bind(catListItem: CatListItem) = with(binding) {
            tvName.text = catListItem.name
            tvImage.loadUrl("https://image.tmdb.org/t/p/w185/${"https://api.thecatapi.com/v1/images/"+catListItem.reference_image_id}")
            tvCountry.text = catListItem.origin
            tvIntelligence.text = catListItem.intelligence.toString()
        }
    }
}