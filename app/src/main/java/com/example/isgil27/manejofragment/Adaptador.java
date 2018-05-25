package com.example.isgil27.manejofragment;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Israel on 09/05/2018.
 */

public class Adaptador extends RecyclerView.Adapter<Adaptador.AlbumViewHolder> {

    private ArrayList <Album> albums;

    public Adaptador(ArrayList<Album> albums) {
        this.albums = albums;
    }


    @Override
    public AlbumViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview,parent,false);
        return new AlbumViewHolder(v);
    }

    @Override
    public void onBindViewHolder(AlbumViewHolder holder, int position) {
        final Album album = albums.get(position);
        holder.txtvnombreartista.setText(album.getArtista());
        holder.txtvnombrealbum.setText(album.getNombre());
        holder.imgAlbum.setImageResource(album.getFoto());
    }

    @Override
    public int getItemCount() {
        return albums.size();
    }

    public static class AlbumViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgAlbum;
        private TextView txtvnombrealbum;
        private TextView txtvnombreartista;


        public AlbumViewHolder(View itemView) {
            super(itemView);

            imgAlbum=itemView.findViewById(R.id.imgFoto);
            txtvnombrealbum=itemView.findViewById(R.id.txtvnombrealbum);
            txtvnombreartista=itemView.findViewById(R.id.txtvnombreartista);
        }


    }
}
