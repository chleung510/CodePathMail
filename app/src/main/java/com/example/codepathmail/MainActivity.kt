package com.example.codepathmail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var emails : List<Email>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val emailsRv = findViewById<RecyclerView>(R.id.emailsRv)
        // call getEmails and set it to emails
        emails = EmailFetcher.getEmails()
        val adapter = EmailAdapter(emails)
        // attach the adapter to Email recycleView's adapter
        emailsRv.adapter = adapter
        // Set up the layOutManager for positioning the items
        emailsRv.layoutManager = LinearLayoutManager(this)

        findViewById<Button>(R.id.loadMoreBtn).setOnClickListener {
            // Fetch next 5 emails
            val newEmails = EmailFetcher.getNext5Emails()
            // Add new emails to existing list of emails
            (emails as MutableList<Email>).addAll(newEmails)
            // Notify the adapter there's new emails so the RecyclerView layout is updated
            adapter.notifyDataSetChanged()
        }

    }
}