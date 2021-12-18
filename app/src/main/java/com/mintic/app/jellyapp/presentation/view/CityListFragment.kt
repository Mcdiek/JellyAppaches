package com.mintic.app.jellyapp.presentation.view


import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mintic.app.jellyapp.R
import com.mintic.app.jellyapp.model.City
import com.mintic.app.jellyapp.presentation.viewmodel.ListViewModel
import com.mintic.app.jellyapp.presentation.adapter.CityAdapter


class CityListFragment : Fragment() {
    
    private lateinit var viewModel: ListViewModel

//    private var listener: OnCityListButtonListener? = null
    private lateinit var cityAdapter : CityAdapter
    private lateinit var recycler: RecyclerView
    private lateinit var contexto: Context


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {        

        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        observeLiveData()
        val view =  inflater.inflate(R.layout.city_list_fragment, container, false)

        recycler = view.findViewById(R.id.city_list)
        initRecyclerView(view)
        return  view
    }

    private fun observeLiveData() {
        return viewModel.getCitys().observe(viewLifecycleOwner,{
            Log.d("CITYLISTA",it.toString())
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.contexto = context
    }

    private fun initRecyclerView(view: View){

        recycler.addItemDecoration(
            DividerItemDecoration(
                contexto,
                DividerItemDecoration.VERTICAL
            )
        )
        recycler.layoutManager = LinearLayoutManager(activity)

        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        viewModel.getCitys().observe(viewLifecycleOwner, {
            cityAdapter = CityAdapter(it, contexto){
                    city ->   cityOnClick(city,view)
            }
            recycler.adapter = cityAdapter
        })
        viewModel.getIsFailure().observe(viewLifecycleOwner, {
            if (it) {
                Log.d(TAG, "Request failed")
            }
        })

    }

    private fun cityOnClick(city: City, view: View){
        val action = CityListFragmentDirections.navigateToCityDetails(city.cityName,
            city.cityDescription,
            city.temperature,
            city.imageUrl,
            city.depName,
            city.ratCityValue.toFloat(),
            city.geoLat,
            city.geoLon
        )
        Navigation.findNavController((view)).navigate(action)
    }


companion object{

    private const val TAG = "CityListFragment"



}


}