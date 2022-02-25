package com.example.myassignment

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    private lateinit var editTextTo: EditText
    private lateinit var editTextSubject: EditText
    private lateinit var editTextMessage: EditText
    private lateinit var btnSend: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        print("onCreate")

        editTextTo = findViewById(R.id.edit_email_recipient)
        editTextSubject = findViewById(R.id.edit_email_subject)
        editTextMessage = findViewById(R.id.edit_email_message)
        btnSend = findViewById(R.id.btnSend)

        btnSend.setOnClickListener { sendMail() }
    }

    override fun onStart() {
        super.onStart()
        print("onStart")
    }

    override fun onResume() {
        super.onResume()
        print("onResume")
    }

    override fun onPause() {
        super.onPause()
        print("onPause")
    }

    override fun onStop() {
        super.onStop()
        print("onStop")
    }

    override fun onRestart() {
        super.onRestart()
        print("onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        print("onDestroy")
    }

    fun print(msg: String) {
        Log.d("Activity State ", msg)
    }

    private fun sendMail() {


        var recipients = editTextTo.text.toString().trim()
        var subject = editTextSubject.text.toString().trim()
        var message = editTextMessage.text.toString().trim()

        var intent = Intent(Intent.ACTION_SEND)
        intent.data = Uri.parse("mailto:")
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_EMAIL, recipients)
        intent.putExtra(Intent.EXTRA_SUBJECT, subject)
        intent.putExtra(Intent.EXTRA_TEXT, message)


        try {

            startActivity(Intent.createChooser(intent, "Use this app always"))
        }
        catch (e: Exception) {
            Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
        }
    }
}