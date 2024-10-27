package br.com.mizaeldouglas.app_dummy_json_mvvm_hilt.data.remote

import br.com.mizaeldouglas.app_dummy_json_mvvm_hilt.data.dto.ResultApiDTO
import retrofit2.Response
import retrofit2.http.GET

interface DummyAPI {

    // https://dummyjson.com/users
    @GET("users")
    suspend fun getUsers() : Response<ResultApiDTO>
}