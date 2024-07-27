package com.salvador_garro.models

import kotlinx.serialization.Serializable

@Serializable
class User(val id: Int, val name: String, val age: Int, val email: String) {
}