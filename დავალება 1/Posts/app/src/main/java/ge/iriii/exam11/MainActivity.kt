package ge.iriii.exam11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.ResponseBody
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val call : retrofit2.Call<List<PostItem>> = RetrofitClient.client.api().getPosts()
        call.enqueue(object : retrofit2.Callback<List<PostItem>> {
            override fun onFailure(call: retrofit2.Call<List<PostItem>>, t: Throwable) {
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
            }

            override fun onResponse(
                call: retrofit2.Call<List<PostItem>>,
                response: Response<List<PostItem>>
            ) {
                val list : ArrayList<PostItem> = response.body() as ArrayList<PostItem>

                posts.adapter = PostAdapter(this@MainActivity, list)
            }

        })
    }
}
