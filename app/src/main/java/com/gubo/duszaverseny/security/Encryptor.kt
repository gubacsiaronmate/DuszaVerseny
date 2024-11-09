package com.gubo.duszaverseny.security

import org.mindrot.jbcrypt.BCrypt

class Encryptor {
    private val salt = BCrypt.gensalt()

    fun encrypt(password: String): String =
        BCrypt.hashpw(password, salt)

    fun verify(password: String, hashedPassword: String): Boolean =
        BCrypt.checkpw(password, hashedPassword)
}