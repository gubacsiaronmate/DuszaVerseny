package com.gubo.duszaverseny.components

import android.content.Context
import android.util.Log
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.PopupMenu
import android.widget.TextView
import com.gubo.duszaverseny.R

class DropdownHelper {
    fun showDropdown(context: Context, linearLayout: LinearLayout, callback: (String) -> Unit) {
        val popupMenu = PopupMenu(context, linearLayout)

        val inflater = popupMenu.menuInflater
        inflater.inflate(R.menu.landing_dropdown, popupMenu.menu)

        popupMenu.setOnMenuItemClickListener { item: MenuItem ->
            linearLayout.findViewById<TextView>(R.id.selectorText).text = item.title
            val chosenActivity = item.title.toString()
            Log.d("Test", "(DropdownHelper) Chosen activity: $chosenActivity")
            callback(chosenActivity)
            true
        }

        popupMenu.show()
    }
}