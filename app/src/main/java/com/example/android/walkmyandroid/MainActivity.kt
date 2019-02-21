/*
 * Copyright 2017 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.walkmyandroid

import android.Manifest
import android.animation.Animator
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*
import android.animation.AnimatorInflater
import android.animation.AnimatorSet



class MainActivity : AppCompatActivity() {

    lateinit var locationViewModel: LocationViewModel
    lateinit var rotateAnim: Animator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        locationViewModel = ViewModelProviders.of(this).get(LocationViewModel::class.java)
        subscribe()

        button_location.setOnClickListener {
            if (ContextCompat.checkSelfPermission(this, LOCATION_PERMISSION) != PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(this, arrayOf(LOCATION_PERMISSION), LOCATION_REQUEST_CODE)
            } else {
                locationViewModel.toggleTracking()
            }
        }

        locationViewModel.initLocationManager(applicationContext, lifecycle)

        rotateAnim = AnimatorInflater.loadAnimator(this, R.animator.rotate)
        rotateAnim.setTarget(imageview_android)
    }



    private fun subscribe(){
        locationViewModel.lastLocation.observe(this, Observer {location->
            location?.let {
                textview_location.text = getString(R.string.location_text,
                                                    location.latitude,
                                                    location.longitude,
                                                    location.time)
            } ?: run {
                textview_location.text = getString(R.string.no_location)
            }

        })

        locationViewModel.address.observe(this, Observer {
            textview_location.text = "${textview_location.text}\n$it"
        })


        locationViewModel.isTrackingLocation.observe(this, Observer {tracking->
            if (tracking){
                button_location.setText(R.string.stop_tracking_location)
                rotateAnim.start()
            } else {
                button_location.setText(R.string.start_tracking_location)
                textview_location.setText(R.string.textview_hint)
                rotateAnim.end()
            }
        })
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when(requestCode){
            LOCATION_REQUEST_CODE -> {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    locationViewModel.toggleTracking()
                }
            }
        }
    }


    companion object {
        const val LOCATION_PERMISSION = Manifest.permission.ACCESS_FINE_LOCATION
        const val LOCATION_REQUEST_CODE = 71
    }
}
