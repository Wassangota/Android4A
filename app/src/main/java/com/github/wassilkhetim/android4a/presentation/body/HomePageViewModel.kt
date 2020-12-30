package com.github.wassilkhetim.android4a.presentation.body

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.wassilkhetim.android4a.data.remote.RickMortyApi
import com.github.wassilkhetim.android4a.domain.entity.PersonnageInfo
import com.github.wassilkhetim.android4a.domain.entity.RestRickmortyResponse
import com.github.wassilkhetim.android4a.domain.usecase.GetPersonnagesUseCase
import com.github.wassilkhetim.android4a.domain.usecase.SavePersonnagesUseCase
import com.github.wassilkhetim.android4a.injection.dataModule
import com.google.gson.GsonBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomePageViewModel(
    private val getPersonnagesUseCase: GetPersonnagesUseCase,
    private val savePersonnagesUseCase: SavePersonnagesUseCase
) : ViewModel() {

    private val BASE_URL = "https://rickandmortyapi.com"
    private var listPersonnage: MutableList<PersonnageInfo>? = null

    val loadDataLiveData: MutableLiveData<LoadDataStatus> = MutableLiveData()

    fun start(){
        viewModelScope.launch(Dispatchers.IO) {
            val listPerso = getPersonnagesUseCase.getPersonnages()
            if(listPerso != null && listPerso.size > 0){
                listPersonnage = listPerso
                withContext(Dispatchers.Main){
                    loadDataLiveData.value = DataLoaded("Load Success")
                }
            }else{
                downloadData()
            }
        }
    }

    fun downloadData(){
        initListPersonnage()
        startApiCall(1)
    }

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
        call?.enqueue(object : Callback<RestRickmortyResponse> {
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
                        loadDataLiveData.value = DataLoaded("API Success")
                        viewModelScope.launch(Dispatchers.IO) {
                            getListPersonnage()?.let { savePersonnagesUseCase.invoke(it) }
                        }
                    }
                }else{
                    loadDataLiveData.value = DataNotLoaded("API Failure with response or body")
                }
            }

            override fun onFailure(call: Call<RestRickmortyResponse?>, t: Throwable) {
                Log.d("WASSA", t.message)
                loadDataLiveData.value = DataNotLoaded("API Failure")

            }
        })
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