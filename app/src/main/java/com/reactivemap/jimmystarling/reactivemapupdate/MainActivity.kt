package com.reactivemap.jimmystarling.reactivemapupdate

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.reactivemap.jimmystarling.reactivemapupdate.fragments.MapFragment
import com.reactivemap.jimmystarling.reactivemapupdate.models.MessageEvent
import com.reactivemap.jimmystarling.reactivemapupdate.models.RxBus

/**
 * Created by @Author: Jimmy Starling.
 * A simple [Activity] to capsulate the
 * [Fragment] who will have the map.
 * */

class MainActivity : AppCompatActivity() {
    private val managerFragment = this.supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Fragments for main activity
        val fragmentMap           = MapFragment()

        // Transaction for commit changes
        val transaction           = managerFragment.beginTransaction()

        //Adding map to a fragment inside the Nav view
        transaction.add(R.id.map_holder, fragmentMap).commit()

        // Feed the main activity
        RxBus.listen(MessageEvent::class.java).subscribe({
            val text = "Created a new marker from Fragment ! data(${it.latitude}, ${it.longitude})"
            val duration = Toast.LENGTH_SHORT
            val toast = Toast.makeText(applicationContext, text, duration)
            toast.show()
        })
    }
}
