package br.com.mizaeldouglas.app_dummy_json_mvvm_hilt.presentation.viewmodel

import androidx.lifecycle.ViewModel
import br.com.mizaeldouglas.app_dummy_json_mvvm_hilt.domain.useCase.GetUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(
    private val usersUseCase: GetUsersUseCase
) : ViewModel() {


}