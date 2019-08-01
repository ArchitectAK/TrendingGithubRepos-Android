package com.ankkumar.trendingrepo.utils


import java.io.IOException

class NetworkException : IOException() {

    override val message: String?
        get() = "No Internet"
}