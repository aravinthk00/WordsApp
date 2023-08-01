package `in`.aravinthk.wordsapp

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class WordAdapter(
    private val letter : String,
    private val context : Context
): RecyclerView.Adapter<WordAdapter.WordHolder>() {

    private val filterData : List<String>

    init {
        val words = context.resources.getStringArray(R.array.words).toList()

        filterData = words
            .filter { it.startsWith(letter, ignoreCase = true) }
            .shuffled()
            .take(5)
            .sorted()
    }

    class WordHolder( val view: View):RecyclerView.ViewHolder(view) {
        val button = view.findViewById<Button>(R.id.button_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return WordHolder(adapterLayout)
    }

    override fun getItemCount(): Int {
        return filterData.size
    }

    override fun onBindViewHolder(holder: WordHolder, position: Int) {

        holder.button.text = filterData[position].toString()

        holder.button.setOnClickListener{
            val context = holder.view.context
            val item = filterData[position]
            val queryUrl: Uri = Uri.parse("${DetailActivity.SEARCH_PREFIX}${item}")
            val intent = Intent(Intent.ACTION_VIEW, queryUrl)
            context.startActivity(intent)
        }
    }
}