package com.example.boxinventario;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListaAdaptador extends RecyclerView.Adapter<ListaAdaptador.ViewHolder> {

    private List<ListaProducto> mData;
    private LayoutInflater mInflater;
    private Context context;

    public  ListaAdaptador(List<ListaProducto> itemList, Context context){
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = itemList;
    }

    @Override
    public int getItemCount(){ return mData.size(); }

    @Override
    public ListaAdaptador.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = mInflater.inflate(R.layout.list_item_productos,null);
        return new ListaAdaptador.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListaAdaptador.ViewHolder holder, final int position){
        holder.bindData(mData.get(position));
    }

    public void setItem(List<ListaProducto> item){ mData = item; }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView iconImagen;
        TextView nombre, fecha, cantidad;

        ViewHolder(View itemView){
            super(itemView);
            iconImagen = itemView.findViewById(R.id.iconproducto);
            nombre = itemView.findViewById(R.id.NameProducto);
            fecha = itemView.findViewById(R.id.fechacompra);
            cantidad = itemView.findViewById(R.id.Cantidadproducto);
        }

        void bindData(final ListaProducto item){
            iconImagen.setColorFilter(Color.parseColor(item.getColor()), PorterDuff.Mode.SRC_IN);
            nombre.setText(item.getNameProducto());
            fecha.setText(item.getFechaProducto());
            cantidad.setText(item.getCantidad());
        }

    }

}
