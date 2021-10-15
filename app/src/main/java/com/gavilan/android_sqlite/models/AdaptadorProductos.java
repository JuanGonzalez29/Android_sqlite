package com.gavilan.android_sqlite.models;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gavilan.android_sqlite.R;

import java.util.ArrayList;

public class AdaptadorProductos extends RecyclerView.Adapter<AdaptadorProductos.ViewHolder> {
    ArrayList<Producto>productos;

    public AdaptadorProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list_productos,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.cargarElementos(productos.get(position));
    }

    @Override
    public int getItemCount() {
        return productos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt_nombrePro, txt_stockPro, txt_precioPro;
        ImageView imgCategoria;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_nombrePro = itemView.findViewById(R.id.txt_nombrePro);
            txt_stockPro = itemView.findViewById(R.id.txtStockProd);
            txt_precioPro = itemView.findViewById(R.id.txt_precioPro);
            imgCategoria = itemView.findViewById(R.id.imgCategoria);

        }

        //Metodo para cargar los elementos del cardView
        public void cargarElementos(Producto p){
            String nombreProducto = p.getNombre();
            //Obtener el stock y el precio y pasarlos a String
            String stockProducto = String.valueOf(p.getStock());
            String precioProducto = String.valueOf(p.getPrecio());
            //Obtener el nombre de la categoria para luego cargar la imagen según el nombre
            String nombreCategoria = p.getCategoria().getNombre();

            //Colocar de aqui hacia abajo el codigo para cargar los elementos
            txt_nombrePro.setText(nombreProducto);
            txt_stockPro.setText(stockProducto);
            txt_precioPro.setText(precioProducto);

            if(nombreCategoria == "Computadores"){
                imgCategoria.setImageResource(R.drawable.computador);
            }else if(nombreCategoria == "Celulares"){
                imgCategoria.setImageResource(R.drawable.celular);
            }
        }
    }
}
