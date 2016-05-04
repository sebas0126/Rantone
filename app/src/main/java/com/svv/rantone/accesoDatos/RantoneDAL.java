package com.svv.rantone.accesoDatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Sebas on 28/04/2016.
 */
public class RantoneDAL extends SQLiteOpenHelper{

    private static final String DATABASE_NOMBRE = "DBTonos";
    private static final int DATABASE_VERSION = 1;

    private static RantoneDAL _instancia;

    private final String sqlListas = "CREATE TABLE Listas (Id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, NombreLista NVARCHAR(50) NOT NULL );";
    private final String sqlPistas = "CREATE TABLE Pistas (Id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, NombrePista NVARCHAR(100) NOT NULL, IdLista INTEGER NULL, Ruta NVARCHAR(50) NULL, FOREIGN KEY(IdLista) REFERENCES Listas(Id));";


    private RantoneDAL(Context context){
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlListas);
        db.execSQL(sqlPistas);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);

        if(!db.isReadOnly()){
            //Activar llaves foraneas
            db.execSQL("PRAGMA foreign_keys=ON;");
        }
    }

    public static RantoneDAL getInstancia(Context context){
        if(_instancia == null){
            _instancia = new RantoneDAL(context.getApplicationContext());
        }
        return _instancia;
    }
}
