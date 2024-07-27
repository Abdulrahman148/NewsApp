package com.aah.newsapp.ui.components

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.aah.newsapp.R
import kotlin.coroutines.coroutineContext

class LoadingDialog(private val fragment: Fragment) {

    private lateinit var dialog: AlertDialog

    fun showDialog() {

        val builder = AlertDialog.Builder(fragment.requireContext())
        val inflater: LayoutInflater = fragment.layoutInflater

        builder.setView(inflater.inflate(R.layout.loading_dialog, null))
        builder.setCancelable(false)

        dialog = builder.create()
        dialog.show()

    }

    fun hideDialog() {
        dialog.dismiss()
    }


}