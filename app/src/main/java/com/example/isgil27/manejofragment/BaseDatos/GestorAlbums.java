package com.example.isgil27.manejofragment.BaseDatos;
import android.content.ContentValues;
import android.content.Context;
import com.example.isgil27.manejofragment.Album;
import com.example.isgil27.manejofragment.R;
import java.util.ArrayList;

/**
 * Created by Israel on 14/05/2018.
 */

public class GestorAlbums {

    private Context context;
    private  String [] datosalbum;

    public GestorAlbums(Context context)
    {
        this.context = context;
    }


    public GestorAlbums(Context context,String[] datosalbum) {
        this.context = context;
        this.datosalbum = datosalbum;
    }


    public ArrayList<Album> CargarAlbum()
    {
        MotorBaseDatos db = new MotorBaseDatos(context);
        return db.ExtraerALbumDataBase();
    }
    public ArrayList<Album> AsignarAlbum()
    {
        MotorBaseDatos db = new MotorBaseDatos(context);
            InsetarDosALbumes(db);
        return db.ExtraerALbumDataBase();
    }

    public int ObtenerTamaño()
    {
        int tamaño;
        MotorBaseDatos db = new MotorBaseDatos(context);
        tamaño= db.ExtraerALbumDataBase().size();
        return tamaño;
    }

    public   void InsertarUnAlbum ()
    {
        MotorBaseDatos db = new MotorBaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstanteBaseDatos.TABLE_ALBUM_NOMBRE_ALBUM,datosalbum[0]);
        contentValues.put(ConstanteBaseDatos.TABLE_ALBUM_NOMBRE_ARTISTA,datosalbum[1]);
        contentValues.put(ConstanteBaseDatos.TABLE_ALBUM_NOMBRE_FOTO,Integer.valueOf(datosalbum[2]));
        db.InsertarAlbumes(contentValues);

    }

    private void InsetarDosALbumes(MotorBaseDatos db) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstanteBaseDatos.TABLE_ALBUM_NOMBRE_ALBUM,"The Suburbs");
        contentValues.put(ConstanteBaseDatos.TABLE_ALBUM_NOMBRE_ARTISTA,"Arcade Fire");
        contentValues.put(ConstanteBaseDatos.TABLE_ALBUM_NOMBRE_FOTO, R.drawable.control);
        db.InsertarAlbumes(contentValues);

        contentValues.put(ConstanteBaseDatos.TABLE_ALBUM_NOMBRE_ALBUM,"Neon Bible");
        contentValues.put(ConstanteBaseDatos.TABLE_ALBUM_NOMBRE_ARTISTA,"Arcade Fire");
        contentValues.put(ConstanteBaseDatos.TABLE_ALBUM_NOMBRE_FOTO, R.drawable.electronica);
        db.InsertarAlbumes(contentValues);

        contentValues.put(ConstanteBaseDatos.TABLE_ALBUM_NOMBRE_ALBUM,"Modern Man");
        contentValues.put(ConstanteBaseDatos.TABLE_ALBUM_NOMBRE_ARTISTA,"Arcade Fire");
        contentValues.put(ConstanteBaseDatos.TABLE_ALBUM_NOMBRE_FOTO, R.drawable.fisica);
        db.InsertarAlbumes(contentValues);
    }

}
