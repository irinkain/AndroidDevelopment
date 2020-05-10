package ge.msda.myapplication

import android.R
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import ge.msda.myapplication.fragments.CallFragment
import ge.msda.myapplication.fragments.DashboardFragment
import ge.msda.myapplication.fragments.HomeFragment
import ge.msda.myapplication.fragments.NotificationFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private lateinit var viewPagerAdapter: ViewPagerAdapter
    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                main_view_pager.currentItem = 0
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                main_view_pager.currentItem = 1
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notification -> {
                main_view_pager.currentItem = 2
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_call -> {
                main_view_pager.currentItem = 3
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)
        main_view_pager.adapter = viewPagerAdapter
        main_bottom_navigation_view.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)

        val appBarConfig = AppBarConfiguration(setOf(
            R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notification,
            R.id.navigation_call
        ))
        setupActionBarWithNavController(navController, appBarConfig)
        navView.setupWithNavController(navController)

    }
    class MyPagerAdapter(fragmentManager: FragmentManager?) :
        FragmentPagerAdapter(fragmentManager!!) {
        override fun getCount(): Int {
            return NUM_ITEMS
        }
        override fun getItem(position: Int): Fragment {
            return when (position) {
                0 -> DashboardFragment()
                1 -> HomeFragment()
                2 -> NotificationFragment()
                3 -> CallFragment()
                else -> {
                    HomeFragment()
                }
            }
        }
        override fun getPageTitle(position: Int): CharSequence? {
            return "Page $position"
        }

        companion object {
            private const val NUM_ITEMS = 4
        }
    }
}