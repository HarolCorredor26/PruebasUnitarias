package com.example.parcial11;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registros extends AppCompatActivity {
    EditText name, contact, dob;
    Button insert, update, delete, view;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registros);
        name = findViewById(R.id.name);
        contact = findViewById(R.id.contact);
        dob = findViewById(R.id.dob);
        insert = findViewById(R.id.btnInsert);
        update = findViewById(R.id.btnUpdate);
        delete = findViewById(R.id.btnDelete);
        view = findViewById(R.id.btnView);
        DB = new DBHelper(this);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();
                String contactTXT = contact.getText().toString();
                String dobTXT = dob.getText().toString();

                Boolean checkinsertdata = DB.insertuserdata(nameTXT, contactTXT, dobTXT);
                if(checkinsertdata==true)
                    Toast.makeText(Registros.this, "INFORMACION REGISTRADA", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(Registros.this, "ERROR AL REGISTRO DE INFORMACION", Toast.LENGTH_SHORT).show();
            }        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();
                String contactTXT = contact.getText().toString();
                String dobTXT = dob.getText().toString();

                Boolean checkupdatedata = DB.updateuserdata(nameTXT, contactTXT, dobTXT);
                if(checkupdatedata==true)
                    Toast.makeText(Registros.this, "INFORMACION ACTUALIZADA", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(Registros.this, "NO FUE POSIBLE LA ACTUALIZACION", Toast.LENGTH_SHORT).show();
            }        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();
                Boolean checkudeletedata = DB.deletedata(nameTXT);
                if(checkudeletedata==true)
                    Toast.makeText(Registros.this, "INFORMACION ELIMINADA", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(Registros.this, "NO FUE POSIBLE ELIMINAR LA INFOMACION", Toast.LENGTH_SHORT).show();
            }        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = DB.getdata();
                if(res.getCount()==0){
                    Toast.makeText(Registros.this, "INFORMACION NO EXISTE", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("Nombre :"+res.getString(0)+"\n");
                    buffer.append("Telefono :"+res.getString(1)+"\n");
                    buffer.append("Fecha de Nacimiento :"+res.getString(2)+"\n\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(Registros.this);
                builder.setCancelable(true);
                builder.setTitle("INFORMACION DE USUARIO");
                builder.setMessage(buffer.toString());
                builder.show();
            }        });
    }

    public void onClick(DBHelper mock) {
    }
}