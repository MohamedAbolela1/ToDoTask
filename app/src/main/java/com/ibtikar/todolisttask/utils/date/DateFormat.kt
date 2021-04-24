package com.ibtikar.todolisttask.utils.date

import java.text.SimpleDateFormat
import java.util.*

object DateFormat {
    const val FORMAT_EEE_MMM_DD_YYYY_H_MM_SS = "hh:mm a dd/MM/yyyy"

    fun formatDateToString(
        date: Date,
        desiredFormat: String,
        locale: Locale = Locale.ENGLISH
    ): String? {
        return try {
            val format = SimpleDateFormat(desiredFormat, locale)
            return format.format(date)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}