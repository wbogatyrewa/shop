package com.example.bofatyreva_veronika_shop.domain

interface ViewedProductDao {

    /**
     * save this product id as viewed
     * */

    fun addProduct(productId: Long)

    /**
     * get all viewed product ids
     * might be empty
     * */

    fun getAllProduct(): List<Long>
}