package com.ashford.calculator
//Created by Eric Ashford

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buEqual.isClickable = false

    }

    fun buNumberEvent(view: View){
        if(isNewOp==true){
            editShowNumber.setText("")
        }
        isNewOp=false
        val buSelect = view as Button
        var buClickValue:String = editShowNumber.text.toString()
        when(buSelect.id) {
            bu0.id -> {
                buClickValue += "0"
            }
            bu1.id -> {
                buClickValue += "1"
            }
            bu2.id -> {
                buClickValue += "2"
            }
            bu3.id -> {
                buClickValue += "3"
            }
            bu4.id -> {
                buClickValue += "4"
            }
            bu5.id -> {
                buClickValue += "5"
            }
            bu6.id -> {
                buClickValue += "6"
            }
            bu7.id -> {
                buClickValue += "7"
            }
            bu8.id -> {
                buClickValue += "8"
            }
            bu9.id -> {
                buClickValue += "9"
            }
            buDot.id -> {
                buClickValue = "."
            }
            buNeg.id -> {
                buClickValue = "-" + buClickValue
            }
        }
        editShowNumber.setText(buClickValue)
    }

    var op="*"
    var oldNumber=""
    var isNewOp=true

    fun buEventOperation(view:View) {

        val buSelect = view as Button
        when (buSelect.id) {
            buMult.id -> {
                op = "*"
            }
            buDiv.id -> {
                op = "/"
            }
            buSub.id -> {
                op = "-"
            }
            buPlus.id -> {
                op = "+"
            }
            buNeg.id ->{
                op = "-1"
            }
        }
        oldNumber=editShowNumber.text.toString()
        isNewOp=true
        buEqual.isClickable = oldNumber!=""
    }

    fun buEqualOperation(view: View){
        var newNumber = editShowNumber.text.toString()
        var finalNumber:Double?=null
        var negative = -1

        when(op){
            "*" ->{
                finalNumber = oldNumber.toDouble() * newNumber.toDouble()
            }
            "-" ->{
                finalNumber = oldNumber.toDouble() - newNumber.toDouble()
            }
            "/" ->{
                finalNumber = oldNumber.toDouble() / newNumber.toDouble()
            }
            "+" ->{
                finalNumber = oldNumber.toDouble() + newNumber.toDouble()
            }
            "-1"->{
                finalNumber = oldNumber.toDouble() * negative.toDouble()
            }

        }
        editShowNumber.setText(finalNumber.toString())
        isNewOp = true
        buEqual.isClickable = false
    }

    fun buClearEvent(view:View){
        oldNumber =""
        editShowNumber.setText("")
        isNewOp =true
        buEqual.isClickable = false
    }

    fun buPercent(view:View){
        val number:Double = editShowNumber.text.toString().toDouble()/100
        editShowNumber.setText(number.toString())
        isNewOp = true
    }
}