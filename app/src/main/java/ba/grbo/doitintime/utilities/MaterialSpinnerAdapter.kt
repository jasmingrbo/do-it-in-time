package ba.grbo.doitintime.utilities

import android.content.Context
import android.widget.ArrayAdapter
import android.widget.Filter

class MaterialSpinnerAdapter<String>(
    context: Context,
    layout: Int,
    val values: List<String>
) : ArrayAdapter<String>(context, layout, values) {
    private val filterThatDoesNothing = object : Filter() {
        override fun performFiltering(constraint: CharSequence?): FilterResults {
            val results = FilterResults()
            results.values = values
            results.count = values.size
            return results
        }

        override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
            notifyDataSetChanged()
        }
    }

    override fun getFilter(): Filter {
        return filterThatDoesNothing
    }
}