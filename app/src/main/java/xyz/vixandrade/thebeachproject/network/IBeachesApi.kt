package xyz.vixandrade.thebeachproject.network

import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import xyz.vixandrade.thebeachproject.data.BeachData

interface IBeachesApi {

    @GET("regions/")
    fun getAllRegions(): Single<List<BeachData>>

    @GET("beaches/")
    fun getAllBeaches(@Query("structure") structure: String = "tree"): Single<HashMap<String, HashMap<String, BeachData>>>

    @GET("beaches/")
    fun getMacroBeaches(@Query("macro") macro: String): Observable<BeachData>

    @GET("beaches/")
    fun getMicroBeaches(@Query("micro") micro: String): Observable<BeachData>
}