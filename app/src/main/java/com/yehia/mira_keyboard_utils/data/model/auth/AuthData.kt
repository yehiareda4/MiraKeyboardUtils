package com.yehia.mira_keyboard_utils.data.network.login_models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter=true)
data class AuthData(

    @Json(name="token") val token: TokenModel,
    @Json(name="user") val user: UserModel
)