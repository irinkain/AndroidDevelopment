package ge.iriii.exam11

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import okhttp3.ResponseBody
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import kotlin.collections.ArrayList

class PostAdapter(private val context: Context, private val arr : ArrayList<PostItem>) :
    RecyclerView.Adapter<PostAdapter.VH>() {
    class VH(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val textTitle = itemView.findViewById<TextView>(R.id.textTitle)
        val textAuthor = itemView.findViewById<TextView>(R.id.textPostedBy)
        val textBody = itemView.findViewById<TextView>(R.id.textBody)
        val textCommentCount = itemView.findViewById<TextView>(R.id.textCommentsCount)
        val postitem = itemView.findViewById<ConstraintLayout>(R.id.postitem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(LayoutInflater.from(context).inflate(R.layout.post_item, parent, false))
    }

    override fun getItemCount(): Int {
        return arr.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: VH, position: Int) {
        val i = arr[position]

        val userId = i.userId
        val id = i.id
        val title = i.title
        val body = i.body

        holder.textTitle.text = title
        holder.textAuthor.text = "Posted by user $userId"
        holder.textBody.text = body
        commentCount(id, holder.textCommentCount)

        holder.postitem.setOnClickListener {
            val intent = Intent(context, CommentsActivity::class.java)
            intent.putExtra("id", id)
            intent.putExtra("post_name", title)
            intent.putExtra("post_author", "Posted by user $userId")
            intent.putExtra("post_body", body)
            //intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(intent)
        }
    }

    private fun commentCount(id : Int, count : TextView)
    {
        val call : Call<List<CommentItem>> = RetrofitClient.client.api().getComments(id)
        call.enqueue(object : Callback<List<CommentItem>> {
            override fun onFailure(call: Call<List<CommentItem>>, t: Throwable) {
                Toast.makeText(context, t.message, Toast.LENGTH_LONG).show()
            }

            override fun onResponse(
                call: Call<List<CommentItem>>,
                response: Response<List<CommentItem>>
            ) {
                val i = response.body() as ArrayList<CommentItem>
                var c = 0
                for(j in 0 until i.size)
                {
                    c++
                }
                count.text = "$c comments"
            }
        })
    }
}