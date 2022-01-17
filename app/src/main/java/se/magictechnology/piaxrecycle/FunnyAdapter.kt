package se.magictechnology.piaxrecycle

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FunnyAdapter : RecyclerView.Adapter<HappyViewHolder>() {

    var people = mutableListOf<String>("Arne", "Bertil", "Casear")
    var peopledone = mutableListOf<Boolean>(false, false, false)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HappyViewHolder {

        Log.i("piaxdebug", "SKAPA RAD")

        val vh = HappyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.happy_item, parent, false))
        return vh
    }

    override fun getItemCount(): Int {
        Log.i("piaxdebug", "HUR MÅNGA RADER?")
        return people.size
    }

    override fun onBindViewHolder(holder: HappyViewHolder, position: Int) {
        Log.i("piaxdebug", "RITA RAD " + position.toString())

        holder.personTextview.text = people[position]

        if(peopledone[position] == true)
        {
            holder.personDoneTextview.visibility = View.VISIBLE
        } else {
            holder.personDoneTextview.visibility = View.GONE
        }

        holder.itemView.setOnClickListener {
            //people.removeAt(position)

            /*
            if(peopledone[position] == true)
            {
                peopledone[position] = false
            } else {
                peopledone[position] = true
            }
             */

            //peopledone[position] = peopledone[position] != true
            peopledone[position] = !peopledone[position]

            notifyDataSetChanged()
        }

    }

}

class HappyViewHolder (view: View) : RecyclerView.ViewHolder(view) {

    var personTextview = view.findViewById<TextView>(R.id.personTV)
    var personDoneTextview = view.findViewById<TextView>(R.id.doneTV)
}