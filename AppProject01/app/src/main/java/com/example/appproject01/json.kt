// To parse the JSON, install Klaxon and do:
//
//   val welcome5 = Welcome5.fromJson(jsonString)

package com.example.appproject01

import com.beust.klaxon.*

private val klaxon = Klaxon()

data class json (
    val type: String,
    val status: String,
    val temp: String,
    val time: String,
    val station: String
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<json>(json)
    }
}
