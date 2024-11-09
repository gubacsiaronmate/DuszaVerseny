package com.gubo.duszaverseny.components

import android.content.Context
import android.view.MenuItem
import android.widget.Button
import android.widget.PopupMenu
import com.gubo.duszaverseny.R

class DropdownHelper {
    fun showDropdown(context: Context, button: Button) {
        val popupMenu = PopupMenu(context, button)

        // Inflate the menu with options
        val inflater = popupMenu.menuInflater
        inflater.inflate(R.menu.landing_dropdown, popupMenu.menu)

        // Handle item clicks in the dropdown
        popupMenu.setOnMenuItemClickListener { item: MenuItem ->
            // Change the button text to the selected item
            button.text = item.title
            true
        }

        // Show the PopupMenu
        popupMenu.show()
    }
}
