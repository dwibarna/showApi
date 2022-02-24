package com.sobarna.testmidas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var resAdapter: ResAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerview)
        resAdapter = ResAdapter()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = resAdapter

        ApiConfig.apiConfig().getApi().enqueue(object : Callback<Response>{
            override fun onResponse(call: Call<Response>, response: retrofit2.Response<Response>) {
                if (response.body() !=null){

                    response.body()?.payload?.get(0)?.shop

                    val arrayList = response.body()?.payload?.get(0)?.shop

                    for (i in 0..arrayList!!.size -1){
                        resAdapter.showList(arrayList[i]?.menus as List<MenusItem>)

                    }
                }
            }

            override fun onFailure(call: Call<Response>, t: Throwable) {
                Log.d(this.toString(),t.message.toString())
            }

        })
    }
}