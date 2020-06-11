package com.google.maps.android.utils.demo.crashexample.model

import android.content.Context
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.MarkerOptions
import com.google.maps.android.clustering.Cluster
import com.google.maps.android.clustering.ClusterManager
import com.google.maps.android.clustering.view.DefaultClusterRenderer
import com.google.maps.android.utils.demo.model.MyItem

class AFClusterRenderer(
        context: Context,
        map: GoogleMap,
        clusterManager: ClusterManager<MyItem>)
    : DefaultClusterRenderer<MyItem>(context, map, clusterManager) {

    override fun onBeforeClusterItemRendered(item: MyItem, markerOptions: MarkerOptions) {
        //Set custom icon
    }

    override fun shouldRenderAsCluster(cluster: Cluster<MyItem>): Boolean {
        return cluster.size > 4
    }
}