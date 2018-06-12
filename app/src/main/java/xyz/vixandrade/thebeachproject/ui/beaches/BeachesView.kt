package xyz.vixandrade.thebeachproject.ui.beaches

import xyz.vixandrade.thebeachproject.data.BeachData

interface BeachesView {

    fun showAllRegions(regionList: List<BeachData>)

}