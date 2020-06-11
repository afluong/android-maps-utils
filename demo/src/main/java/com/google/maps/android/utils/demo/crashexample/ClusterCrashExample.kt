package com.google.maps.android.utils.demo.crashexample

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.utils.demo.BaseDemoActivity
import com.google.maps.android.utils.demo.MyItemReader
import com.google.maps.android.utils.demo.R
import com.google.maps.android.utils.demo.crashexample.manager.AFClusterManager
import com.google.maps.android.utils.demo.model.MyItem


class ClusterTaskActivity : BaseDemoActivity() {

    override fun startDemo(isRestore: Boolean) {
        if (!isRestore) {
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(51.403186, -0.126446), 10f))

            initCluster()
        }
    }

    private fun initCluster() {
        val manager = AFClusterManager(this, map)
        map.setOnCameraIdleListener(manager)

        val itemsList = arrayListOf<MyItem>()
        itemsList.addAll(getItems())
        manager.initNodeClusterOnMap(itemsList)
    }


    private fun getItems() : List<MyItem> {
        val inputStream = resources.openRawResource(R.raw.radar_search)
        return MyItemReader().read(inputStream)
    }
}