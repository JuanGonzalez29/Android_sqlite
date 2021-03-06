package com.gavilan.android_sqlite.models;

import java.util.ArrayList;

public class Producto {
    private int id;
    private String nombre;
    private String marca;
    private String modelo;
    private int precio;
    private int stock;
    private Categoria categoria;

    public Producto() {
    }

    public Producto(String nombre, String marca, String modelo, int precio, int stock, Categoria categoria) {
        this.nombre = nombre;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
    }

    public Producto(int id, String nombre, String marca, String modelo, int precio, int stock, Categoria categoria) {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
    }


    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString(){
        return this.nombre+"-"+this.marca+"- $"+this.precio;
    }

}
