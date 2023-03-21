package retrofit

import retrofit2.Response
import retrofit2.http.GET

interface MoneyServiceAPI {
    @GET("p24api/pubinfo?exchange&coursid=5")
    suspend fun getCash() : Response<Cashmoney>

    @GET("p24api/pubinfo?exchange&coursid=11")
    suspend fun getwithoutmoney() : Response<WithOutCash>
}