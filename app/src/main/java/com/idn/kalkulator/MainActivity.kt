package com.idn.kalkulator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_tambah.setOnClickListener(this)
        btn_kurang.setOnClickListener(this)
        btn_kali.setOnClickListener(this)
        btn_bagi.setOnClickListener(this)
    }

    override fun onClick(v: View){
        when (v.id){
            R.id.btn_tambah -> validation('+')
            R.id.btn_kurang -> validation('-')
            R.id.btn_kali -> validation('*')
            R.id.btn_bagi -> validation('/')
        }
    }

    private fun calculate(o:Char){
        when(o){
            '+' -> value.text = (edt_num1.text.toString().toDouble() + edt_num2.text.toString().toDouble()).toString()
            '-' -> value.text = (edt_num1.text.toString().toDouble() - edt_num2.text.toString().toDouble()).toString()
            '*' -> value.text = (edt_num1.text.toString().toDouble() * edt_num2.text.toString().toDouble()).toString()
            '/' -> value.text = (edt_num1.text.toString().toDouble() / edt_num2.text.toString().toDouble()).toString()
        }
    }

    private fun validateInput():Boolean{
        if (edt_num1.text.isEmpty() || edt_num2.text.isEmpty()) return false
        else return true
    }

    private fun validation(o:Char){
        if (validateInput()) return calculate(o)
        else Toast.makeText(this, "can't be empty !", Toast.LENGTH_SHORT).show()
    }
}
