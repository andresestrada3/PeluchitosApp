package com.andresnet.peluchitosapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, Comunicador {
             private FragmentManager fm;
             private FragmentTransaction ft;
             public Bundle ag = new Bundle();
             public String dep;
             public ArrayList<Peluchito> peluchitos = new ArrayList<Peluchito>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        AgregarFragment agregarFragment = new AgregarFragment();
        ft.add(R.id.frame, agregarFragment).commit();
        dep = "";
    }

    @Override
    public void SendData(int cid, int cCanti, double cPrecio, String cNombre) {
        Peluchito peluche = new Peluchito(cid, cCanti, cPrecio, cNombre);
        peluche.setIdd(cid);
        peluche.setCantidad(cCanti);
        peluche.setPrecio(cPrecio);
        peluche.setNombre(cNombre);
        peluchitos.add(peluche);
        dep+="\n\nId: "+String.valueOf(cid)+"\nNombre: "+cNombre+ "\nCantidad: "+String.valueOf(cCanti)+ "\nPrecio: "+String.valueOf(cPrecio);
    }

    @Override
    public void dSendData(String dNombre) {
        dep="";
        String d = "Elminado";
        for (int i=0; i<peluchitos.size(); i++){
            if(peluchitos.get(i).getNombre().equals(dNombre)){
                peluchitos.remove(i);
                ag.putString("Eliminado", d);
            }
        }
        for (int i=0; i<peluchitos.size(); i++){
            dep+="\n\nId: "+String.valueOf(peluchitos.get(i).getIdd())+
                    "\nNombre:"+peluchitos.get(i).getNombre()+
                    "\nCantidad: "+String.valueOf(peluchitos.get(i).getCantidad())+
                    "\nPrecio: "+String.valueOf(peluchitos.get(i).getPrecio());
        }
        EliminarFragment eliminarFragment = new EliminarFragment();
        eliminarFragment.setArguments(ag);
        ft = fm.beginTransaction();
        ft.replace(R.id.frame, eliminarFragment).commitNow();

    }

    @Override
    public void sSendData(String sNombre) {
        for (int i=0; i<peluchitos.size(); i++){
            if(peluchitos.get(i).getNombre().equals(sNombre)){
                ag.putString("Nombre",sNombre);
                ag.putInt("Id", peluchitos.get(i).getIdd());
                ag.putInt("Cantidad", peluchitos.get(i).getCantidad());
                ag.putDouble("Precio", peluchitos.get(i).getPrecio());
                BuscarFragment buscarFragment = new BuscarFragment();
                buscarFragment.setArguments(ag);
                ft = fm.beginTransaction();
                ft.replace(R.id.frame, buscarFragment).commit();
            }

        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        ft=fm.beginTransaction();

        if (id == R.id.fAgregar) {
            AgregarFragment agregarFragment = new AgregarFragment();
            ft.replace(R.id.frame, agregarFragment ).commit();

        } else if (id == R.id.fBuscar) {
            BuscarFragment buscarFragment = new BuscarFragment();
            ft.replace(R.id.frame, buscarFragment ).commit();

        } else if (id == R.id.fEliminar) {
            EliminarFragment eliminarFragment = new EliminarFragment();
            ft.replace(R.id.frame, eliminarFragment).commit();

        } else if (id == R.id.fVerInventario) {
            VerInventarioFragment verInventarioFragment = new VerInventarioFragment();
            ag.putString("Peluchitos",dep);
            verInventarioFragment.setArguments(ag);
            ft.replace(R.id.frame, verInventarioFragment ).commit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
