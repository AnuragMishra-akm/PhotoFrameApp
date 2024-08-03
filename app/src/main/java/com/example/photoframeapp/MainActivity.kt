package com.example.photoframeapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var image:ImageView
    var currentImage = 0
    val name = arrayOf("Cillian Murphy","JakeGyllenhaal","Robert Downey Jr.","Robert Pattinson")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        supportActionBar?.hide()
        val prev = findViewById<ImageButton>(R.id.imgbtnprev)
        val next = findViewById<ImageButton>(R.id.imgbtnnxt)
        val text = findViewById<TextView>(R.id.textView)
        prev.setOnClickListener{
            val idcurrentimageString = "pic$currentImage"
            //convert string id into integer associated with it
            var idcurrentimageInt = this.resources.getIdentifier(idcurrentimageString,"id",packageName)
            image = findViewById(idcurrentimageInt)
            image.alpha=0f

            currentImage = (4+currentImage-1)%4

            val idimagetoShowString = "pic$currentImage"
            var idimagetoShowInt = this.resources.getIdentifier(idimagetoShowString,"id",packageName)
            image = findViewById(idimagetoShowInt)
            image.alpha=1f

            // setting text
            text.text=name[currentImage]
        }

        next.setOnClickListener{
            val idcurrentimageString = "pic$currentImage"
            //convert string id into integer associated with it
            var idcurrentimageInt = this.resources.getIdentifier(idcurrentimageString,"id",packageName)
            image = findViewById(idcurrentimageInt)
            image.alpha=0f

            currentImage = (currentImage+1)%4

            val idimagetoShowString = "pic$currentImage"
            var idimagetoShowInt = this.resources.getIdentifier(idimagetoShowString,"id",packageName)
            image = findViewById(idimagetoShowInt)
            image.alpha=1f

            // setting text

            text.text=name[currentImage]
        }
    }
}