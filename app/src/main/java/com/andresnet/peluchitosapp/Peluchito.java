package com.andresnet.peluchitosapp;

public class Peluchito {
        //Propiedades
        private int idd;
        private String nombre;
        private double precio;
        private int cantidad;
        //Constructor
        public Peluchito(int id1,int can, double pre, String pname){
                nombre = pname;
                idd = id1;
                precio = pre;
                cantidad = can;
        }

        public int getIdd() {
                return idd;
        }

        public void setIdd(int id1) {
                idd = id1;
        }

        public String getNombre() {
                return nombre;
        }

        public void setNombre(String pname) {
                nombre = pname;
        }

        public double getPrecio() {
                return precio;
        }

        public void setPrecio(double pre) {
                precio = pre;
        }

        public int getCantidad() {
                return cantidad;
        }

        public void setCantidad(int can) {
                cantidad = can;
        }
}


