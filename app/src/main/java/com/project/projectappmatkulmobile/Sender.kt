package com.project.projectappmatkulmobile

import android.app.Application
import com.android.volley.*
import com.android.volley.toolbox.Volley

class Sender : Application() {
    override fun onCreate() {
        super.onCreate()
         instance = this
    }

    val requestQueue : RequestQueue?=null
    get() {
        if(field==null){
            return Volley.newRequestQueue(applicationContext)
        }
        return field
    }

    fun <T> addToRequestQueue(request: Request<T>){
        request.tag = TAG
        requestQueue?.add(request)
    }

    companion object{
        private val TAG = Sender :: class.java.simpleName
        @get:Synchronized var instance:Sender?=null
        private set
    }

}