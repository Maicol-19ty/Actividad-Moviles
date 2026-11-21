package cue.edu.co.myapplication.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import cue.edu.co.myapplication.model.Product

class ProductViewModel : ViewModel() {
    private val _products = mutableStateListOf<Product>()
    val products: List<Product> get() = _products

    fun addProduct(product: Product) {
        _products.add(product)
    }
}
