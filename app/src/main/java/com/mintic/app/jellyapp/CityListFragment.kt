package com.mintic.app.jellyapp


import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray
import org.json.JSONException
import java.io.IOException
import java.io.InputStream
import java.util.ArrayList


class CityListFragment : Fragment() {

//    private var listener: OnCityListButtonListener? = null
    private lateinit var cityAdapter : CityAdapter
    private var mCity: ArrayList<City> = ArrayList()
    private lateinit var recycler: RecyclerView
    private lateinit var contexto: Context




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.city_list_fragment, container, false)

        recycler = view.findViewById(R.id.city_list)
        initRecyclerView(view)
        return  view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        generateCitys()

    }

    //    agregar contexto
    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.contexto = context

    }


    private fun initRecyclerView(view: View){

        mCity = arrayListOf()

        recycler.addItemDecoration(
            DividerItemDecoration(
                contexto,
                DividerItemDecoration.VERTICAL //vertical se refiera a la lista
            )
        )
        recycler.layoutManager = LinearLayoutManager(activity)

        cityAdapter = CityAdapter(mCity, contexto)
        {
            city ->   cityOnClick(city,view)
        }
        recycler.adapter = cityAdapter
    }

    private fun cityOnClick(city: City,view: View){
//      Log.d(TAG, "click on ${city.cityName}")

        val action = CityListFragmentDirections.navigateToCityDetails(city.cityName,city.cityDescription,city.temperature,city.imageUrl,city.depName,city.ratCityValue.toFloat())
       Navigation.findNavController((view)).navigate(action)


    }



    @SuppressLint("NotifyDataSetChanged")
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

            cityAdapter.notifyDataSetChanged()
        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }



    fun readCityJsonFile(): String? {

        var contactsString: String? = null
        try {
            val inputStream: InputStream = contexto.assets.open("mock_city.json")
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


    companion object{

            private const val TAG = "CityListFragment"



    }


}