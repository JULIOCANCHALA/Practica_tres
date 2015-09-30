package com.canchala.julio.app2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText numero1,numero2;
    private TextView resultado;
    private String a,b,r;
    private double res,num1,num2;
    private int select;

    public void Click(View view)//seleccion de operacion
    {
        switch (view.getId())
        {
            case R.id.suma:
                select=1;
                break;
            case R.id.resta:
                select=2;
                break;
            case R.id.multiplicacion:
                select=3;
                break;
            case R.id.division:
                select=4;
                break;

        }

    }

    public void calcular(View view)
    {
        a=numero1.getText().toString();
        b=numero2.getText().toString();
        num1=Double.parseDouble(a);
        num2=Double.parseDouble(b);
        int v=0;

        switch (select)
        {
            case 1:
                res=num1+num2;
                break;
            case 2:
                res=num1-num2;
                break;
            case 3:
                res=num1*num2;
                break;
            case 4:
                if(num2!=0) {
                    res = num1 / num2;
                }
                else
                {
                    v=1;
                }
                break;
        }
        if(v==0)
        {
            DecimalFormat decimales=new DecimalFormat("0.00");
            r= String.valueOf(decimales.format(res));
            resultado.setText(r);
        }
        else {
            resultado.setText("MathError");
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numero1=(EditText)findViewById(R.id.numero1);
        numero2=(EditText)findViewById(R.id.numero2);
        resultado=(TextView)findViewById(R.id.resultado);


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
