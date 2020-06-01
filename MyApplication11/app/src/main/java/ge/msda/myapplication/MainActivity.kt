package ge.msda.myapplication

import android.os.Bundle
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import ge.msda.myapplication.adapters.ViewPagerFragmentAdapter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var viewPagerFragmentAdapter: ViewPagerFragmentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPagerFragmentAdapter = ViewPagerFragmentAdapter(this)

        viewpager.adapter = viewPagerFragmentAdapter

        TabLayoutMediator(tabLayout, viewpager) { tab, position ->
            if(position == 1){
            tab.text = "${(tab.setIcon(R.drawable.one_24dp))}"}
            else if(position == 2){
                    tab.text = "${(tab.setIcon(R.drawable.two_24dp))
                }"}
            else{
                tab.text = "${(tab.setIcon(R.drawable.three_24dp))
            }"}
        }.attach()



    }

}