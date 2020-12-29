package com.github.wassilkhetim.android4a.presentation.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.github.wassilkhetim.android4a.R
import com.github.wassilkhetim.android4a.presentation.body.HomePageActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    val mainViewModel : MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel.loginLiveData.observe(this, Observer {
            when(it){
                is LoginSuccess -> {
                    /*MaterialAlertDialogBuilder(this)
                        .setMessage("Connexion réussie")
                        .setTitle("Info")
                        .setPositiveButton("Ok") {
                                dialog, wich -> dialog.dismiss()
                        }
                        .show()*/
                    var intent = Intent(this, HomePageActivity::class.java).apply {
                        putExtra("login",it.login)
                    }
                    startActivity(intent)
                }

                LoginError -> {
                    MaterialAlertDialogBuilder(this)
                        .setMessage("Compte inconnu")
                        .setTitle("Erreur")
                        .setPositiveButton("Ok") {
                            dialog, wich -> dialog.dismiss()
                        }
                        .show()
                }
            }
        })
        login_button.setOnClickListener{v ->
            mainViewModel.onClickedLogin(login_edit.text.toString().trim(), password_edit.text.toString().trim());
        }
        create_account_button.setOnClickListener{
            var intent = Intent(this, CreateAccountActivity::class.java)
            startActivity(intent)
        }
    }
}