package com.nyx.kls_financeaccounting

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.nyx.kls_financeaccounting.data.AppDatabase
import com.nyx.kls_financeaccounting.data.RepositoryImpl

class MainActivity : AppCompatActivity(), FinanceCategoryClickListener {
    private lateinit var recycler: RecyclerView
    private lateinit var addButton: Button
    private lateinit var viewModel: MainViewModel

    private fun initDatabase() {
        val database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "app_database"
        ).build()

        viewModel = MainViewModel(
            repository = RepositoryImpl(
                dao = database.categoryDao()
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initDatabase()

        recycler = findViewById(R.id.recycler)
        recycler.layoutManager = LinearLayoutManager(this)

        addButton = findViewById(R.id.add_button)
        addButton.setOnClickListener { showAddCategoryDialog() }

        observeCategories()
    }

    private fun observeCategories() {
        viewModel.getCategories().observe(
            this
        ) { categories ->
            // TODO: refactor
            recycler.adapter = FinanceCategoryAdapter(categories, this)
        }
    }

    private fun showAddCategoryDialog() {
        val dialog = AddCategoryDialog(
            onCategoryCreated = { category ->
                onCategoryCreated(category)
            }
        )
        dialog.show(supportFragmentManager, "tag")
    }

    private fun onCategoryCreated(category: FinanceCategory) {
        viewModel.createCategory(category)
    }

    override fun categoryClick(id: Int) {}

    override fun onDeletePressed(category: FinanceCategory) {
        viewModel.deleteCategory(category)
    }
}