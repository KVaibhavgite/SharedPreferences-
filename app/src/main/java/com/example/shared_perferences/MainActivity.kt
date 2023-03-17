package com.example.shared_perferences

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.util.*
import android.content.SharedPreferences
import android.provider.ContactsContract.CommonDataKinds.Email

import android.provider.ContactsContract.CommonDataKinds.Phone







class MainActivity : AppCompatActivity() {
    //variable declear
    private lateinit var name: EditText
    private lateinit var age: EditText
    private lateinit var email: EditText
    private lateinit var name1: EditText
    private lateinit var age1: EditText
    private lateinit var email1: EditText
    private  lateinit var  btn:Button
    private  lateinit var  btn1:Button

    private lateinit var sharedpreferences: SharedPreferences
    val MyPREFERENCES = "MyPrefs"
    val Name = "nameKey"
    val Phone = "phoneKey"
    val Email = "emailKey"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        name = findViewById(R.id.editname)
        age = findViewById(R.id.editage)
        email = findViewById(R.id.editemail)

        name1 = findViewById(R.id.editname1)
        age1 = findViewById(R.id.editage2)
        email1 = findViewById(R.id.editemail3)

        sharedpreferences = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE)
        val editor = sharedpreferences.edit()

        btn = findViewById(R.id.button)
        btn1 = findViewById(R.id.button1)


        btn.setOnClickListener{
            val n: String = name1.getText().toString()
            val ph: String = age1.getText().toString()
            val e: String = email1.getText().toString()



            editor.putString(Name, n)
            editor.putString(Phone, ph)
            editor.putString(Email, e)
            editor.commit()
            Toast.makeText(this@MainActivity, "Thanks", Toast.LENGTH_LONG).show()
        }

        btn1.setOnClickListener{
       // editor.remove("Name").apply()
           // editor.remove("Phone").apply()
            //Toast.makeText(applicationContext, "Name removed", Toast.LENGTH_SHORT).show()
            //Toast.makeText(applicationContext, "Phone removed", Toast.LENGTH_SHORT).show()
          editor.clear()
        }
    }

    // Fetch the stored data in onResume() Because this is what will be called when the app opens again
    override fun onResume() {
        super.onResume()
        // Fetching the stored data from the SharedPreference
        val sh = getSharedPreferences("MySharedPref", MODE_PRIVATE)
        val name1 = sh.getString("name", "")
        val age1 = sh.getInt("age", 0)
        val email1 = sh.getString("email", "")

        // Setting the fetched data in the EditTexts
        name.setText(name1)
        age.setText(age1.toString())
        email.setText(email1)

    }

    // Store the data in the SharedPreference in the onPause() method
    // When the user closes the application onPause() will be called and data will be stored
    override fun onPause() {
        super.onPause()
        // Creating a shared pref object with a file name "MySharedPref" in private mode
        val sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE)
        val myEdit = sharedPreferences.edit()

        // write all the data entered by the user in SharedPreference and apply
        myEdit.putString("name", name.text.toString())
        myEdit.putInt("age", age.text.toString().toInt())
        myEdit.putString("email", email.text.toString())
        myEdit.apply()
        Toast.makeText(this@MainActivity, "Thanks!", Toast.LENGTH_SHORT).show()
    }

}