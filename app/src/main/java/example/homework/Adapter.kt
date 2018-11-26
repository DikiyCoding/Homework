package example.homework

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

internal abstract class Adapter(context: Context, private val items: List<Item>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    private val inflater: LayoutInflater

    init {
        this.inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = items[position].name
    }

    override fun getItemCount(): Int {
        return items.size
    }

    internal inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        internal val name: TextView
        private val clickListener: View.OnClickListener

        init {
            name = itemView.findViewById(R.id.tv_name)
            clickListener = View.OnClickListener { onItemClicked(adapterPosition) }
            itemView.setOnClickListener(clickListener)
        }
    }

    abstract fun onItemClicked(position: Int)
}
