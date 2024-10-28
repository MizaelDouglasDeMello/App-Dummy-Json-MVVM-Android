package br.com.mizaeldouglas.app_dummy_json_mvvm_hilt.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.mizaeldouglas.app_dummy_json_mvvm_hilt.domain.model.User
import br.com.mizaeldouglas.app_dummy_json_mvvm_hilt.domain.useCase.GetUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(
    private val usersUseCase: GetUsersUseCase
) : ViewModel() {

    // privado
    private val _users = MutableLiveData<List<User>>()

    //publico
    val user: LiveData<List<User>>
        get() = _users


    init {
        getUsers()
    }

    fun getUsers() {
        viewModelScope.launch {
            val listUser = usersUseCase()
            _users.postValue(listUser)
        }
    }
}