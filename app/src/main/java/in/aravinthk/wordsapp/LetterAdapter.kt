package `in`.aravinthk.wordsapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.util.rangeTo
import androidx.recyclerview.widget.RecyclerView
import `in`.aravinthk.wordsapp.DetailActivity.Companion.LETTER

class LetterAdapter(): RecyclerView.Adapter<LetterAdapter.LetterHolder>() {

    private val letterList = ('A'). rangeTo ('Z').toList()

    class LetterHolder(private val itemView: View): RecyclerView.ViewHolder(itemView){
        val button = itemView.findViewById<Button>(R.id.button_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LetterHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_view, parent, false)
        return LetterHolder(adapterLayout)
    }

    override fun getItemCount(): Int {
        return letterList.size
    }

    override fun onBindViewHolder(holder: LetterHolder, position: Int) {

        var item = letterList[position]
        holder.button.text = item.toString()

        holder.button.setOnClickListener {
            val  context = holder.itemView.context
            val intent = Intent(context,DetailActivity::class.java)
            intent.putExtra(LETTER,holder.button.text.toString())
            context.startActivity(intent)
        }
    }
}