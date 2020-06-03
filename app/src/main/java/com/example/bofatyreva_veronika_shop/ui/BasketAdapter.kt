package com.example.bofatyreva_veronika_shop.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bofatyreva_veronika_shop.R
import com.example.bofatyreva_veronika_shop.model.Product
import kotlinx.android.synthetic.main.item_category.view.deleteIv
import kotlinx.android.synthetic.main.item_product.view.*

class BasketAdapter(
    private val onDeleteClick: (Product) -> Unit
): RecyclerView.Adapter<BasketAdapter.ViewHolder>() {

    private var basketList: List<Product> = listOf()

    fun setData(basketList: List<Product>) {
        this.basketList = basketList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasketAdapter.ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        )

    override fun getItemCount(): Int = basketList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(basketList[position])
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        @SuppressLint("SetTextI18n")
        fun bind(product: Product) {
            itemView.productTv.text = product.getProductName()
            itemView.priceTv.text = "${product.getPrice()} ₽"
            itemView.discountTv.text = "${product.getDiscountInPercent()} %"
            itemView.deleteIv.setOnClickListener {
                onDeleteClick(product)
            }
        }
    }
}