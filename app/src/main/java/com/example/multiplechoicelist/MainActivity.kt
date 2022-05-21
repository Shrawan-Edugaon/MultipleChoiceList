package com.example.multiplechoicelist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    lateinit var mAlertButton: Button
    val programming_lang = arrayOf("kotlin","C","C++","Java","python","JavaScript","PHP","C#")
            val checked_items = booleanArrayOf(true,false,false,false,true,true,false,false)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAlertButton =findViewById(R.id.btnAlert)
        mAlertButton.setOnClickListener {
            val mAlertDialogBuilder =AlertDialog.Builder(this@MainActivity)
            mAlertDialogBuilder.setTitle("This is Title..")
            mAlertDialogBuilder.setIcon(R.drawable.ic_launcher_background)
            mAlertDialogBuilder.setCancelable(false)
            mAlertDialogBuilder.setMultiChoiceItems(programming_lang,checked_items){dialog,which,_->
                when(which){
                    which->{
                        Toast.makeText(this@MainActivity,programming_lang[which],Toast.LENGTH_LONG).show()
                    }
                }
            }
            mAlertDialogBuilder.setPositiveButton("Yes"){_,_->
                finish()
            }
            mAlertDialogBuilder.setNegativeButton("NO"){_,_->
                Toast.makeText(this@MainActivity,"Clicked No Button",Toast.LENGTH_LONG).show()
            }
            mAlertDialogBuilder.setNeutralButton("Cancel"){_,_->
                Toast.makeText(this@MainActivity,"Clicked Cancel Button",Toast.LENGTH_LONG).show()
            }
            val mAlertDialog = mAlertDialogBuilder.create()
            mAlertDialog.show()
        }
    }
}