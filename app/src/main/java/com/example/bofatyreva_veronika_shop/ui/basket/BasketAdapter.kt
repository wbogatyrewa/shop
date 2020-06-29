package com.example.bofatyreva_veronika_shop.ui.basket

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bofatyreva_veronika_shop.R
import com.example.bofatyreva_veronika_shop.domain.model.Product
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_product.*

class BasketAdapter(
    private val onDeleteClick: (Product) -> Unit
): RecyclerView.Adapter<BasketAdapter.ViewHolder>() {

    private var basketList: List<Product> = listOf()

    fun setData(basketList: List<Product>) {
        this.basketList = basketList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        )

    override fun getItemCount(): Int = basketList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(basketList[position])
    }

    inner class ViewHolder(override val containerView: View): RecyclerView.ViewHolder(containerView), LayoutContainer {

        @SuppressLint("SetTextI18n")
        fun bind(product: Product) {
            productTv.text = product.getProductName()
            priceTv.text = "${product.getPrice()} ₽"
            discountTv.text = "${product.getDiscountInPercent()} %"
            deleteIv.setOnClickListener {
                onDeleteClick(product)
            }
        }
    }
}