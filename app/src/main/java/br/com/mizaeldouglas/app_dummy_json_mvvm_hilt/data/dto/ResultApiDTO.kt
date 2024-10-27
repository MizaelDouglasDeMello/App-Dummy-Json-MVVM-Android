package br.com.mizaeldouglas.app_dummy_json_mvvm_hilt.data.dto

data class ResultApiDTO(
    val limit: Int,
    val skip: Int,
    val total: Int,
    val users: List<UserDTO>
)