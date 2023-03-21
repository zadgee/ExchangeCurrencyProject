package repository

import retrofit.Cashmoney
import retrofit.WithOutCash
import retrofit2.Response


interface Repository {
    suspend fun getCash():Response<Cashmoney>
    suspend fun getWithOutMoney():Response<WithOutCash>
}