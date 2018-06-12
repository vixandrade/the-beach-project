package xyz.vixandrade.thebeachproject.ui.beaches

import android.app.Application
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.internal.schedulers.IoScheduler
import io.reactivex.rxkotlin.subscribeBy
import xyz.vixandrade.thebeachproject.ApplicationClass
import xyz.vixandrade.thebeachproject.data.BeachData
import xyz.vixandrade.thebeachproject.network.IBeachesApi
import javax.inject.Inject

class BeachesPresenterImpl(var beachesView: BeachesView, applicationComponent: Application): BeachesPresenter {

    @Inject
    lateinit var beachesApi: IBeachesApi

    lateinit var beachesList: List<BeachData>

    init {
        (applicationComponent as ApplicationClass).applicationComponent.inject(this)
    }

    override fun loadAllBeaches() {
        beachesApi.getAllRegions()
                .subscribeOn(IoScheduler())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy (
                        onError = {

                        },
                        onSuccess = {
                            beachesList = it
                            beachesView.showAllRegions(beachesList)
                        }
                )
    }

    override fun onBindRow(position: Int, beachHolder: BeachHolder) {
        val beach = beachesList[position]
        beachHolder.setName(beach.local)
    }

    override fun getBeachCount(): Int {
        return beachesList.size
    }
}