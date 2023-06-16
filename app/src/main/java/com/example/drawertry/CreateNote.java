package com.example.drawertry;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateNote extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_note);

        EditText asuntoInput, notaInput;
        Button addNoteBtn;
        DatabaseHelper db;

        ModeloClientes cliente = (ModeloClientes) getIntent().getSerializableExtra("cliente");

        asuntoInput = findViewById(R.id.asuntoInput);
        notaInput = findViewById(R.id.notaInput);
        addNoteBtn = findViewById(R.id.addNoteBtn);

        db = new DatabaseHelper(CreateNote.this);

        addNoteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Notas nota = new Notas(-1, cliente.getId(),asuntoInput.getText().toString(), notaInput.getText().toString(), true);
                    boolean success = db.agregarNota(nota);
                    Toast.makeText(CreateNote.this, nota.toString() + success, Toast.LENGTH_SHORT).show();
                }catch (Exception e) {
                    Toast.makeText(CreateNote.this, "Algo fue mal", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}