package com.example.project.DataStore

interface UserDao {
    fun insertUser(user: User)
    fun getUser(email: String, password: String): User?
//    fun updateUser(user: User)
//    fun deleteUser(user: User)

}