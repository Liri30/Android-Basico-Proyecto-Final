package com.example.manuelliriano.calculadoradeprestamos;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, DialogInterface.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_interes).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        new AlertDialog.Builder(this).setTitle("Tipo de interes")
                .setPositiveButton("Compuesto",this)
                .setNegativeButton("Simple",this)
                .create().show();

    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        //String msg = "Res. %s: val: %d";
        switch (which){
            case AlertDialog.BUTTON_NEGATIVE:
          //      msg=String.format(msg,"Simple", AlertDialog.BUTTON_NEGATIVE);
                Intent intent2 = new Intent(MainActivity.this, InteresSimpleActivity.class);
                startActivity(intent2);
                break;

            case AlertDialog.BUTTON_POSITIVE:
                Intent intent = new Intent(MainActivity.this, InteresCompuestoLayoutActivity.class);
                startActivity(intent);
               // msg=String.format(msg,"Compuesto", AlertDialog.BUTTON_POSITIVE);
                break;
        }
        Toast.makeText(this,"Ingrese sus parametros",Toast.LENGTH_SHORT).show();

    }
}
