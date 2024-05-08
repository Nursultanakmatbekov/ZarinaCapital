package com.ren.forexapi.api.models

import com.google.gson.annotations.SerializedName

data class LoginParamsDTO(
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String,
)