package com.ankkumar.trendingrepo.utils


import android.content.Context
import android.net.ConnectivityManager

class CheckNetwork {
    companion object {

        fun isNetworkConnected(context: Context?): Boolean {
            val cm = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkInfo = cm.activeNetworkInfo
            return networkInfo != null && networkInfo.isConnectedOrConnecting
        }
    }
}