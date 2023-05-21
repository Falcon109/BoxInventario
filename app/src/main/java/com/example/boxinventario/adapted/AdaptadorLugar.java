package com.example.boxinventario.adapted;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.boxinventario.DescripcionLugares;
import com.example.boxinventario.R;
import com.example.boxinventario.clases.ApartadoLugarDeInteres;
import com.example.boxinventario.clases.DescripcionProductos;
import com.example.boxinventario.clases.Inventario;
import com.example.boxinventario.entidades.LugaresDeInteres;
import com.example.boxinventario.entidades.Producto;

import java.text.BreakIterator;
import java.util.ArrayList;

public class AdaptadorLugar extends RecyclerView.Adapter<AdaptadorLugar.MyViewHolder>{

    private final Context context;
    static ArrayList<LugaresDeInteres> LugaresArrayList;

    public AdaptadorLugar(Context context, ArrayList<LugaresDeInteres> lugaresinteres) {
        this.context = context;
        this.LugaresArrayList = lugaresinteres;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(context).inflate(R.layout.item_lugaresinteres,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        LugaresDeInteres lugaresDeInteres = LugaresArrayList.get(position);
        holder.NombreLugar.setText(lugaresDeInteres.getNombre_lugar());
        holder.LinkLugar.setText(lugaresDeInteres.getLink());
        holder.Puntaje.setText(lugaresDeInteres.getPuntaje());

        // agregar evento de clic al ViewHolder
        holder.itemView.setOnClickListener(view -> {
            // crear Intent para abrir la nueva actividad
            Intent intent = new Intent(context, DescripcionLugares.class);

            // pasar información del producto seleccionado a través de los extras
            intent.putExtra("ID",lugaresDeInteres.getId_lugares());

            // abrir la nueva actividad
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount(){
        return LugaresArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView NombreLugar , LinkLugar, Puntaje;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            NombreLugar = itemView.findViewById(R.id.NombreLugar);
            LinkLugar = itemView.findViewById(R.id.ubicacionlista);
            Puntaje = itemView.findViewById(R.id.PuntajeLugar);

            itemView.setOnClickListener(view -> {
                Context context = view.getContext();
                Intent intent = new Intent(context, ApartadoLugarDeInteres.class);
                intent.putExtra("ID",LugaresArrayList.get(getAdapterPosition()).getId_lugares());
                context.startActivities(new Intent[]{intent});
            });
        }
    }
}
