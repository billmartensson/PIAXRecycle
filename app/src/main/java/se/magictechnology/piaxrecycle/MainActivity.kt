package se.magictechnology.piaxrecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    var theadapter = FunnyAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fancyRecView = findViewById<RecyclerView>(R.id.fancyRV)

        fancyRecView.layoutManager = LinearLayoutManager(this)
        //fancyRecView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true)
        //fancyRecView.layoutManager = GridLayoutManager(this, 3)

        fancyRecView.adapter = theadapter


        findViewById<Button>(R.id.addPersonBtn).setOnClickListener {

            var pname = findViewById<EditText>(R.id.personET).text.toString()

            findViewById<EditText>(R.id.personET).setText("")

            theadapter.people.add(pname)
            theadapter.peopledone.add(false)

            theadapter.notifyDataSetChanged()

        }


    }
}


