package ge.msda.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(private val context: Context, private val arr : ArrayList<Item>) : RecyclerView.Adapter<Adapter.VH>() {

    class VH(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val text = itemView.findViewById<TextView>(R.id.textView2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(LayoutInflater.from(context).inflate(R.layout.item, parent, false))
    }

    override fun getItemCount(): Int {
        return arr.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val i = arr[position]
        holder.text.text = i.text
    }
}