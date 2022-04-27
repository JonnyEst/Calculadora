package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_clear.setOnClickListener {
            input.text = ""
            output.text = ""
        }

        button_bracket_left.setOnClickListener {
            input.text = addTopInputText("(")
        }

        button_bracket_rigth.setOnClickListener {
            input.text = addTopInputText(")")
        }

        button_0.setOnClickListener {
            input.text = addTopInputText("0")
        }

        button_1.setOnClickListener {
            input.text = addTopInputText("1")
        }

        button_2.setOnClickListener {
            input.text = addTopInputText("2")
        }

        button_3.setOnClickListener {
            input.text = addTopInputText("3")
        }

        button_4.setOnClickListener {
            input.text = addTopInputText("4")
        }

        button_5.setOnClickListener {
            input.text = addTopInputText("5")
        }

        button_6.setOnClickListener {
            input.text = addTopInputText("6")
        }

        button_7.setOnClickListener {
            input.text = addTopInputText("7")
        }

        button_8.setOnClickListener {
            input.text = addTopInputText("8")
        }

        button_9.setOnClickListener {
            input.text = addTopInputText("9")
        }

        button_punto.setOnClickListener {
            input.text = addTopInputText(".")
        }

        button_division.setOnClickListener {
            input.text = addTopInputText("÷")
        }

        button_multiplicar.setOnClickListener {
            input.text = addTopInputText("×")
        }

        button_suma.setOnClickListener {
            input.text = addTopInputText("+")
        }

        button_resta.setOnClickListener {
            input.text = addTopInputText("-")
        }

        button_igual.setOnClickListener {
            showResult()
            input.text = addTopInputText("×")
        }
    }


    private fun addTopInputText(buttonValue: String):String {
        return "${input.text}$buttonValue"
    }

    private fun getInputExpression(): String {
        var expresion = input.text.replace(Regex("÷"),"/")
        expresion = expresion.replace(Regex("×"),"*")
        return expresion
    }

    private fun showResult() {
        try {
                val expression = getInputExpression()
                val result = Expression(expression).calculate()
            if(result.isNaN()){
                //Show error message
                output.text =   "Error"
                output.setTextColor(ContextCompat.getColor( this,R.color.red))
            }else{
                //Show result
                output.text = DecimalFormat("0.######").format(result).toString()
                output.setTextColor(ContextCompat.getColor( this,R.color.green))
            }
         }catch (e: Exception){
                //Show error message
            output.text =   "Error"
            output.setTextColor(ContextCompat.getColor( this,R.color.red))
         }
    }
}