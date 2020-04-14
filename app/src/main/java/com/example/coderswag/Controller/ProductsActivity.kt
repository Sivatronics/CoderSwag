package com.example.coderswag.Controller

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import com.example.coderswag.Adapters.ProductRecycleAdapter
import com.example.coderswag.R
import com.example.coderswag.Services.DataService
import com.example.coderswag.Utilitizes.EXTRAS_CATEGORY
import kotlinx.android.synthetic.main.activity_products.*

class ProductsActivity : AppCompatActivity() {

    lateinit var productAdapter: ProductRecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

       val categoryType = intent.getStringExtra(EXTRAS_CATEGORY)

        println("Category Name $categoryType")

        val productAdapter = ProductRecycleAdapter(this, DataService.getProducts(categoryType))

        var spanCount= 2
         val orientation = resources.configuration.orientation
        if(orientation == Configuration.ORIENTATION_LANDSCAPE)
            spanCount = 3

        val screenSize = resources.configuration.screenWidthDp
        if(screenSize > 720)
            spanCount = 3

        val layoutManager = GridLayoutManager(this, spanCount)

        productListView.layoutManager = layoutManager
        productListView.adapter = productAdapter
    }
}
