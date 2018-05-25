package com.example.isgil27.manejofragment.BaseDatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.isgil27.manejofragment.Album;

import java.util.ArrayList;

/**
 * Created by Israel on 14/05/2018.
 */

public class MotorBaseDatos extends SQLiteOpenHelper {

    private Context context;
    public MotorBaseDatos(Context context) {
        super(context,ConstanteBaseDatos.DATABASE_NAME , null,ConstanteBaseDatos.DATABASE_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTableAlbum= "CREATE TABLE " + ConstanteBaseDatos.TABLE_ALBUMS_NAME + "(" +
                ConstanteBaseDatos.TABLE_ALBUM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstanteBaseDatos.TABLE_ALBUM_NOMBRE_ALBUM + " TEXT, " +
                ConstanteBaseDatos.TABLE_ALBUM_NOMBRE_ARTISTA + " TEXT, " +
                ConstanteBaseDatos.TABLE_ALBUM_NOMBRE_FOTO + " INTEGER" + ")";


        db.execSQL(queryCrearTableAlbum);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL( "DROP TABLE IF " + " EXISTS " + ConstanteBaseDatos.TABLE_ALBUMS_NAME);
        onCreate(db);

    }

    public ArrayList<Album> ExtraerALbumDataBase()
    {
        ArrayList<Album> albums = new ArrayList<>();

        String query = "SELECT * FROM " + ConstanteBaseDatos.TABLE_ALBUMS_NAME;
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor registros =db.rawQuery(query,null);

        while (registros.moveToNext())
        {
            Album albumactual = new Album(registros.getString(1),registros.getString(2),registros.getInt(3));
            albums.add(albumactual);
        }
        db.close();
        return albums;
    }

    public void InsertarAlbumes(ContentValues contentvalues)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstanteBaseDatos.TABLE_ALBUMS_NAME,null,contentvalues);
        db.close();
    }
}
