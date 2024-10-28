package br.com.mizaeldouglas.app_dummy_json_mvvm_hilt.di

import br.com.mizaeldouglas.app_dummy_json_mvvm_hilt.data.remote.DummyAPI
import br.com.mizaeldouglas.app_dummy_json_mvvm_hilt.data.repository.UserRepositoryImpl
import br.com.mizaeldouglas.app_dummy_json_mvvm_hilt.domain.respository.IUserRepository
import br.com.mizaeldouglas.app_dummy_json_mvvm_hilt.domain.useCase.GetUsersUseCase
import br.com.mizaeldouglas.app_dummy_json_mvvm_hilt.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(ViewComponent::class)
object AppModule {

    @Provides
    fun providerRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    @Provides
    fun providerDummyAPI(retrofit: Retrofit): DummyAPI {
        return retrofit.create(DummyAPI::class.java)
    }

    @Provides
    fun providerUserRepository(dummyAPI: DummyAPI): IUserRepository {
        return UserRepositoryImpl(dummyAPI)
    }

    @Provides
    fun providerUserUseCase(userRepository: IUserRepository): GetUsersUseCase {
        return GetUsersUseCase(userRepository)
    }


}