package com.example.boxinventario.adapted;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.boxinventario.entidades.Producto;
import com.example.boxinventario.R;

import java.util.List;

public class AdaptadorProducto extends RecyclerView.Adapter<AdaptadorProducto.ViewHolder> {

    private List<Producto> mData;
    private LayoutInflater mInflater;
    private Context context;

    final AdaptadorProducto.OnItemClickListener listener;
    public interface OnItemClickListener {
        void onItemClick(Producto item);
    }

    public AdaptadorProducto(List<Producto> itemList, Context context, AdaptadorProducto.OnItemClickListener listener) {
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = itemList;
        this.listener = listener;
    }

    @Override
    public int getItemCount(){ return mData.size(); }

    @Override
    public AdaptadorProducto.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = mInflater.inflate(R.layout.item_productos,null);
        return new AdaptadorProducto.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AdaptadorProducto.ViewHolder holder, final int position){
        holder.bindData(mData.get(position));
    }

    public void setItem(List<Producto> item){ mData = item; }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView iconImagen;
        TextView nombre, fecha, cantidad, ubicacion, precio, categoria;

        ViewHolder(View itemView){
            super(itemView);
            iconImagen = itemView.findViewById(R.id.iconproducto);
            nombre = itemView.findViewById(R.id.NameLista);
            fecha = itemView.findViewById(R.id.fechacompra);
            cantidad = itemView.findViewById(R.id.numerocantidadproducto);
            ubicacion = itemView.findViewById(R.id.ubicacionlista);
            precio = itemView.findViewById(R.id.numeroprecioproducto);
            categoria = itemView.findViewById(R.id.nombrecategoriaproducto);
        }

        void bindData(final Producto item){
            iconImagen.setColorFilter(Color.parseColor(item.getColor()), PorterDuff.Mode.SRC_IN);
            nombre.setText(item.getNameproducto());
            fecha.setText(String.valueOf(item.getFechaproducto()));
            cantidad.setText(item.getCantidad());
            ubicacion.setText(item.getUbicacion());
            precio.setText(item.getPrecio());
            categoria.setText(item.getCategoria());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });
        }

    }

}
