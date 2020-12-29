package com.github.wassilkhetim.android4a.presentation.body

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.wassilkhetim.android4a.R
import com.github.wassilkhetim.android4a.data.remote.RickMortyApi
import com.github.wassilkhetim.android4a.domain.entity.PersonnageInfo
import com.github.wassilkhetim.android4a.domain.entity.RestRickmortyResponse
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class HomePageActivity : AppCompatActivity() {

    private var recyclerView: RecyclerView? = null
    private var mAdapter: ListAdapter? = null
    private var layoutManager: RecyclerView.LayoutManager? = null

    private val BASE_URL = "https://rickandmortyapi.com"
    private var listPersonnage: MutableList<PersonnageInfo>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        //showList()
        initListPersonnage()
        startApiCall(1)
    }

    /*fun showList(){
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView?.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        recyclerView?.layoutManager = layoutManager
        val input: MutableList<String> = ArrayList()
        for (i in 0..99){
            input.add("Test$i")
        }
        mAdapter = ListAdapter(input)
        recyclerView?.adapter = mAdapter
    }*/

 /*   fun makeApiCall() {
        val gson = GsonBuilder()
            .setLenient()
            .create()

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        val rickMortyAPI: RickMortyApi = retrofit.create(RickMortyApi::class.java)

        val call: Call<RestRickmortyResponse> = rickMortyAPI.getRickmortyResponse(1)
        call?.enqueue(object : Callback<RestRickmortyResponse>{
            override fun onResponse(
                call: Call<RestRickmortyResponse?>,
                response: Response<RestRickmortyResponse?>
            ) {
                if(response.isSuccessful && response.body() != null){
                    val personnageInfoList: MutableList<PersonnageInfo>? = response.body()!!.results as MutableList<PersonnageInfo>?
                    if (personnageInfoList != null) {
                        addElementToList(personnageInfoList)
                    }
                    Toast.makeText(applicationContext, "API Success", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(applicationContext, "API Failure with response or body", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<RestRickmortyResponse?>, t: Throwable) {
                Log.d("WASSA", t.message)
                Toast.makeText(applicationContext, "API Failure", Toast.LENGTH_SHORT).show()

            }
        })
    }
*/
    fun startApiCall(page: Int) {
        val gson = GsonBuilder()
            .setLenient()
            .create()

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        val rickMortyAPI: RickMortyApi = retrofit.create(RickMortyApi::class.java)

        val call: Call<RestRickmortyResponse> = rickMortyAPI.getRickmortyResponse(page)
        call?.enqueue(object : Callback<RestRickmortyResponse>{
            override fun onResponse(
                call: Call<RestRickmortyResponse?>,
                response: Response<RestRickmortyResponse?>
            ) {
                if(response.isSuccessful && response.body() != null){
                    val personnageInfoList: MutableList<PersonnageInfo>? = response.body()!!.results as MutableList<PersonnageInfo>?
                    if (personnageInfoList != null) {
                        addElementToList(personnageInfoList)
                    }
                    if(response.body()!!.getInfo()?.getNext() != null && !response.body()!!.getInfo()?.getNext().equals("")){
                        startApiCall(page+1)
                    }else{
                        startRecyclerView()
                        Toast.makeText(applicationContext, "API Success", Toast.LENGTH_SHORT).show()
                    }
                }else{
                    Toast.makeText(applicationContext, "API Failure with response or body", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<RestRickmortyResponse?>, t: Throwable) {
                Log.d("WASSA", t.message)
                Toast.makeText(applicationContext, "API Failure", Toast.LENGTH_SHORT).show()

            }
        })
    }

    fun startRecyclerView(){
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView?.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        recyclerView?.layoutManager = layoutManager
        val input: MutableList<String> = ArrayList()
        for (i in 0..99){
            input.add("Test$i")
        }
        mAdapter = listPersonnage?.let { ListAdapter(it) }
        recyclerView?.adapter = mAdapter
    }

    fun getListPersonnage(): MutableList<PersonnageInfo>? {
        return listPersonnage
    }

    fun initListPersonnage() {
        listPersonnage = ArrayList()
    }

    fun addElementToList(newList: MutableList<PersonnageInfo>) {
        listPersonnage?.addAll(newList)//.addAll(newList)
    }

}