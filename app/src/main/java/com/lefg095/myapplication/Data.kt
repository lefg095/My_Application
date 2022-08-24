package com.lefg095.myapplication

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Data(
    var id: Int? = null,
    var name: String? = null,
    var description: String? = null
): Parcelable