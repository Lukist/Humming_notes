package com.example.drawertry;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.io.Serializable;

public class CustomerShowInfo extends AppCompatActivity implements Serializable {

    ModeloClientes cliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_show_info);

        cliente = (ModeloClientes) getIntent().getSerializableExtra("cliente");

        TextView nombreStatus = findViewById(R.id.nombreStatus);
        nombreStatus.setText(cliente.getNombre());

        TextView cuilStatus = findViewById(R.id.cuilStatus);
        cuilStatus.setText(cliente.getCuil());

        TextView fechaNacimiento = findViewById(R.id.fechaNacimientoStatus);
        fechaNacimiento.setText(cliente.getFecha_nacimiento());

        TextView sexoStatus = findViewById(R.id.sexoStatus);
        sexoStatus.setText(cliente.getSex());

        TextView mailStatus = findViewById(R.id.mailStatus);
        mailStatus.setText(cliente.getMail());
    }
}