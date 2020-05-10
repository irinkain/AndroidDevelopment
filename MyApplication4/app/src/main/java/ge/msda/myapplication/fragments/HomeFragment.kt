package ge.msda.myapplication.fragments

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import ge.msda.myapplication.R
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.fragment_home.view.editText

/*
* Created by ნიკოლოზ კაციტაძე on 5/7/20
*/

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        view.button.setOnClickListener {

            var amount = -1

            if (!TextUtils.isEmpty(editText.text.toString())) {
                amount = editText.text.toString().toInt()
            }

            val action = HomeFragmentDirections.actionNavigationHomeToNavigationNotification(amount)

            navController.navigate(action)

        }

    }

}