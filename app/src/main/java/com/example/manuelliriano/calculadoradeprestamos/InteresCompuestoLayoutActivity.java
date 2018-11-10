package com.example.manuelliriano.calculadoradeprestamos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;



public class InteresCompuestoLayoutActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText monto, interes, cuotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interes_compuesto_layout);

        monto = findViewById(R.id.monto);
        interes=findViewById(R.id.tasa);
        cuotas=findViewById(R.id.tiempo);


        findViewById(R.id.btn_Calc_compuesto).setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        //Validar entradas
        if (monto.getText().toString().equals("")){
            Toast.makeText(InteresCompuestoLayoutActivity.this, "Por favor introduzca un monto", Toast.LENGTH_SHORT).show();
        }
        if (interes.getText().toString().equals("")){
            Toast.makeText(InteresCompuestoLayoutActivity.this, "Por favor introduzca una tasa de interes", Toast.LENGTH_SHORT).show();
        }
        if (cuotas.getText().toString().equals("")){
//                     cuotas.setHint("Introduzca cantidad de pagos a realizar");
            Toast.makeText(InteresCompuestoLayoutActivity.this, "Por favor introduzca cantidad de cuotas a pagar", Toast.LENGTH_SHORT).show();
        }
        else{

            String a = monto.getText().toString();
            String c = interes.getText().toString();
            String d= cuotas.getText().toString();


            Intent intent = new Intent(this,DisplayTableActivity.class);
            //Enviar variables al otro activity
            intent.putExtra("monto",a);
            intent.putExtra("interes",c);
            intent.putExtra("tiempo",d);

            startActivity(intent);

        }

    }
}
