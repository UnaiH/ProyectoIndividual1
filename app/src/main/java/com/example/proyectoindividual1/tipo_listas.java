package com.example.proyectoindividual1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.Locale;

public class tipo_listas extends AppCompatActivity implements View.OnClickListener {
    private String usuario="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (savedInstanceState!= null) {
            usuario= savedInstanceState.getString("usuario");
        }
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            usuario = extras.getString("usuario");
        }
        //Se pone el modo oscuro si así se especifica en las preferencias y también se modifica el idioma.
        new Idiomas().setIdioma(this);
        new Pantalla().cambiarPantallaMenus(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_listas);
    }

    public void onClickALibro(View view) {
        //Se pasa a la activity para añadir el libro.
        Intent i = new Intent(this, anadirLibroALista.class);
        i.putExtra("usuario", usuario);
        setResult(RESULT_OK, i);
        finish();
        startActivity(i);
    }
    public void onClickLeidos(View view) {
        //Se pasa a la activity que se corresponde la lista de libros ya leidos.
        Intent i = new Intent(this, leidos.class);
        i.putExtra("usuario", usuario);
        setResult(RESULT_OK, i);
        startActivity(i);
    }
    public void onClickLeyendo(View view) {
        //Al pulsar se irá a la interfaz donde se mostrarán los libros que el usuario se está leyendo en este momento.
        Intent i = new Intent(this, activListaleyendo.class);
        i.putExtra("usuario", usuario);
        setResult(RESULT_OK, i);
        startActivity(i);
    }

    public void onClickVolver(View view) {
        //Al pulsar se devolverá al usuario a la interfaz del menú principal.
        Intent i = new Intent(this, menuPrincipal.class);
        i.putExtra("usuario", usuario);
        setResult(RESULT_OK, i);
        finish();
        startActivity(i);
    }

    @Override
    public void onClick(View view) {

    }
    @Override
    public void onBackPressed() {
        //En caso de que se pulse el "botón" back se preguntará al usuario mediante un Dialog si desea salir de la aplicación. Si se pulsa afirmativamente se sale de la aplicación y si se contesta negativamente se cancela el cierre de esta.
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.salida)
                .setCancelable(false)
                .setPositiveButton(R.string.si, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                })
                .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //Para evitar problemas de incoherencia cuando hay llamadas por ejemplo.
        super.onSaveInstanceState(outState);
        outState.putString("usuario",usuario);
    }
    @Override
    protected void onRestoreInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("usuario",usuario);
    }
}