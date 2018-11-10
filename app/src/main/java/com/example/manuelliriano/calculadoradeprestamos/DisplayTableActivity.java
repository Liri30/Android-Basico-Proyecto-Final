package com.example.manuelliriano.calculadoradeprestamos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class DisplayTableActivity extends AppCompatActivity {



    //Variables a recibir
    private String monto;
    private String cuotas;
    private String interes;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_table);


        //Busco tabla en el XML
        TableLayout tableLayout = findViewById(R.id.table_amortizacio_layout);
        //Llamo tabla de amortizacion
        List<VariablePrestamo> tablaAmortizacion=TablaAmortizacion();


        //Llenar tabla
        for (VariablePrestamo i:tablaAmortizacion) {

            TableRow row = new TableRow(this);
            row.setWeightSum(5);

            //Parametros para estilo y set de las columnas
            TableRow.LayoutParams lp;


            TextView cantidad=new TextView(this);
            lp = new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0.6f);
            lp.gravity = Gravity.CENTER_HORIZONTAL;
            cantidad.setText(""+i.getN());
            cantidad.setLayoutParams(lp);

            TextView monto = new TextView(this);
            lp = new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1.1f);
            lp.gravity = Gravity.CENTER_HORIZONTAL;
            monto.setText(""+i.getCuota());
            monto.setLayoutParams(lp);

            TextView capital = new TextView(this);
            lp = new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1.1f);
            lp.gravity = Gravity.CENTER_HORIZONTAL;
            capital.setText(""+i.getCapital());
            capital.setLayoutParams(lp);

            TextView interes = new TextView(this);
            lp = new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1.1f);
            lp.gravity = Gravity.CENTER_HORIZONTAL;
            interes.setText(""+i.getInteres());
            interes.setLayoutParams(lp);

            TextView balance = new TextView(this);
            lp = new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1.1f);
            lp.gravity = Gravity.CENTER_HORIZONTAL;
            balance.setText(""+i.getBalance());
            balance.setLayoutParams(lp);


            //agregar datos a la fila
            row.addView(cantidad);
            row.addView(monto);
            row.addView(capital);
            row.addView(interes);
            row.addView(balance);
            //agregar fila a la tabla
             tableLayout.addView(row);


        }


    }



    //Funcion para tabla de amortizacion
    public List<VariablePrestamo> TablaAmortizacion(){

        Intent parametros = getIntent();

        cuotas = parametros.getStringExtra("tiempo");
        monto= parametros.getExtras().getString("monto");
        interes=parametros.getExtras().getString("interes");


        double principal = Double.parseDouble(monto);
        int lenght = Integer.parseInt(cuotas);
        double monthlyInterest= Double.parseDouble(interes)/(12*100);
        double monthlyPayment = principal *(monthlyInterest/(1-Math.pow((1+monthlyInterest),(lenght*-1))));
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        List<VariablePrestamo> table = new ArrayList<>();

        for (int x=1; x<=lenght; x++){
            VariablePrestamo valores = new VariablePrestamo();
            double amountInterest =principal*monthlyInterest;
            double amountPrincipal = monthlyPayment - amountInterest;
            principal = principal - amountPrincipal;

            valores.setCuota(nf.format(monthlyPayment));
            valores.setCapital(nf.format(amountPrincipal));
            valores.setInteres(nf.format(amountInterest));
            valores.setBalance(nf.format(principal));
            valores.setN(x);

            table.add(valores);
        }

        return table;

    }


}
