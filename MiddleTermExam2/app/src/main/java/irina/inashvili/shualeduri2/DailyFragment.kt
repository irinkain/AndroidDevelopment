package irina.inashvili.shualeduri2

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.android.synthetic.main.fragment_daily.*
import kotlinx.android.synthetic.main.fragment_daily.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class DailyFragment : Fragment() {
    private lateinit var db: RoomDatabase

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_daily, container, false)

        view.save.setOnClickListener {
            CoroutineScope(IO).launch {
                insertData()
            }
        }

        return view
    }

    private fun insertData()
    {
        val steps = inputSteps.text.toString()
        val water = inputWater.text.toString()
        val sleep = inputSleep.text.toString()

        if (isNotEmpty(steps, water, sleep))
        {
            db = Room.databaseBuilder(activity!!, DB::class.java, "Records").build()

            val model = DataMode()
            model.steps = steps.toInt()
            model.water = water
            model.sleep = sleep.toInt()

            (db as DB).dataDao().insert(model)
        } else {
           makeToast("ცარიელია!")
        }
    }

    private fun isNotEmpty(steps: String, water: String, sleep: String): Boolean
    {
        if (steps.isEmpty())
            return false
        if (water.isEmpty())
            return false
        if (sleep.isEmpty())
            return false
        return true
    }

    private fun makeToast(txt: String)
    {
        activity?.runOnUiThread(Runnable {
            Toast.makeText(activity!!, txt, Toast.LENGTH_LONG).show()
        })
    }
}