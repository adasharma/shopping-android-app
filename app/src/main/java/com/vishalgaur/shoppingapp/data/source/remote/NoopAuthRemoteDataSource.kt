package com.vishalgaur.shoppingapp.data.source.remote

import com.vishalgaur.shoppingapp.data.Result
import com.vishalgaur.shoppingapp.data.UserData
import com.vishalgaur.shoppingapp.data.source.UserDataSource

class NoopAuthRemoteDataSource : UserDataSource {
	override suspend fun addUser(userData: UserData) {}

	override suspend fun getUserById(userId: String): Result<UserData?> = Result.Success(null)

	override suspend fun getOrdersByUserId(userId: String): Result<List<UserData.OrderItem>?> =
		Result.Success(emptyList())

	override suspend fun getAddressesByUserId(userId: String): Result<List<UserData.Address>?> =
		Result.Success(emptyList())

	override suspend fun getLikesByUserId(userId: String): Result<List<String>?> =
		Result.Success(emptyList())
}
