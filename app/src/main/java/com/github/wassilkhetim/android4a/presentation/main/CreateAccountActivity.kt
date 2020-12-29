package com.github.wassilkhetim.android4a.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.github.wassilkhetim.android4a.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_create_account.*
import org.koin.android.ext.android.inject

class CreateAccountActivity : AppCompatActivity() {

    val createAccountViewModel : CreateAccountViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

        createAccountViewModel.createAccountLiveData.observe(this, Observer {
            when(it){
                is CreateAccountSuccess -> {
                    finish()
                }
                is CreateAccountError -> {
                    val erMsg = it.errorMessage
                    MaterialAlertDialogBuilder(this)
                        .setMessage(erMsg)
                        .setTitle("Erreur")
                        .setPositiveButton("Ok"){
                                dialog, wich -> dialog.dismiss()
                        }
                        .show()
                }
            }
        })

        create_account_confirm_button.setOnClickListener{
            createAccountViewModel.onClickedCreate(create_login_edit.text.toString().trim(), create_password_edit.text.toString().trim())
        }

    }
}