package com.andresnet.peluchitosapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class VerInventarioFragment extends Fragment {
    private TextView tVerInventario;



    public VerInventarioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ver_inventario, container, false);
        tVerInventario = view.findViewById(R.id.fVerInventario);

        Bundle bundle = getArguments();
        String dep = bundle.getString("Peluchitos");
        tVerInventario.setText(dep);
        return view;
    }


}
