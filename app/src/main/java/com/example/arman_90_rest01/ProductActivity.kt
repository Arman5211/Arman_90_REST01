package com.example.arman_90_rest01

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.arman_90_rest01.adapder.ProductAdapter
import com.example.arman_90_rest01.viewmodel.ProductViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ProductActivity : AppCompatActivity() {

    private lateinit var productViewModel: ProductViewModel
    private lateinit var productAdapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        productViewModel = ViewModelProvider(this).get(ProductViewModel::class.java)
        productAdapter = ProductAdapter(emptyList())

        val refreshBtn: FloatingActionButton = findViewById(R.id.refreshBtn)

        refreshBtn.setOnClickListener{
            startActivity(Intent(this@ProductActivity,ProductActivity::class.java))
            finish()
        }

        val recyclerView: RecyclerView = findViewById(R.id.productRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        productViewModel.products.observe(this, Observer{ product->
            productAdapter = ProductAdapter(product)
            recyclerView.adapter = productAdapter
        })
    }
}