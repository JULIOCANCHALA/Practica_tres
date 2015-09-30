package com.canchala.julio.app4;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LayoutAnimationController;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private LinearLayout layoutcirculo;
    private LinearLayout layoutcuadrado;
    private LinearLayout layoutrectangulo;
    private LinearLayout layouttriangulo;
    private ImageView imagen;
    private EditText radiocirculo;
    private TextView resultado;
    private EditText ladocuadrado;
    private double area;
    private String resarea;
    private EditText ladoarec;
    private EditText ladobrec;
    private EditText alturatri;
    private EditText basetri;
    DecimalFormat decimales=new DecimalFormat("0.00");




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layoutcirculo=(LinearLayout)findViewById(R.id.menucirculo);
        layoutcuadrado=(LinearLayout)findViewById(R.id.menucuadrado);
        layoutrectangulo=(LinearLayout)findViewById(R.id.menurectangulo);
        layouttriangulo=(LinearLayout)findViewById(R.id.menutriangulo);
        imagen=(ImageView)findViewById(R.id.imagen);
        radiocirculo=(EditText)findViewById(R.id.radiocirculo);
        resultado=(TextView)findViewById(R.id.resultado);
        ladoarec=(EditText)findViewById(R.id.ladoarec);
        ladobrec=(EditText)findViewById(R.id.ladobrec);
        alturatri=(EditText)findViewById(R.id.alturatri);
        basetri=(EditText)findViewById(R.id.basetri);
        ladocuadrado=(EditText)findViewById((R.id.ladocuadro));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void mostrarcirculo(View button)
    {
        imagen.setImageResource(R.drawable.circulo);

        ocultar(button, layoutcuadrado);
        ocultar(button,layoutrectangulo);
        ocultar(button, layouttriangulo);

        if (layoutcirculo.getVisibility() == View.GONE)
        {
            animar(true,layoutcirculo);
            layoutcirculo.setVisibility(View.VISIBLE);
        }



    }

    public void mostrarcuadrado(View button)
    {
        imagen.setImageResource(R.drawable.cuadrado);

        ocultar(button,layoutcirculo);
        ocultar(button,layoutrectangulo);
        ocultar(button,layouttriangulo);

        if (layoutcuadrado.getVisibility() == View.GONE)
        {
            animar(true,layoutcuadrado);
            layoutcuadrado.setVisibility(View.VISIBLE);
        }
    }
    public void mostrarrectangulo(View button)
    {

        imagen.setImageResource(R.drawable.rectangulo);

        ocultar(button,layoutcuadrado);
        ocultar(button,layoutcirculo);
        ocultar(button,layouttriangulo);

        if (layoutrectangulo.getVisibility() == View.GONE)
        {
            animar(true,layoutrectangulo);
            layoutrectangulo.setVisibility(View.VISIBLE);
        }
    }
    public void mostrartriguanlo(View button)
    {
        imagen.setImageResource(R.drawable.triangulo);

        ocultar(button,layoutcuadrado);
        ocultar(button,layoutrectangulo);
        ocultar(button,layoutcirculo);

        if (layouttriangulo.getVisibility() == View.GONE)
        {
            animar(true,layouttriangulo);
            layouttriangulo.setVisibility(View.VISIBLE);
        }
    }


    public void ocultar(View button,LinearLayout layoutnovisible)
    {
        if (layoutnovisible.getVisibility() == View.VISIBLE)
        {
            animar(false,layoutnovisible);
            layoutnovisible.setVisibility(View.GONE);
        }

    }

    private void animar(boolean mostrar,LinearLayout layoutAnimado)
    {
        AnimationSet set = new AnimationSet(true);
        Animation animation = null;
        if (mostrar)
        {
            //desde la esquina inferior derecha a la superior izquierda
            animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 1.0f, Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 1.0f, Animation.RELATIVE_TO_SELF, 0.0f);
        }
        else
        {    //desde la esquina superior izquierda a la esquina inferior derecha
            animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 1.0f, Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 1.0f);
        }
        //duración en milisegundos
        animation.setDuration(500);
        set.addAnimation(animation);
        LayoutAnimationController controller = new LayoutAnimationController(set, 0.25f);

        layoutAnimado.setLayoutAnimation(controller);
        layoutAnimado.startAnimation(animation);
    }

    public void areacirculo(View view)
    {
        String r=radiocirculo.getText().toString();
        double radio=0;
        radio=Double.parseDouble(r);

        area=Math.PI*Math.pow(radio,2);

        resarea=String.valueOf(decimales.format(area));

        resultado.setText(resarea);

    }

    public void areacuadrado(View view)
    {
        String a=ladocuadrado.getText().toString();
        double lado=0;
        lado=Double.parseDouble(a);

        area=lado*lado;

        resarea=String.valueOf(decimales.format(area));

        resultado.setText(resarea);


    }

    public void arearectangulo(View view)
    {
        String ar=ladoarec.getText().toString();
        String br=ladobrec.getText().toString();

        double ladoa=0;
        ladoa=Double.parseDouble(ar);
        double ladob=0;
        ladob=Double.parseDouble(br);

        area=ladoa*ladob;

        resarea=String.valueOf(decimales.format(area));

        resultado.setText(resarea);
    }

    public void areatriangulo(View view)
    {
        String h=alturatri.getText().toString();
        String b=basetri.getText().toString();

        double altura=0;
        altura=Double.parseDouble(h);
        double base=0;
        base=Double.parseDouble(b);

        area=(altura*base)/2;

        resarea=String.valueOf(decimales.format(area));

        resultado.setText(resarea);
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
