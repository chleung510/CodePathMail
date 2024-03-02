package com.example.codepathmail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// 1. Email Adapter acts as constructor accepting list of emails as props(input)
// 2. Extends Recycler adapter class
class EmailAdapter(private val emails : List<Email>) : RecyclerView.Adapter<EmailAdapter.ViewHolder>() {
    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        // Create variables of views for each row(ViewHolder) without specifying
        val senderTv: TextView
        val titleTv: TextView
        val summaryTv: TextView

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each sub-view
        init {
            // Set variables to references of views
            senderTv = itemView.findViewById(R.id.senderTv)
            titleTv = itemView.findViewById(R.id.titleTv)
            summaryTv = itemView.findViewById(R.id.summaryTv)
        }
    }

    // For inflating item's layout(individual item on the list)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        //Inflate the (actual) custom Layout
        val contactView = inflater.inflate(R.layout.email_item, parent, false)
        // return the ViewHolder instance
        return ViewHolder(contactView)
    }

    // Bind data to the ViewHolde
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the data model based on position
        val email = emails.get(position)
        // set the views in the ViewHolder to the data of the data model
        holder.senderTv.text = email.sender
        holder.titleTv.text = email.title
        holder.summaryTv.text = email.summary
    }

    // To get size of the list of items(emails)
    override fun getItemCount(): Int {
        return emails.size
    }
}
