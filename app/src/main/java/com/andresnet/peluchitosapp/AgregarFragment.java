package com.andresnet.peluchitosapp;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class AgregarFragment extends Fragment {
    private EditText eID, eNom, eCan, ePrec;
    private Button bAgre;
    Comunicador canal;


    public AgregarFragment() {
        // Required empty public constructor


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_agregar, container, false);
        eID = view.findViewById(R.id.eID);
        eNom = view.findViewById(R.id.eNombre);
        eCan = view.findViewById(R.id.eCantidad);
        ePrec = view.findViewById(R.id.ePrecio);
        bAgre = view.findViewById(R.id.bAgregar);

        bAgre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre;
                int ids, cant;
                double precio;


                if(eID.getText().toString().isEmpty() || eNom.getText().toString().isEmpty() || eCan.getText().toString().isEmpty() || ePrec.getText().toString().isEmpty()){
                    Toast.makeText(getActivity(), "Llene todos los campos.", Toast.LENGTH_SHORT).show();
                }
                else {
                    nombre=eNom.getText().toString();
                    precio=Double.parseDouble(ePrec.getText().toString());
                    ids=Integer.parseInt(eID.getText().toString());
                    cant=Integer.parseInt(eCan.getText().toString());
                    canal.SendData(ids, cant, precio, nombre);

                }

            }
        });
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
