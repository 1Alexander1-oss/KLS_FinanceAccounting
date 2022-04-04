package com.nyx.kls_financeaccounting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.DialogFragment

class AddCategoryDialog(
    private val onCategoryCreated: (FinanceCategory) -> Unit,
) : DialogFragment() {
    private lateinit var okButton: Button
    private lateinit var categoryNameInput: EditText

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.add_category_dialog, container, false)

        okButton = view.findViewById(R.id.ok_button)
        categoryNameInput = view.findViewById(R.id.category_name)

        okButton.setOnClickListener {
            val categoryName = categoryNameInput.text.toString()

            onCategoryCreated(
                FinanceCategory(
                    name = categoryName,
                    ratio = 13.456
                )
            )
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT,
        )
    }
}