package com.example.manuelliriano.calculadoradeprestamos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;


public class InteresCompuestoLayoutActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText monto, interes, cuotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interes_compuesto_layout);

        monto = findViewById(R.id.monto);
        interes=findViewById(R.id.tasa);
        cuotas=findViewById(R.id.tiempo);

        monto.addTextChangedListener(onTextChangedListener());

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
            //Removing , from edit text
            a= a.replace(",","");
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
/*****TextWatcher******/
    private TextWatcher onTextChangedListener() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }



            @Override
            public void afterTextChanged(Editable s) {
                monto.removeTextChangedListener(this);

                try {
                    String originalString = s.toString();

                    Long longval;
                    if (originalString.contains(",")) {
                        originalString = originalString.replaceAll(",", "");
                    }
                    longval = Long.parseLong(originalString);

                    DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                    formatter.applyPattern("#,###,###,###");
                    String formattedString = formatter.format(longval);

                    //setting text after format to EditText
                    monto.setText(formattedString);
                    monto.setSelection(monto.getText().length());
                } catch (NumberFormatException nfe) {
                    nfe.printStackTrace();
                }

                monto.addTextChangedListener(this);
            }
        };
    }
}
