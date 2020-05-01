package ge.iriii.exam11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_comments.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CommentsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comments)

        val id = if (intent.hasExtra("id")){
            intent.extras!!.getInt("id")
        } else {
            null
        }

        val postTitle = if (intent.hasExtra("post_name")){
            intent.extras!!.getString("post_name")
        } else {
            null
        }

        val postAuthor = if (intent.hasExtra("post_author")){
            intent.extras!!.getString("post_author")
        } else {
            null
        }

        val postBody = if (intent.hasExtra("post_body")){
            intent.extras!!.getString("post_body")
        } else {
            null
        }

        if (postTitle != null) {
            txtTitle.text = postTitle.toString()
        }

        if (postBody != null) {
            txtBody.text = postBody.toString()
        }

        if(postAuthor != null)
        {
            txtPostedBy.text = postAuthor.toString()
        }

        if(id != null){
            loadComments(id)
        } else {
            txtCom.text = "comments failed to load!"
        }

    }

    private fun loadComments(id : Int)
    {
        val call = RetrofitClient.client.api().getComments(id)
        call.enqueue(object : Callback<List<CommentItem>> {
            override fun onFailure(call: Call<List<CommentItem>>, t: Throwable) {
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
            }

            override fun onResponse(
                call: Call<List<CommentItem>>,
                response: Response<List<CommentItem>>
            ) {
                comments.adapter = CommentAdapter(this@CommentsActivity, response.body() as ArrayList<CommentItem>)
            }

        })
    }
}
