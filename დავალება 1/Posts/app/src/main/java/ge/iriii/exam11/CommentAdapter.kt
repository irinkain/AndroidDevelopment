package ge.iriii.exam11

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CommentAdapter (private val context: Context, private val arr : ArrayList<CommentItem>) :
    RecyclerView.Adapter<CommentAdapter.VH>() {
    class VH(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val textName = itemView.findViewById<TextView>(R.id.textCommentByName)
        val textEmail = itemView.findViewById<TextView>(R.id.textCommentByEmail)
        val textBody = itemView.findViewById<TextView>(R.id.textCommentBody)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(LayoutInflater.from(context).inflate(R.layout.comment_item, parent, false))
    }

    override fun getItemCount(): Int {
        return arr.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val i = arr[position]

        holder.textName.text = i.name
        holder.textEmail.text = i.email
        holder.textBody.text = i.body
    }
}