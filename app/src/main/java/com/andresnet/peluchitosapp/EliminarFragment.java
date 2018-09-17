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
public class EliminarFragment extends Fragment {
    private EditText eNom;
    private Button bBorrar;
    Comunicador canal;
    private static int y;


    public EliminarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_eliminar, container, false);
        eNom = view.findViewById(R.id.eElimnarPe);
        bBorrar = view.findViewById(R.id.bEliminar);

        bBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (eNom.getText().toString().isEmpty()){
                    Toast.makeText(getActivity(),"Digite el nombre.", Toast.LENGTH_SHORT).show();
                }
                else {
                    String nom = eNom.getText().toString();
                    canal.dSendData(nom);
                }
            }
        });

        Bundle bundle = getArguments();
        if(bundle != null){
            if (bundle.getString("Eliminado").equals("Eiminado")){
                Toast.makeText(getActivity(), "El contacto fue eliminado.", Toast.LENGTH_SHORT).show();
            }
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
