package com.yehia.mira_keyboard_utils.data.network.login_models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)

data class UserModel (

    @Json(name ="id") val id : Int,
    @Json(name ="name") val name : String,
    @Json(name ="phone") val phone : Int,
    @Json(name ="role") val role : Int,
    @Json(name ="language") val language : String,
    @Json(name ="device_id") val device_id : Int,
    @Json(name ="notification_id") val notification_id : Int,
    @Json(name ="device_type") val device_type : String,
    @Json(name ="os_version") val os_version : Double,
    @Json(name ="created_at") val created_at : String,
    @Json(name ="updated_at") val updated_at : String
)