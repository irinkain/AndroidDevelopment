package irina.inashvili.shualeduri2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.android.synthetic.main.fragment_read_all.view.*

class ReadAllFragment : Fragment() {
    private val arr = ArrayList<DataMode>()
    private lateinit var adapter: Adapter

    private val db: RoomDatabase by lazy { Room.databaseBuilder(activity!!, DB::class.java, "Records").allowMainThreadQueries().build() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_read_all, container, false)

        adapter = Adapter(arr, activity!!)
        view.alldatarv.adapter = adapter

        read()

        return view
    }

    private fun read()
    {
        arr.clear()
        (db as DB).dataDao().getActivity().forEach{
            arr.add(it)
            adapter.notifyDataSetChanged()
        }
    }
}