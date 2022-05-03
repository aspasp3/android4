package ru.netology.nmedia.dto

import kotlin.math.round

class TransformNum {

    fun transformNum(number:Double):String{
        val textNum:String = when{
            ((number > 999) && (number < 1000000)) -> (round(number/100)/10).toString()+"K"
            (number > 999999) -> (round(number/100000)/10).toString()+"M"
            else -> number.toInt().toString()
        }
        return textNum
    }
}