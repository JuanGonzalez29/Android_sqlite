package com.gavilan.android_sqlite;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gavilan.android_sqlite.FormProductos;
import com.gavilan.android_sqlite.models.AdaptadorProductos;
import com.gavilan.android_sqlite.models.Categoria;
import com.gavilan.android_sqlite.models.Producto;
import com.gavilan.android_sqlite.sqlite.DbCategorias;
import com.gavilan.android_sqlite.sqlite.DbProductos;


import java.util.ArrayList;

public class ListProductsActivity extends AppCompatActivity {
  Button btnFilter, btnNoFilter;
  RecyclerView recyclerView;
  Spinner spFilterProd;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_form_productos);

    btnFilter = findViewById(R.id.btnFilter);
    btnNoFilter = findViewById(R.id.btnNoFilter);
    recyclerView = findViewById(R.id.recyclerProducts);
    spFilterProd = findViewById(R.id.spFilterProd);

    ArrayList<Categoria> categoryArrayList = new DbCategorias(this).obtenerTodas();
    ArrayAdapter<Categoria> categoryArrayAdapter =
        new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, categoryArrayList);
    spFilterProd.setAdapter(categoryArrayAdapter);

    ArrayList<Producto> productArrayList = new DbProductos(this).obtenerProductos();

    btnFilter.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            ArrayList<Producto> productArrayListFiltered = new ArrayList<>();
            Categoria category = (Categoria) spFilterProd.getSelectedItem();

            for (Producto p : productArrayList) {
              if (p.getCategoria().getId() == category.getId()) {
                productArrayListFiltered.add(p);
              }
            }

            AdaptadorProductos productsFiltered = new AdaptadorProductos(productArrayListFiltered);
            recyclerView.setAdapter(productsFiltered);
          }
        });

    btnNoFilter.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              AdaptadorProductos productAdapter = new AdaptadorProductos(productArrayList);
            recyclerView.setAdapter(productAdapter);
          }
        });

    recyclerView.setLayoutManager(new LinearLayoutManager(this));
    AdaptadorProductos productAdapter = new AdaptadorProductos(productArrayList);
    recyclerView.setAdapter(productAdapter);
  }
}
