package ge.msda.myapplication.fargments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import ge.msda.myapplication.R
import kotlinx.android.synthetic.main.third_fragment.*

class ThirdFragment : Fragment(R.layout.fragmnet_first){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.takeIf {
            it.containsKey("STRING")
        }?.apply { textView3.text = getString("STRING") }

    }
}