package ge.msda.myapplication

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import ge.msda.myapplication.fragments.CallFragment
import ge.msda.myapplication.fragments.DashboardFragment
import ge.msda.myapplication.fragments.HomeFragment
import ge.msda.myapplication.fragments.NotificationFragment

class ViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> HomeFragment()
            1 -> DashboardFragment()
            2 -> NotificationFragment()
            3 -> CallFragment()
            else -> HomeFragment()
        }
    }

    override fun getCount(): Int {
        return 4
    }
}