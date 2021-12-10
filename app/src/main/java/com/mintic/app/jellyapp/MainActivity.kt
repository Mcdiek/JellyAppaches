package com.mintic.app.jellyapp



import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View



class MainActivity : AppCompatActivity() {

    private lateinit var view : View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main_activity)
        setSupportActionBar(findViewById(R.id.toolbar))


       supportActionBar?.title = ""


    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.configure -> {
                val fragment = SettingsFragment()
                supportFragmentManager.beginTransaction().apply{
                    replace(R.id.fragmentContainerView,fragment)
                    commit()
                }
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }






    companion object {
        private const val TAG = "MainActivity"
    }

}


