package com.example.isgil27.manejofragment.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.isgil27.manejofragment.Album;
import com.example.isgil27.manejofragment.BaseDatos.GestorAlbums;
import com.example.isgil27.manejofragment.R;

import java.util.ArrayList;

public class Fragment1 extends Fragment
{
    ArrayList<Album> albums;
    String[] arraydatosalbum;
    EditText edtnombreartista;
    EditText edtnombrealbum;
    Button btnañadir;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_fragment1,container,false);

        edtnombrealbum=v.findViewById(R.id.adtnombreaalbum);
        edtnombreartista=v.findViewById(R.id.edtnombreartist);
        btnañadir=(Button)v.findViewById(R.id.bntañadira);

        btnañadir.setOnClickListener(onAñadirAlbum);

        return v;

    }

    private void InicializarListaAlbums() {

        arraydatosalbum = new String[3];
        arraydatosalbum[0]=edtnombrealbum.getText().toString();
        arraydatosalbum[1]=edtnombreartista.getText().toString();
        arraydatosalbum[2]=String.valueOf(R.drawable.control);

        GestorAlbums gestorAlbums = new GestorAlbums(getActivity(),arraydatosalbum);
        gestorAlbums.InsertarUnAlbum();

    }

    public View.OnClickListener onAñadirAlbum= new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            InicializarListaAlbums();

        }
    };

}
