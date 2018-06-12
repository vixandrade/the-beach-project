package xyz.vixandrade.thebeachproject.ui.beaches

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.rv_beaches_item_row.view.*
import xyz.vixandrade.thebeachproject.R
import xyz.vixandrade.thebeachproject.data.BeachData
import xyz.vixandrade.thebeachproject.utils.inflate

class BeachesAdapter(private val beaches: List<BeachData>, private val beachesPresenter: BeachesPresenter): RecyclerView.Adapter<BeachHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeachHolder {
        val inflatedView = parent.inflate(R.layout.rv_beaches_item_row)
        return BeachHolder(inflatedView)
    }

    override fun getItemCount(): Int {
        return beachesPresenter.getBeachCount()
    }

    override fun onBindViewHolder(holder: BeachHolder, position: Int) {
        beachesPresenter.onBindRow(position, holder)
    }
}

class BeachHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener, BeachRowView {

    var nameTextView: TextView

    init {
        v.setOnClickListener(this)
        nameTextView = v.tv_beach_name
    }

    override fun onClick(v: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setName(name: String) {
        nameTextView.text = name
    }

}
