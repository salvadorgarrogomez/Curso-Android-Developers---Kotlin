package com.example.affirmations.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmations.R
import com.example.affirmations.model.Affirmation

// Adaptador para [RecyclerView] en [MainActivity]. Muestra el objeto de datos [Afirmación].
class ItemAdapter(
    private val context: Context,
    private val dataset: List<Affirmation>
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    /*
    * Proporcionar una referencia a las vistas para cada elemento de datos
    * Los elementos de datos complejos pueden necesitar más de una vista por elemento, y
    * proporcionas acceso a todas las vistas de un elemento de datos en un titular de vista.
    * Cada elemento de datos es solo un objeto de Afirmación.
     */
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view){
        val textView: TextView = view.findViewById(R.id.item_title)
    }

    // Crear nuevas vistas (invocadas por el administrador de diseño)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    // Devuelve el tamaño de su conjunto de datos (invocado por el administrador de diseño)
    override fun getItemCount() = dataset.size

    // Reemplazar el contenido de una vista (invocado por el administrador de diseño)
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text = context.resources.getString(item.stringResourceId)
    }
}