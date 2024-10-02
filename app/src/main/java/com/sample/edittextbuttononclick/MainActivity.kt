package com.sample.edittextbuttononclick

import android.annotation.SuppressLint
import android.hardware.camera2.params.OisSample
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var editTextSample: EditText
    private lateinit var sampleTextResult:  TextView
    private lateinit var countSymbolText: TextView
    private lateinit var buttonConvert: Button
    var stringForRevert: String = ""

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        buttonConvert = findViewById(R.id.convertButton)
        editTextSample = findViewById(R.id.editTextText)
        sampleTextResult = findViewById(R.id.textResult)
        countSymbolText = findViewById(R.id.symbolCounter)
        buttonConvert.setBackgroundColor(resources.getColor(R.color.another, theme))

        val beforeCount = 0
        countSymbolText.text = "Количество символов: $beforeCount"


        editTextSample.addTextChangedListener(object : android.text.TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun afterTextChanged(p0: Editable?) {
                val symbolCount = p0?.length ?: 0
                countSymbolText.text = "Количество символов: $symbolCount"
            }

        })
        buttonConvert.setOnClickListener {
            stringForRevert = editTextSample.text.toString()
            sampleTextResult.text = stringForRevert.toString().reversed()
        }

    }


}