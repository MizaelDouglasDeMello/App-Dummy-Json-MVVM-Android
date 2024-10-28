package br.com.mizaeldouglas.app_dummy_json_mvvm_hilt.domain.useCase

import br.com.mizaeldouglas.app_dummy_json_mvvm_hilt.domain.model.User
import br.com.mizaeldouglas.app_dummy_json_mvvm_hilt.domain.respository.IUserRepository
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(
    private val repository: IUserRepository
) {
    suspend operator fun invoke(): List<User> {
        return try {
            repository.getUsers()

        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }
}