package com.andresnet.peluchitosapp;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class BuscarFragment extends Fragment {
    private Button bBuscar;
    private TextView tBuscar;
    private EditText eNombre;

    Comunicador canal;


    public BuscarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_buscar, container, false);
        eNombre = view.findViewById(R.id.eBuscar);
        tBuscar = view.findViewById(R.id.tbNombre);
        bBuscar = view.findViewById(R.id.bBuscar);

        bBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (eNombre.getText().toString().isEmpty()){
                    Toast.makeText(getActivity(), "Digite el nombre.", Toast.LENGTH_SHORT).show();
                }
                else {
                    String nombre = eNombre.getText().toString();
                    canal.sSendData(nombre);

                }
            }
        });
        Bundle bundle = getArguments();
        if (bundle!=null){
            String cNombre = bundle.getString("Nombre");
            int cid = bundle.getInt("Id");
            int cCantidad = bundle.getInt("Cantidad");
            double cPrecio = bundle.getDouble("Precio");
            tBuscar.setText("\nId: "+cid+"\nNombre: "+cNombre+"\nCantidad: "+cCantidad+"\nPrecio: "+cPrecio);
        }
        return view;
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{
            canal = (Comunicador) activity;
        }catch(ClassCastException e){

        }
    }

}
