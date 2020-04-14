package com.example.coderswag.Adapters

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.contentValuesOf
import androidx.recyclerview.widget.RecyclerView
import com.example.coderswag.Model.Product
import com.example.coderswag.R
import kotlinx.android.synthetic.main.product_list_item.view.*

class ProductRecycleAdapter(val context: Context, val products: List<Product>) : RecyclerView.Adapter<ProductRecycleAdapter.ProductHolder>() {
    


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.product_list_item , parent, false)
        return  ProductHolder(view)

    }

    override fun getItemCount(): Int {
       return  products.count()
    }

    override fun onBindViewHolder(productHolder: ProductHolder, position: Int) {
        productHolder?.bindProduct(products[position], context)
    }

    inner class ProductHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val productImage = itemView.findViewById<ImageView>(R.id.productImage)
        val productPrice = itemView.findViewById<TextView>(R.id.productTextPrice)
        val productName= itemView.findViewById<TextView>(R.id.productTextName)

        fun bindProduct(product: Product, context: Context) {
            val resourceId = context.resources.getIdentifier(product.image, "drawable", context.packageName)
            productImage?.setImageResource(resourceId)
            productPrice.text = product.price
            productName.text = product.title
        }

    }
}