package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FormActivity extends AppCompatActivity {

    Button btnLimpiar, btnSiguiente;
    EditText nombre, correo, direccion, telefono, fechaNacimiento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        btnLimpiar = findViewById(R.id.btn_limpiar);
        btnSiguiente = findViewById(R.id.btn_siguiente);

        nombre = findViewById(R.id.input_nombre);
        correo = findViewById(R.id.input_correo);
        direccion = findViewById(R.id.input_direccion);
        telefono = findViewById(R.id.input_telefono);
        fechaNacimiento = findViewById(R.id.input_fechaNacimiento);

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strNombre, strCorreo, strDireccion, strTelefono, strFechaNacimiento;
                strNombre = nombre.getText().toString();
                strCorreo = correo.getText().toString();
                strDireccion = direccion.getText().toString();
                strTelefono = telefono.getText().toString();
                strFechaNacimiento = fechaNacimiento.getText().toString();
                if(!strNombre.trim().equals("") && !strDireccion.trim().equals("") && !strTelefono.trim().equals("")
                && !strFechaNacimiento.trim().equals("")){

                    if(strCorreo.contains("@")){
                        Intent intent = new Intent(
                            v.getContext(),
                            ResultActivity.class);
                        intent.putExtra("nombre", strNombre);
                        intent.putExtra("correo", strCorreo);
                        intent.putExtra("direccion", strDireccion);
                        intent.putExtra("telefono", strTelefono);
                        intent.putExtra("fechaNacimiento", strFechaNacimiento);
                        startActivity(intent);
                    }else{
                        Toast.makeText(FormActivity.this, "Ingresa un correo válido", Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(FormActivity.this, "Completa correctamente los campos", Toast.LENGTH_LONG).show();
                }
            }
        });
        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nombre.setText("");
                correo.setText("");
                direccion.setText("");
                telefono.setText("");
                fechaNacimiento.setText("");
            }
        });
    }
}
