package com.pupup.retrievedataagaain

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {
    lateinit var myArray: ArrayList<User>
    lateinit var myAdapter: MyAdapter
    lateinit var recyclerView: RecyclerView
    var db = FirebaseFirestore.getInstance()
    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView=findViewById(R.id.recycleView)
        recyclerView.layoutManager=LinearLayoutManager(this)
        myArray = arrayListOf()
        myAdapter= MyAdapter(myArray)

        db.collection("users").get()
            .addOnSuccessListener { documents->
                for(document in documents){
                    val data = document.data
                    val userData =User(data["name"].toString(),data["email"].toString(),data["phone"].toString().toLong())
                    myArray.add(userData)
                    myAdapter.notifyDataSetChanged()
                }
            }
            .addOnFailureListener {

            }
        recyclerView.adapter=myAdapter

    }
}