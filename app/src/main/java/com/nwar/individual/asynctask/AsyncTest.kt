package com.nwar.individual.asynctask

import android.os.AsyncTask
import android.util.Log
import android.widget.TextView
import kotlin.system.exitProcess

class AsyncTest(val displayTime : TextView) : AsyncTask<String, Int, Int>() {
    var isRunning = false
    var count = 0

    override fun onPreExecute() {
        super.onPreExecute()
        isRunning = true
    }

    fun stop(){
        isRunning = false
    }

    override fun doInBackground(vararg params: String?): Int {
        while(isRunning){
            count++
            publishProgress(count)
            Thread.sleep(1)
        }
        return 0
    }

    override fun onProgressUpdate(vararg values: Int?) {
        super.onProgressUpdate(*values)
        val time = values.get(0)
        displayTime.text = time.toString()
    }

    override fun onPostExecute(result: Int) {
        super.onPostExecute(result)
    }

    override fun onCancelled() {
        super.onCancelled()
        Log.e("캔슬","캔슬")
    }
}