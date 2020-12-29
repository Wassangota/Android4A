package com.github.wassilkhetim.android4a.presentation.body

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.github.wassilkhetim.android4a.R
import kotlinx.android.synthetic.main.activity_personnage_info.*

class PersonnageInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personnage_info)

        button_return.setOnClickListener{
            finish()
        }

        var b: Bundle? = intent.extras

        if(b != null){
            val titreTextView = findViewById<TextView>(R.id.nom_personnage_text_view)
            val subInfoTv = findViewById<TextView>(R.id.sub_info_text_view)
            val originTv = findViewById<TextView>(R.id.origine_personnage_edit_text_view)
            val currentLocTv = findViewById<TextView>(R.id.current_location_edit_textview)
            val imageIv = findViewById<ImageView>(R.id.personnage_imageView)

            if (b.getString("name") != null) titreTextView.text = b.getString("name")
            if (b.getString("status") != null && b.getString("species") != null) subInfoTv.text =
                b.getString("status") + " - " + b.getString("species")
            if (b.getString("origin") != null) originTv.text = "Origin : " + b.getString("origin")
            if (b.getString("location") != null) currentLocTv.text = b.getString("location")
            if (b.getString("image") != null) Glide.with(applicationContext)
                .load(b.getString("image")).centerCrop().into(imageIv)

        }

    }
}