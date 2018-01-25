package controller

import com.google.gson.Gson
import modal.Base

fun getHello(): String {

    val doktor = Base("Doktor", "Gallifrey")
    val gson = Gson()
    return gson.toJson(doktor)
}