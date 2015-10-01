package com.canchala.julio.app5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private EditText nombre;
    private EditText apellido;
    private EditText indentifi;
    private TextView resul;
    private String sexo;
    private DatePicker fecha;
    private CheckBox h1;
    private CheckBox h2;
    private CheckBox h3;
    private CheckBox h4;
    int month;
    int year;
    int day;
    String[] ciudades={"Ciudad...","CUCUTA","CALI","BUCARAMANGA","BOGOTA","PEREIRA","IBAGUE","MEDELLIN","BARRANQUILLA","MANIZALES","PASTO","VILLAVICENCIO"};
    Spinner lugarnata;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre=(EditText)findViewById(R.id.nombre);
        apellido=(EditText)findViewById(R.id.apellido);
        indentifi=(EditText)findViewById(R.id.identifi);
        resul=(TextView)findViewById(R.id.res);
        h1=(CheckBox)findViewById(R.id.checkBox1);
        h2=(CheckBox)findViewById(R.id.checkBox2);
        h3=(CheckBox)findViewById(R.id.checkBox3);
        h4=(CheckBox)findViewById(R.id.checkBox4);
        fecha=(DatePicker)findViewById(R.id.fecha);
        lugarnata=(Spinner)findViewById(R.id.ciudades);
        ArrayAdapter<String> adaptador= new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, ciudades);

        lugarnata.setAdapter(adaptador);
    }

    public void selechombre(View view)
    {
        sexo="Hombre";
    }

    public void selecmujer(View view)
    {
        sexo="Mujer";


    }

    public void clickcalcular(View view)
    {
        String name=nombre.getText().toString();
        String lstname=apellido.getText().toString();
        String id=indentifi.getText().toString();

        year = fecha.getYear();
        month = fecha.getMonth();
        day = fecha.getDayOfMonth();

        String hb="";

        if(h1.isChecked())
        {
            hb= hb+"Leer Libros, ";
        }
        if(h2.isChecked())
        {
            hb= hb+"Juegar videojuegos, ";
        }
        if(h3.isChecked())
        {
            hb= hb+"Aprender un nuevo idioma, ";
        }
        if(h4.isChecked())
        {
            hb= hb+"Tocar un instrumento musical";
        }

        String city=lugarnata.getSelectedItem().toString();

                resul.setText("Nombre: "+name+"\n"+
                "Apellido: "+lstname+"\n"+
                "Identificacion: "+id+"\n"+
                "Sexo: "+sexo+"\n"+
                "Fecha de Nacimiento: " + new StringBuilder().append(day).append("-").append(month + 1).append("-").append(year).append(" ")+"\n"+
                "Ciudad: "+city+"\n"+
                "Hobbies: "+hb);
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
