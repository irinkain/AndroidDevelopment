package ge.msda.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val arr = ArrayList<Item>()
    lateinit var adapter: Adapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferences = getSharedPreferences("Diary", Context.MODE_PRIVATE)

        for (i in sharedPreferences.all)
        {
            arr.add(Item(i.value.toString()))
        }

        adapter = Adapter(this, arr)
        recyclerview.adapter = adapter

        addBtn.setOnClickListener {
            if (!inputText.text.isNullOrEmpty())
            {
                add(inputText.text.toString())
            }
        }
    }

    private fun add(text : String)
    {
        val prefs = getSharedPreferences("Diary", Context.MODE_PRIVATE)
        val editor = prefs.edit()

        val index = prefs.all.size + 1

        editor.putString(index.toString(), text)
        editor.apply()

        arr.add(Item(prefs.getString(index.toString(), " ")!!))
        adapter.notifyDataSetChanged()
    }
}