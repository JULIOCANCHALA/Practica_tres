package com.canchala.julio.app3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private TextView resultado;
    private EditText quices,exposiciones,labs,proyecto;
    private String a,b,c,d,res;
    private double num1,num2,num3,num4,r;

    public void click(View view)
    {
        a=quices.getText().toString();
        b=exposiciones.getText().toString();
        c=labs.getText().toString();
        d=proyecto.getText().toString();

        num1=Double.parseDouble(a);
        num2=Double.parseDouble(b);
        num3=Double.parseDouble(c);
        num4=Double.parseDouble(d);

        if (num1>5){num1=0;}
        if (num2>5){num2=0;}
        if (num3>5){num3=0;}
        if (num4>5){num4=0;}

        r=num1*0.15+num2*0.1+num3*0.4+num4*0.35;
        DecimalFormat decimales=new DecimalFormat("0.00");
        res=String.valueOf(decimales.format(r));

        resultado.setText(res);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultado=(TextView)findViewById(R.id.resultado);
        quices=(EditText)findViewById(R.id.quices);
        exposiciones=(EditText)findViewById(R.id.exposiciones);
        labs=(EditText)findViewById(R.id.labs);
        proyecto=(EditText)findViewById(R.id.proyecto);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
