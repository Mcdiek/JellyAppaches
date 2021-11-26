package com.mintic.app.jellyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray
import org.json.JSONException
import java.io.IOException
import java.util.ArrayList

private lateinit var mCity: ArrayList<City> //El lateinit sirve como promesa de que se inicializará la variable
private lateinit var mAdapter: CityAdapter
private lateinit var recycler: RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        recycler = findViewById(R.id.city_list)
        setupRecyclerView()
        generateCitys()

    }

    private fun setupRecyclerView() {
        mCity = arrayListOf() //crea arreglo vacío cumple promesa lateinit

        // agrega una linea para separar los elementos
        recycler.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL //vertical se refiera a la lista
            )
        )
        //inicia adapter que recibe la lista de contactos de inicio vacia
        mAdapter = CityAdapter(mCity, this)
        { contact ->
            cityOnClick(contact)
        }

        recycler.adapter = mAdapter
    }



    private fun cityOnClick(city: City) {
        Log.d(TAG, "Click on: $city")

        val intent = Intent(this, MainActivity2::class.java).apply {
            putExtra(CITY_NAME,city.cityName)
            putExtra(CITY_TEMP,city.temperature)
            putExtra(CITY_DESCRIPTION,city.cityDescription)
            putExtra(CITY_IMAGE,city.imageUrl)
            putExtra(CITY_LOCATION,city.depName)
            putExtra(CITY_RATING,city.ratCityValue)
        }
        startActivity(intent)
    }

    private fun generateCitys() {
        val citysString = readCityJsonFile()
        try {
            val citysJson = JSONArray(citysString)
            for (i in 0 until citysJson.length()) {
                val cityJson = citysJson.getJSONObject(i)
                val city = City(
                    cityJson.getString("cityName"),
                    cityJson.getString("depName"),
                    cityJson.getString("temperature"),
                    cityJson.getString("imageUrl"),
                    cityJson.getString("cityDescription"),
                    cityJson.getString("ratCityValue")
                )
                Log.d(TAG, "generateContacts: $city")
                mCity.add(city)
            }

            mAdapter.notifyDataSetChanged()
        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }

    private fun readCityJsonFile(): String? {
        var contactsString: String? = null
        try {
            val inputStream = assets.open("mock_city.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()

            contactsString = String(buffer)
        } catch (e: IOException) {
            e.printStackTrace()
        }

        return contactsString
    }



//    fun sendMessage(view: View) {
//        val textView = findViewById<TextView>(R.id.textCity1)
//        val message = textView.text.toString()
//        Log.d("TAG",message)
//        val intent = Intent(this, MainActivity2::class.java).apply {
//            putExtra(CITY_MESSAGE,message)
//        }
//        // intent.putExtra(ITY_MESSAGE,message)
//        startActivity(intent)
//    }
    companion object{
        const val CITY_NAME = "com.mintic.app.jellyapp.NAME"
        const val CITY_TEMP = "com.mintic.app.jellyapp.TEMPERATURE"
        const val CITY_DESCRIPTION = "com.mintic.app.jellyapp.DESCRIPTION"
        const val CITY_IMAGE = "com.mintic.app.jellyapp.IMAGE"
        const val CITY_LOCATION = "com.mintic.app.jellyapp.LOCATION"
        const val CITY_RATING = "com.mintic.app.jellyapp.RATING"
        private val TAG = MainActivity::class.java.simpleName
    }


}