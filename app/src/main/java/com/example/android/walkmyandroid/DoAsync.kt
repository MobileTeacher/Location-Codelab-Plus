package com.example.android.walkmyandroid

import android.os.AsyncTask

internal class DoAsync(val action: ()-> Unit): AsyncTask<Unit, Unit, Unit>(){
    init {
        execute()
    }

    override fun doInBackground(vararg p0: Unit?) {
        action()
    }
}