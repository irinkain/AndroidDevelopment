package irina.inashvili.shualeduri2

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(
    private val array: List<DataMode>,
    private val context: Context
) : RecyclerView.Adapter<Adapter.VH>(){
    class VH(i: View): RecyclerView.ViewHolder(i)
    {
        val steps: TextView = i.findViewById(R.id.steps)
        val water: TextView = i.findViewById(R.id.water)
        val sleep: TextView = i.findViewById(R.id.sleep)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH
    {
        return VH(LayoutInflater.from(context).inflate(R.layout.list_item, parent, false))
    }

    override fun getItemCount(): Int
    {
        return array.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: VH, position: Int)
    {
        val i = array[position]

        holder.steps.text = "ნაბიჯები:  ${i.steps}"
        holder.water.text = "წყალი:  ${i.water}"
        holder.sleep.text = "ძილი:  ${i.sleep}"
    }
}