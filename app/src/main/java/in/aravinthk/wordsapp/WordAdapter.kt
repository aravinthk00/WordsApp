package `in`.aravinthk.wordsapp

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class WordAdapter: RecyclerView.Adapter<WordAdapter.WordHolder>() {

    class WordHolder(private val view: View):RecyclerView.ViewHolder(view) {
        val button = view.findViewById<Button>(R.id.button_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return WordHolder(adapterLayout)
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: WordHolder, position: Int) {

        holder.button.setOnClickListener{
            val context = holder.itemView.context
            var item = ""
            val queryUrl: Uri = Uri.parse("${DetailActivity.SEARCH_PREFIX}${item}")
            val intent = Intent(Intent.ACTION_VIEW, queryUrl)
            context.startActivity(intent)
        }
    }
}