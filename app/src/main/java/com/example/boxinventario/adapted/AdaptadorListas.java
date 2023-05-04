package com.example.boxinventario.adapted;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.boxinventario.entidades.ListaRecordatorio;
import com.example.boxinventario.R;

import java.util.List;

public class AdaptadorListas extends RecyclerView.Adapter<AdaptadorListas.ViewHolder> {

    private List<ListaRecordatorio> mData;
    private LayoutInflater mInflater;
    private Context context;

    public AdaptadorListas(List<ListaRecordatorio> itemList, Context context){
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = itemList;
    }

    @Override
    public int getItemCount(){ return mData.size(); }

    @Override
    public AdaptadorListas.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = mInflater.inflate(R.layout.item_recordatorios,null);
        return new AdaptadorListas.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AdaptadorListas.ViewHolder holder, final int position){
        holder.bindData(mData.get(position));
    }

    public void setItem(List<ListaRecordatorio> item){ mData = item; }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView iconImagen2;
        TextView nombre2, fecha2, status2;

        ViewHolder(View itemView){
            super(itemView);
            iconImagen2 = itemView.findViewById(R.id.iconrecordatorio);
            nombre2 = itemView.findViewById(R.id.NameRecordatorio);
            fecha2 = itemView.findViewById(R.id.fechaRecordatorio);
            status2 = itemView.findViewById(R.id.status);
        }

        void bindData(final ListaRecordatorio item){
            iconImagen2.setColorFilter(Color.parseColor(item.getColor()), PorterDuff.Mode.SRC_IN);
            nombre2.setText(item.getNameRecordatorio());
            fecha2.setText(item.getFechaRecordatoio());
            status2.setText(item.getStatus());
        }

    }


}
