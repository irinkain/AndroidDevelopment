package ge.msda.myapplication

import android.R
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView
import ge.msda.myapplication.MainActivity.MyPagerAdapter
import ge.msda.myapplication.fragments.CallFragment
import ge.msda.myapplication.fragments.DashboardFragment
import ge.msda.myapplication.fragments.HomeFragment
import ge.msda.myapplication.fragments.NotificationFragment


class MainActivity : AppCompatActivity() {
    var adapterViewPager: FragmentPagerAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val vpPager = findViewById<View>(R.id.vpPager) as ViewPager
        adapterViewPager = MyPagerAdapter(supportFragmentManager)
        vpPager.adapter = this.adapterViewPager

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