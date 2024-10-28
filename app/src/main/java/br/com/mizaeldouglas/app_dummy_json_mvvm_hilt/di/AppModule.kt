package br.com.mizaeldouglas.app_dummy_json_mvvm_hilt.di

import br.com.mizaeldouglas.app_dummy_json_mvvm_hilt.data.remote.DummyAPI
import br.com.mizaeldouglas.app_dummy_json_mvvm_hilt.data.repository.UserRepositoryImpl
import br.com.mizaeldouglas.app_dummy_json_mvvm_hilt.domain.respository.IUserRepository
import br.com.mizaeldouglas.app_dummy_json_mvvm_hilt.domain.useCase.GetUsersUseCase
import br.com.mizaeldouglas.app_dummy_json_mvvm_hilt.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providerRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun providerDummyAPI(retrofit: Retrofit): DummyAPI {
        return retrofit.create(DummyAPI::class.java)
    }

    @Provides
    @Singleton
    fun providerUserRepository(dummyAPI: DummyAPI): IUserRepository {
        return UserRepositoryImpl(dummyAPI)
    }

    @Provides
    @Singleton
    fun providerUserUseCase(userRepository: IUserRepository): GetUsersUseCase {
        return GetUsersUseCase(userRepository)
    }
}