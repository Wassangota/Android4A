package com.github.wassilkhetim.android4a.presentation.body

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.github.wassilkhetim.android4a.R
import com.github.wassilkhetim.android4a.domain.entity.PersonnageInfo


class ListAdapter // Provide a suitable constructor (depends on the kind of dataset)
    (private val values: MutableList<PersonnageInfo>) :
    RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    private var parent: View? = null
    private var contextParentRow: Context? = null

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        // each data item is just a string in this case
        var imageView: ImageView = v.findViewById(R.id.icon)
        var txtHeader: TextView = v.findViewById(R.id.firstLine)
        var txtFooter: TextView = v.findViewById(R.id.secondLine)
        var layout: View = v

    }

    fun add(position: Int, item: PersonnageInfo) {
        values.add(position, item)
        notifyItemInserted(position)
    }

    fun remove(position: Int) {
        values.removeAt(position)
        notifyItemRemoved(position)
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        // create a new view
        contextParentRow = parent.context
        val inflater = LayoutInflater.from(
            parent.context
        )
        val v: View = inflater.inflate(R.layout.row_layout, parent, false)
        // set the view's size, margins, paddings and layout parameters
        return ViewHolder(v)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        val name = values[position]
        if (name.getImage() != null && !name.getImage().equals("")) contextParentRow?.let {
            Glide.with(it)
                .load(name.getImage()).circleCrop().into(holder.imageView)
        }
        holder.txtHeader.text = name.getName()
        holder.txtHeader.setOnClickListener{
            v ->
            var intent = Intent(holder.layout.context, PersonnageInfoActivity::class.java).apply {
                putExtra("name", name.getName())
                putExtra("status",name.getStatus())
                putExtra("species",name.getSpecies())
                putExtra("origin",name.getOrigin()?.getName())
                putExtra("location",name.getLocation()?.getName())
                putExtra("image",name.getImage())
            }
            holder.layout.context.startActivity(intent)
        }
        holder.txtFooter.text = "Origin: ${name.getOrigin()?.getName()}"
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount(): Int {
        return values.size
    }

}