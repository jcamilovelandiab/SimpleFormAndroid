package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView nombre, correo, direccion, telefono, fechaNacimiento;
    Button btnSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        btnSalir = findViewById(R.id.btn_salirResult);
        nombre = findViewById(R.id.txt_nombre);
        correo = findViewById(R.id.txt_correo);
        direccion = findViewById(R.id.txt_direccion);
        telefono = findViewById(R.id.txt_telefono);
        fechaNacimiento = findViewById(R.id.txt_fechaNacimiento);

        Bundle bundle = this.getIntent().getExtras();
        if(bundle !=null){
            String strNombre, strCorreo, strDireccion, strTelefono, strFechaNacimiento;
            strNombre = "Nombre: " + bundle.getString("nombre", "sin nombre");
            strCorreo = "Correo: " + bundle.getString("correo", "sin correo");
            strDireccion = "Direccion: " + bundle.getString("direccion", "sin direccion");
            strTelefono = "Telefono: "+ bundle.getString("telefono", "sin telefono");
            strFechaNacimiento = "Fecha de Nacimiento: " + bundle.getString("fechaNacimiento", "sin fecha de nacimiento");

            nombre.setText(strNombre);
            correo.setText(strCorreo);
            direccion.setText(strDireccion);
            telefono.setText(strTelefono);
            fechaNacimiento.setText(strFechaNacimiento);
        }

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
