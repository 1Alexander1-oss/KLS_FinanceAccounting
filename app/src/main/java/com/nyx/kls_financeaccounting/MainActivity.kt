package com.nyx.kls_financeaccounting

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), FinanceCategoryClickListener {

    private lateinit var recycler: RecyclerView
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.add_button)

        recycler = findViewById(R.id.recycler)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = FinanceCategoryAdapter(financeCategories, this)
    }

    private val financeCategories = listOf(
        FinanceCategory(1, "Food", 45.0),
        FinanceCategory(2, "Clothe", 35.0),
        FinanceCategory(3, "Rent", 20.0)
    )

    override fun categoryClick(id: Int) {}

}