package com.google.maps.android.utils.demo.crashexample.manager

import android.app.Activity
import android.util.DisplayMetrics
import com.google.android.gms.maps.GoogleMap
import com.google.maps.android.clustering.ClusterManager
import com.google.maps.android.clustering.algo.NonHierarchicalViewBasedAlgorithm
import com.google.maps.android.utils.demo.crashexample.model.AFClusterRenderer
import com.google.maps.android.utils.demo.model.MyItem

class AFClusterManager(
        context: Activity,
        map: GoogleMap) :
        ClusterManager<MyItem>(context, map) {

    private lateinit var mClusterManagerRenderer: AFClusterRenderer

    init {
        setRenderer(context, map)
        setClusterAlgorithm(context)
    }

    fun initNodeClusterOnMap(nodes: ArrayList<MyItem>) {
        val clusterItemList = arrayListOf<MyItem>()
        for (item in nodes) {
            val offsetItem = MyItem(item.position.latitude, item.position.longitude)
            clusterItemList.add(offsetItem)
        }
        this.clearItems()
        this.addItems(clusterItemList)
        this.cluster()
    }

    private fun setClusterAlgorithm(context: Activity) {
        val metrics = DisplayMetrics()
        context.windowManager.defaultDisplay.getMetrics(metrics)

        this.setAlgorithm(
                NonHierarchicalViewBasedAlgorithm(
                        metrics.widthPixels, metrics.heightPixels
                )
        )
    }

    private fun setRenderer(context: Activity, map: GoogleMap) {
        mClusterManagerRenderer = AFClusterRenderer(context, map, this)
        this.renderer = mClusterManagerRenderer
    }
}