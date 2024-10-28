package br.com.mizaeldouglas.app_dummy_json_mvvm_hilt.domain.respository

import br.com.mizaeldouglas.app_dummy_json_mvvm_hilt.domain.model.User

interface IUserRepository {
    suspend fun getUsers() : List<User>
}