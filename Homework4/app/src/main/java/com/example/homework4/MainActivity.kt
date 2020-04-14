package com.example.homework4

import ContactsAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ContactsAdapter(getContacts())
        RecyclerView.layoutManager = LinearLayoutManager(this)
        RecyclerView.adapter = adapter
    }

    fun getContacts() : List<Contact> {
        val con1 = Contact("Irina", isOnline = true)
        val con2 = Contact("Nikolozi", isOnline = true)
        val con3 = Contact("Ana", isOnline = true)
        val con4 = Contact("Mariami", isOnline = false)
        val con5 = Contact("Ketevani", isOnline = true)
        val con6 = Contact("Salome", isOnline = true)
        val con7 = Contact("Giorgi", isOnline = true)
        val con8 = Contact("Lasha", isOnline = false)
        val con9 = Contact("Nutsa", isOnline = true)
        val con10 = Contact("Irina2", isOnline = false)
        val con11 = Contact("Anastasia", isOnline = true)
        val con12 = Contact("Nikolozi2", isOnline = false)
        val con13 = Contact("Nika", isOnline = true)
        val con14 = Contact("Barbare", isOnline = false)
        val con15 = Contact("Kate", isOnline = true)
        val con16 = Contact("Julieta", isOnline = false)
        val con17 = Contact("Romeo", isOnline = true)
        val con18 = Contact("Kvazimodo", isOnline = false)
        val con19 = Contact("Vigac", isOnline = true)
        val con20 = Contact("Arupasuxo", isOnline = false)

        val returnlist = ArrayList<Contact> ()
        returnlist.add(con1)
        returnlist.add(con2)
        returnlist.add(con3)
        returnlist.add(con4)
        returnlist.add(con5)
        returnlist.add(con6)
        returnlist.add(con7)
        returnlist.add(con8)
        returnlist.add(con9)
        returnlist.add(con11)
        returnlist.add(con12)
        returnlist.add(con13)
        returnlist.add(con14)
        returnlist.add(con15)
        returnlist.add(con16)
        returnlist.add(con17)
        returnlist.add(con18)
        returnlist.add(con19)
        returnlist.add(con20)
        return returnlist
    }
}

