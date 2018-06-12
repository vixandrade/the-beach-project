package xyz.vixandrade.thebeachproject.ui.beaches

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import xyz.vixandrade.thebeachproject.R

import kotlinx.android.synthetic.main.activity_beaches.*
import xyz.vixandrade.thebeachproject.data.BeachData

class BeachesActivity : AppCompatActivity(), BeachesView {

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var beachesAdapter: BeachesAdapter
    private lateinit var beachesPresenter: BeachesPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beaches)

        beachesPresenter = BeachesPresenterImpl(this, application)

        linearLayoutManager = LinearLayoutManager(this)
        rv_beaches_list.layoutManager = linearLayoutManager

        beachesPresenter.loadAllBeaches()
    }

    override fun showAllRegions(regionList: List<BeachData>) {
        beachesAdapter = BeachesAdapter(regionList, beachesPresenter)
        rv_beaches_list.adapter = beachesAdapter
    }

}
