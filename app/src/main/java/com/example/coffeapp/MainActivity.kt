package com.example.coffeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import kotlinx.android.synthetic.main.activity_main.*
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    var noofCups=0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun increment(view: android.view.View) {
        if(noofCups==100){
            return
        }
        noofCups+=1
        displayQuantity(noofCups)
    }
    fun decrement(view: android.view.View) {
        if(noofCups==-1){
            return
        }
        noofCups-=1
        displayQuantity(noofCups)
    }

    private fun displayQuantity(noofCups: Int) {
       idQuantity.text=noofCups.toString()
    }

    fun submitOrder(view: android.view.View) {
        val name=idEditText.editableText.toString()
        val Cream=idCheckBoxCream.isChecked
        val type1=idCheckBoxOne.isChecked
        val type2=idCheckBoxTwo.isChecked
        val Chocolate=idCheckBoxChocolate.isChecked
        var price = calculatePrice(Cream,Chocolate,type1,type2)
        val orderMessage=createOrderSummary(name,price,Cream,Chocolate)
        idDisplayOrderDetail.text=orderMessage.toString()
    }

    private fun calculatePrice(cream: Boolean, chocolate: Boolean, type1: Boolean, type2: Boolean): Any {
        var basePrice=10
        if(cream){
            basePrice+=5
        }
        if(chocolate){
            basePrice+=5
        }
        if(type1){
            basePrice+=2
        }
        if(type2){
            basePrice+=5
        }
        return basePrice
    }


    private fun createOrderSummary(name: String, price: Any, cream: Boolean, chocolate: Boolean): Any {
        return "Ordered by:$name \n Cream:$cream \n Chocolate:$chocolate \n your total bill is:$price \n Thank You!! visit again..."
    }

}

