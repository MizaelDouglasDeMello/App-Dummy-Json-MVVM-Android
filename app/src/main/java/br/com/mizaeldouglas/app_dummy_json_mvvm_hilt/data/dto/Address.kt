package br.com.mizaeldouglas.app_dummy_json_mvvm_hilt.data.dto

data class Address(
    val address: String,
    val city: String,
    val coordinates: Coordinates,
    val country: String,
    val postalCode: String,
    val state: String,
    val stateCode: String
)