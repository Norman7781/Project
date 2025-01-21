package com.example.project.DataStore

import android.database.sqlite.SQLiteDatabase

class UserDaoImpl(private val database: SQLiteDatabase) : UserDao {

    override fun insertUser(user: User) {
        val sql = "INSERT INTO users (email, password) VALUES (?, ?)"
        val statement = database.compileStatement(sql)
        statement.bindString(1, user.email)
        statement.bindString(2, user.password)
        statement.executeInsert()
    }

    override fun getUser(email: String, password: String): User? {
        val sql = "SELECT * FROM users WHERE email = ? AND password = ?"
        val cursor = database.rawQuery(sql, arrayOf(email, password))
        return if (cursor.moveToFirst()) {
            val userEmail = cursor.getString(cursor.getColumnIndexOrThrow("email"))
            val userPassword = cursor.getString(cursor.getColumnIndexOrThrow("password"))
            cursor.close()
            User(userEmail, userPassword)
        } else {
            cursor.close()
            null
        }
    }
}