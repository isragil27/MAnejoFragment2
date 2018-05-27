package com.example.isgil27.manejofragment.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.isgil27.manejofragment.Adaptador;
import com.example.isgil27.manejofragment.Album;
import com.example.isgil27.manejofragment.BaseDatos.GestorAlbums;
import com.example.isgil27.manejofragment.R;
import java.util.ArrayList;

/**
 * Created by Israel on 02/05/2018.
 */
//HOLlalalalallalalala
public class Fragment2 extends Fragment {


    ArrayList<Album> albums;
    private RecyclerView listaAlbum;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment2,container, false);

        listaAlbum=v.findViewById(R.id.rcvlistaalbumes);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaAlbum.setLayoutManager(llm);

        GestorAlbums gestorAlbums = new GestorAlbums(this.getActivity());
        if(gestorAlbums.ObtenerTamaño()==0)
        {
            InicializarListaAlbums();
            InicializarAdaptador();
        }
        else
        {
            Cargarlistaalbums();
            InicializarAdaptador();
        }
        return v;
    }

    private void InicializarAdaptador() {
       Adaptador miadaptador= new Adaptador(albums);
        listaAlbum.setAdapter(miadaptador);

       }

       private void Cargarlistaalbums()
       {
           GestorAlbums gestorAlbums = new GestorAlbums(this.getActivity());
           albums = gestorAlbums.CargarAlbum();
       }

    private void InicializarListaAlbums() {


        GestorAlbums gestorAlbums = new GestorAlbums(this.getActivity());
        albums = gestorAlbums.AsignarAlbum();
    }


}
