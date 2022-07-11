package com.garibyan.armen.tbc_task_9

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    var name: String,
    var surname: String,
    var email: String
) : Parcelable