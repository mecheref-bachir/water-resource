package com.bachir.waterresources

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bachir.waterresources.ui.theme.WaterResourcesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           setContentView(R.layout.activity_main)

            val addButton = findViewById<Button>(R.id.button)
            val resource = findViewById<TextView>(R.id.resource)
            val location = findViewById<TextView>(R.id.loction)
            val type = findViewById<TextView>(R.id.type)

            addButton.setOnClickListener{
               // validation
                if(resource.text.isEmpty() || location.text.isEmpty() || type.text.isEmpty()){

                    Toast.makeText(applicationContext,"please provide all the information",Toast.LENGTH_SHORT).show()
                    return@setOnClickListener

                }

                val tableLayout = findViewById<TableLayout>(R.id.table)
                val textView1 = createTextView(resource.text.toString())
                val textView2 = createTextView(location.text.toString())
                val textView3 = createTextView(type.text.toString())



                val tableRow = TableRow(this)
                tableRow.addView(textView1)
                tableRow.addView(textView2)
                tableRow.addView(textView3)
                tableLayout.addView(tableRow)

                location.setText("")
                resource.setText("")
                type.setText("")



            }
        }
    }

    // function to create all text views for the table
    private fun createTextView(text: String): TextView {
        val textView = TextView(this)

        textView.text = text
        textView.width = resources.getDimension(R.dimen.width).toInt()
        textView.setPadding(20, 20, 20, 20)
        return textView
    }
}


