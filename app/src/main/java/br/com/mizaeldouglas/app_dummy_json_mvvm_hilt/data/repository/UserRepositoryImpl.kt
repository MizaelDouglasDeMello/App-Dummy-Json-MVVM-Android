package br.com.mizaeldouglas.app_dummy_json_mvvm_hilt.data.repository

import br.com.mizaeldouglas.app_dummy_json_mvvm_hilt.data.dto.toUser
import br.com.mizaeldouglas.app_dummy_json_mvvm_hilt.data.remote.DummyAPI
import br.com.mizaeldouglas.app_dummy_json_mvvm_hilt.domain.model.User
import br.com.mizaeldouglas.app_dummy_json_mvvm_hilt.domain.respository.IUserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val dummyAPI: DummyAPI
) : IUserRepository {


    override suspend fun getUsers(): List<User> {

        try {
            val response = dummyAPI.getUsers()

            if (response.isSuccessful && response.body() != null) {
                val resultApiDTO = response.body()
                val listUser = resultApiDTO?.users
                if (listUser != null) {
                    return listUser.map {
                        it.toUser()
                    }
                }
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
        return emptyList()
    }
}