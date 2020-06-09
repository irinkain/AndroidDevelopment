package irina.inashvili.shualeduri2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_daily.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nav.setOnNavigationItemSelectedListener {
            var fragment = null
            when(it.itemId)
            {
                R.id.dailyActivity -> supportFragmentManager.beginTransaction().replace(R.id.container, DailyFragment(), null).commit()
                R.id.info -> supportFragmentManager.beginTransaction().replace(R.id.container, ReadAllFragment(), null).commit()
                else -> supportFragmentManager.beginTransaction().replace(R.id.container, FragmentStatistics(), null).commit()
            }

            return@setOnNavigationItemSelectedListener true
        }
    }
}