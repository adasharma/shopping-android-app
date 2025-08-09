package com.vishalgaur.shoppingapp.data.source.remote

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.vishalgaur.shoppingapp.data.Product
import com.vishalgaur.shoppingapp.data.Result
import com.vishalgaur.shoppingapp.data.source.ProductDataSource

class NoopProductsRemoteDataSource : ProductDataSource {
	private val observable = MutableLiveData<Result<List<Product>>?>(Result.Success(emptyList()))

	override suspend fun refreshProducts() {
		observable.postValue(Result.Success(emptyList()))
	}

	override fun observeProducts(): LiveData<Result<List<Product>>?> = observable

	override fun observeProductsByOwner(ownerId: String): LiveData<Result<List<Product>>?> =
		observable

	override suspend fun getAllProducts(): Result<List<Product>> = Result.Success(emptyList())

	override suspend fun getAllProductsByOwner(ownerId: String): Result<List<Product>> =
		Result.Success(emptyList())

	override suspend fun getProductById(productId: String): Result<Product> =
		Result.Error(Exception("Not available in NOOP"))

	override suspend fun insertProduct(newProduct: Product) {}

	override suspend fun updateProduct(proData: Product) {}

	override suspend fun deleteProduct(productId: String) {}

	override suspend fun uploadImage(uri: Uri, fileName: String): Uri? = null

	override fun deleteImage(imgUrl: String) {}

	override fun revertUpload(fileName: String) {}

	override suspend fun insertMultipleProducts(products: List<Product>) {}

	override suspend fun deleteAllProducts() {}
}
