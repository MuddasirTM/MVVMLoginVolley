package com.itronix.mvvmloginregistrationvolleykotlin.network

import android.content.Context
import com.android.volley.toolbox.StringRequest
import com.itronix.mvvmloginregistrationvolleykotlin.MyApplication

class AuthRepository(private val context: Context = MyApplication.getAppContext()) {

    fun login(email: String, password: String, callback: (String) -> Unit) {
        val url = "https://yourapi.com/login" //-- replace with your API endpoint
        val request = object : StringRequest(
            Method.POST, url,
            { response -> callback(response) },
            { error -> callback("Error: ${error.message}") }
        ) {
            override fun getParams(): Map<String, String> =
                hashMapOf("email" to email, "password" to password)

            override fun getHeaders(): Map<String, String> {
                val headers = HashMap<String, String>()
                headers["Content-Type"] = "application/x-www-form-urlencoded"
                return headers
            }
        }
        VolleySingleton.getInstance(context).addToRequestQueue(request)
    }

    fun register(email: String, password: String, callback: (String) -> Unit) {
        val url = "https://yourapi.com/register" //replace with your API endpoint
        val request = object : StringRequest(
            Method.POST, url,
            { response -> callback(response) },
            { error -> callback("Error: ${error.message}") }
        ) {
            override fun getParams(): Map<String, String> =
                hashMapOf("email" to email, "password" to password)

            override fun getHeaders(): Map<String, String> {
                val headers = HashMap<String, String>()
                headers["Content-Type"] = "application/x-www-form-urlencoded"
                return headers
            }
        }
        VolleySingleton.getInstance(context).addToRequestQueue(request)
    }
}