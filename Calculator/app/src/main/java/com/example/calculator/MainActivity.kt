package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private var operand: Double = 0.0
    private var operation: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        equals.setOnClickListener {

            val secOperandText: String = resultText.text.toString()
            var secOperand = 0.0

            if (!TextUtils.isEmpty(secOperandText)) {
                secOperand = secOperandText.toDouble()
            }

            when (this.operation) {
                "+" -> resultText.text = (this.operand + secOperand).toString()
                "-" -> resultText.text = (this.operand - secOperand).toString()
                "*" -> resultText.text = (this.operand * secOperand).toString()
                "/" -> {
                    if (secOperand != 0.0) {
                        resultText.text = (this.operand / secOperand).toString()
                    }
                }
            }

        }

        clear.setOnClickListener {
            reset()
        }

    }

    private fun reset() {
        resultText.text = ""
        this.operand = 0.0
        this.operation = ""
    }

    fun numberClick(view: View) {

        if (view is TextView) {

            val number = view.text.toString()
            var result = resultText.text.toString()

            if (result == "0") {
                result = ""
            }

            resultText.text = result + number

        }

    }

    fun operationClick(view: View) {

        if (view is TextView) {

            if (!TextUtils.isEmpty(resultText.text)) {
                this.operand = resultText.text.toString().toDouble()
            }

            resultText.text = ""

            this.operation = view.text.toString()

        }

    }
    fun delClick(view: View){
        if (view is TextView){
            resultText.text = ""
        }
    }

}