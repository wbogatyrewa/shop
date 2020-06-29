package com.example.bofatyreva_veronika_shop.domain

import org.json.JSONArray
import retrofit2.http.GET

interface MainApi {

    @GET("products/all/default")
    fun allProducts(): JSONArray
}
