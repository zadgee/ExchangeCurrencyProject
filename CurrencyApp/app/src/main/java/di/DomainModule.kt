package di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import repository.Repository
import repository.RepositoryImpl
import retrofit.MoneyServiceAPI
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {
    @Provides
    @Singleton
    fun provideRepository(api: MoneyServiceAPI):Repository{
return RepositoryImpl(
    api
)
    }
}