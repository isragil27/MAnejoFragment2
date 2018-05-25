package com.example.isgil27.manejofragment;

/**
 * Created by Israel on 09/05/2018.
 */


public class Album {

    public Album(String nombre, String artista, int foto) {
        this.nombre = nombre;
        this.artista = artista;
        this.foto = foto;
    }

    String nombre;

    String artista;
    int foto;





    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }



    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }


}
