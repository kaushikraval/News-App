package com.nytimesapp.samp.util

import android.content.Context
import android.widget.Toast

// extention function for toast
fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}