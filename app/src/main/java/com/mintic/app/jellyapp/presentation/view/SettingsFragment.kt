package com.mintic.app.jellyapp.presentation.view

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.mintic.app.jellyapp.R

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }
    companion object {


        @JvmStatic
        fun newInstance() = SettingsFragment()
    }

}