package com.example.drawertry;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String TABLA_CLIENTES = "TABLA_CLIENTES";
    public static final String COLUMN_CUSTOMER_ID = "CUSTOMER_ID";
    public static final String COLUMN_CUIL = "CUIL";
    public static final String COLUMN_NOMBRE = "NOMBRE";
    public static final String COLUMN_FECHA_NACIMIENTO = "FECHA_NACIMIENTO";
    public static final String COLUMN_SEXO = "SEXO";
    public static final String COLUMN_MAIL = "MAIL";

    /*public static final String TABLA_CLIENTES = "TABLA_CLIENTES";
    public static final String COLUMN_CUSTOMER_ID = "CUSTOMER_ID";
    public static final String COLUMN_NOMBRE = "NOMBRE";
    public static final String COLUMN_EDAD = "EDAD";*/

    public DatabaseHelper(@Nullable Context context) {
        super(context, "CustomerAnnotation.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        /*String createCustomerTable = "CREATE TABLE " + TABLA_CLIENTES + " (" + COLUMN_CUSTOMER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_NOMBRE + " TEXT, " + COLUMN_EDAD + " INT)";*/
        String createCustomerTable = "CREATE TABLE " + TABLA_CLIENTES + " (" + COLUMN_CUSTOMER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_CUIL + " TEXT, " + COLUMN_NOMBRE + " TEXT, " + COLUMN_FECHA_NACIMIENTO + " TEXT, " + COLUMN_SEXO + " TEXT, " + COLUMN_MAIL + " TEXT)";
        db.execSQL(createCustomerTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean agragarCliente(ModeloClientes cliente) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put(COLUMN_CUIL, cliente.getCuil());
        cv.put(COLUMN_NOMBRE,cliente.getNombre());
        cv.put(COLUMN_FECHA_NACIMIENTO,cliente.getFecha_nacimiento());
        cv.put(COLUMN_SEXO,cliente.getSex());
        cv.put(COLUMN_MAIL,cliente.getMail());


        long insert = db.insert(TABLA_CLIENTES, null, cv);

        if (insert == -1){
            return false;
        } else {
            return true;
        }
    }

    public List<ModeloClientes> getAllClientes() {
        List<ModeloClientes> returnList = new ArrayList<>();

        //query para optener datos de la base de datos
        String query = "SELECT * FROM " +  TABLA_CLIENTES;

        SQLiteDatabase db = this.getReadableDatabase();

        //cursor es un tipo de dato de la libreria sqlite que se utiliza para los resultados (resultsets) de las querys
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                int clienteId = cursor.getInt(0);
                String clienteCuil = cursor.getString(1);
                String clienteNombre = cursor.getString(2);
                String clienteFechaNacimiento = cursor.getString(3);
                String clienteSexo = cursor.getString(4);
                String clienteMail = cursor.getString(5);


                ModeloClientes nuevoCliente = new ModeloClientes(clienteId, clienteCuil, clienteNombre, clienteFechaNacimiento, clienteSexo, clienteMail);
                returnList.add(nuevoCliente);
            }while(cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return  returnList;
    }
}
