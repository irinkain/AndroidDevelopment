package irina.inashvili.shualeduri2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.android.synthetic.main.fragment_statistics.view.*

class FragmentStatistics : Fragment() {
    private val arr = ArrayList<DataMode>()
    private val db: RoomDatabase by lazy { Room.databaseBuilder(activity!!, DB::class.java, "Records").allowMainThreadQueries().build() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_statistics, container, false)

        calculateAverage()

        view.averageSteps.text = "ნაბიჯების საშუალო რაოდ.  -  ${getSteps()}"
        view.averageWater.text = "საშუალოდ დალეულია ${getWater()} ჭიქა წყალი"
        view.averageSleep.text = "საშუალოდ გეძინათ ${getSleep()} საათი"

        return view
    }

    private fun calculateAverage()
    {
        (db as DB).dataDao().getActivity().forEach {
            arr.add(it)
        }
    }

    private fun getSteps(): Int
    {
        var totalSum = 0
        var totalSize = arr.size

        for (i in arr)
        {
            totalSum += i.steps
        }

        return totalSum / totalSize
    }

    private fun getWater(): Int
    {
        var totalSum = 0
        var totalSize = arr.size

        for (i in arr)
        {
            totalSum += i.water.toInt()
        }

        return totalSum / totalSize
    }

    private fun getSleep(): Int
    {
        var totalSum = 0
        var totalSize = arr.size

        for (i in arr)
        {
            totalSum += i.sleep
        }

        return totalSum / totalSize
    }
}