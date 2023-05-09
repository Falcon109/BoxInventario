package com.example.boxinventario.adapted;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.boxinventario.entidades.Producto;
import com.example.boxinventario.R;

import java.util.ArrayList;

public class AdaptadorProducto extends RecyclerView.Adapter<AdaptadorProducto.MyViewHolder> {

    private Context context;
    ArrayList<Producto> ProductosArrayList;

    SQLiteDatabase sqLiteDatabase;

    public AdaptadorProducto(ArrayList<Producto> productos) {
        this.ProductosArrayList = productos;
    }

    @NonNull
    @Override
    public AdaptadorProducto.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_productos,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Producto producto = ProductosArrayList.get(position);
        holder.Nombre.setText(producto .getNameproducto());
        holder.Fecha.setText(producto.getFechaproducto());
        holder.Cantidad.setText(producto.getCantidad());
        holder.Precio.setText(producto.getPrecio());
        holder.Categoria.setText(producto.getCategoria());
        holder.Ubicacion.setText(producto.getUbicacion());

    }

    @Override
    public int getItemCount(){
        return ProductosArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Nombre , Ubicacion, Fecha, Cantidad, Precio, Categoria;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Nombre = (TextView)itemView.findViewById(R.id.NameLista);
            Fecha = (TextView)itemView.findViewById(R.id.fechacompra);
            Cantidad = (TextView)itemView.findViewById(R.id.numerocantidadproducto);
            Precio = (TextView)itemView.findViewById(R.id.numeroprecioproducto);
            Categoria = (TextView)itemView.findViewById(R.id.nombrecategoriaproducto);
            Ubicacion = (TextView)itemView.findViewById(R.id.ubicacionlista);
        }
    }
}
