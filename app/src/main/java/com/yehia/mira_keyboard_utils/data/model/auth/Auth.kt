package com.yehia.mira_keyboard_utils.data.network.login_models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter=true)
data class Auth(
    @Json(name="success") val success: Boolean,
    @Json(name="message") val message: String,
    @Json(name="data") val data: AuthData
)