package br.com.mizaeldouglas.app_dummy_json_mvvm_hilt.data.dto

data class Bank(
    val cardExpire: String,
    val cardNumber: String,
    val cardType: String,
    val currency: String,
    val iban: String
)