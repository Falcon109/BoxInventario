    package com.example.boxinventario.adapted;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.boxinventario.clases.Inventario;
import com.example.boxinventario.clases.DescripcionProductos;
import com.example.boxinventario.entidades.Producto;
import com.example.boxinventario.R;

import java.util.ArrayList;

    public class AdaptadorProducto extends RecyclerView.Adapter<AdaptadorProducto.MyViewHolder> {

    private final Context context;
    static ArrayList<Producto> ProductosArrayList;
    static ArrayList<Producto> ProductosArrayListBuscador;

    SQLiteDatabase sqLiteDatabase;

    public AdaptadorProducto(Context context, ArrayList<Producto> productos) {
        this.context = context;
        this.ProductosArrayList = productos;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(context).inflate(R.layout.item_productos,parent,false);
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

        // agregar evento de clic al ViewHolder
        holder.itemView.setOnClickListener(view -> {
            // crear Intent para abrir la nueva actividad
            Intent intent = new Intent(context, DescripcionProductos.class);

            // pasar información del producto seleccionado a través de los extras
            intent.putExtra("ID",producto.getId());

            // abrir la nueva actividad
            context.startActivity(intent);
        });
    }




    @Override
    public int getItemCount(){
        return ProductosArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Nombre , Ubicacion, Fecha, Cantidad, Precio, Categoria;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Nombre = itemView.findViewById(R.id.NombreLugar);
            Fecha = itemView.findViewById(R.id.fechacompra);
            Cantidad = itemView.findViewById(R.id.numerocantidadproducto);
            Precio = itemView.findViewById(R.id.numeroprecioproducto);
            Categoria = itemView.findViewById(R.id.nombrecategoriaproducto);
            Ubicacion = itemView.findViewById(R.id.ubicacionlista);

            itemView.setOnClickListener(view -> {
                Context context = view.getContext();
                Intent intent = new Intent(context, Inventario.class);
                intent.putExtra("ID",ProductosArrayList.get(getAdapterPosition()).getId());
                context.startActivities(new Intent[]{intent});
            });
        }
    }
}
