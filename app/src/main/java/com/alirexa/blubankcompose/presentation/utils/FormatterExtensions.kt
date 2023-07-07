package com.alirexa.blubankcompose.presentation.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.alirexa.blubankcompose.R
import ir.huri.jcal.JalaliCalendar
import java.text.NumberFormat
import java.time.LocalDateTime
import java.time.LocalTime
import java.util.Calendar
import java.util.Date
import java.util.Locale

// Number Formatter
@Composable
fun Long.asCurrency() = stringResource(id = R.string.amount_in_rials, format().toPersianDigits())

fun Long.format(): String {
    var numberString = NumberFormat.getNumberInstance(Locale.US)
        .format(this)
        .replace(",", "٫")

    if (numberString[0] == '-') {
        numberString = numberString.substring(1, numberString.length)
        numberString = "$numberString-"
    }
    return numberString
}

fun String.toPersianDigits(): String {
    var result = this
    (LATIN_DIGITS.indices).forEach { index ->
        result = result
            .replace(LATIN_DIGITS[index], PERSIAN_DIGITS[index])
            .replace(ARABIC_DIGITS[index], PERSIAN_DIGITS[index])
    }
    return result
}

private val PERSIAN_DIGITS = listOf('۰', '۱', '۲', '۳', '۴', '۵', '۶', '۷', '۸', '۹')
private val ARABIC_DIGITS = listOf('٠', '١', '٢', '٣', '٤', '٥', '٦', '٧', '٨', '٩')
private val LATIN_DIGITS = listOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9')



// Date Formatter

fun Date.toJalali() = JalaliCalendar(this)

@Composable
fun Date.dateTimeString(): String {
    val jalaliCalendar = toJalali()
    return stringResource(
        R.string.date_time_format,
        jalaliCalendar.dayOfWeekString,
        jalaliCalendar.day,
        jalaliCalendar.monthString,
        jalaliCalendar.year,
        this.hours,
        this.minutes,
    ).toPersianDigits()
}