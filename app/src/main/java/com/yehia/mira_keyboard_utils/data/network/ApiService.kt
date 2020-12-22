package com.yehia.mira_keyboard_utils.data.network


import com.yehia.mira_keyboard_utils.data.network.login_models.Auth
import kotlinx.coroutines.Deferred
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


interface ApiService {
    @FormUrlEncoded
    @POST("login")
    fun Login(
        @Field("phone") phone: String,
        @Field("password") password: String,
        @Field("language") language: String,
        @Field("notification_id") notification_id: Int,
        @Field("device_type") device_type: String,
        @Field("os_version") os_version: Int
    ): Deferred<Auth>

}


