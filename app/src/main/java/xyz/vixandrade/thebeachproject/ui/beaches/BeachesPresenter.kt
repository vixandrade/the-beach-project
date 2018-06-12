package xyz.vixandrade.thebeachproject.ui.beaches

interface BeachesPresenter {

    fun loadAllBeaches()
    fun onBindRow(position: Int, beachHolder: BeachHolder)
    fun getBeachCount(): Int

}