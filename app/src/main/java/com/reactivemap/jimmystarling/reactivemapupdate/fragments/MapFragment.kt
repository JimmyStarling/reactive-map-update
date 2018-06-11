package com.reactivemap.jimmystarling.reactivemapupdate.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapFragment
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions

import com.reactivemap.jimmystarling.reactivemapupdate.R
import com.reactivemap.jimmystarling.reactivemapupdate.models.MessageEvent
import com.reactivemap.jimmystarling.reactivemapupdate.models.RxBus

/**
 * Created by @Author: Jimmy Starling.
 * A simple [Fragment] subclass
 * Activities that contain this fragment must implement the
 * [RxBus] object listen to receive the interactions
 * and will update the position of marker.
 */

class MapFragment : Fragment(), OnMapReadyCallback {
    private var  mMap: GoogleMap? = null
    private var  position: LatLng? = null
    var btnSendMsg: Button? = null
    override fun onMapReady(gmap: GoogleMap?) {
        position = LatLng(25.792342, -80.127634)
        // Set m variable to gmap
        mMap = gmap!!
        // Animating the First Map Cam position
        gmap.animateCamera(CameraUpdateFactory.newLatLngZoom(position, 15.5f), 4000, null)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fragment = activity!!.fragmentManager
        val mapFragment = fragment.findFragmentById(R.id.map) as MapFragment
        mapFragment.getMapAsync(this)

        btnSendMsg = view.findViewById(R.id.btn_send)
        // Set click listener
        btnSendMsg!!.setOnClickListener {
            position = LatLng(25.813847, -80.132527)
            // Publishing Event by MessageEvent
            RxBus.publish(MessageEvent(position!!.latitude, position!!.longitude))
        }

        // Getting the published Event on RxBus
        RxBus.listen(MessageEvent::class.java).subscribe({
            //activity.runOnUiThread({
            position = LatLng(it.latitude, it.longitude)
            mapFragment.getMapAsync {
                mMap!!.addMarker(MarkerOptions().position(position!!).title("Marker").snippet("Added by event bus"))
            }
             //})
        })

    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_map, container, false)
    }
}
