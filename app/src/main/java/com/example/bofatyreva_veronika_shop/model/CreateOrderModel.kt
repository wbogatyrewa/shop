package com.example.bofatyreva_veronika_shop.model

/*
* Модель для создания заказа
 */

data class CreateOrderModel(
    var Family: String = "",

    var Name: String = "",

    var Otchestvo: String = "",

    var Phone: String = ""
)