package repository
import retrofit.Cashmoney
import retrofit.MoneyServiceAPI
import retrofit.WithOutCash
import retrofit2.Response
import javax.inject.Inject

class RepositoryImpl@Inject constructor(private val api: MoneyServiceAPI) : Repository {
    override suspend fun getCash(): Response<Cashmoney> = api.getCash()


    override suspend fun getWithOutMoney(): Response<WithOutCash> = api.getwithoutmoney()
}