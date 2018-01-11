package com.example.juanjo.ejerciciofecha;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    Button botonFecha, botonHora, botonColor;


    TextView fecha, hora, color;

    DatePickerDialog dialogoFecha;

    TimePickerDialog dialogoHora;

    AlertDialog.Builder dialogoColores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonFecha = (Button) findViewById(R.id.btnFecha);
        botonHora = (Button) findViewById(R.id.btnHora);
        botonColor = (Button) findViewById(R.id.btnColor);

        fecha = (TextView) findViewById(R.id.textFecha);
        hora = (TextView) findViewById(R.id.textHora);
        color = (TextView) findViewById(R.id.textColor);

        dialogoFecha = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                fecha.setText("FECHA: "+ day + "/" + (month+1) + "/" + year);

            }
        },  2015,  2,  11);

        dialogoHora = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hour, int minute) {

                hora.setText("HORA: " + hour + ":" + minute);
            }
        }, 00 , 00, false);

       /* final String[] colores_array = new String[3];

                colores_array[0] ="Azul";
                colores_array[1] = "Verde";
                colores_array[2] = "Rojo";
*/
                dialogoColores = new AlertDialog.Builder(this);

                dialogoColores.setTitle("Selecciona un color").setItems(R.array.colores, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        String[] colores_array = getResources().getStringArray(R.array.colores);

                        color.setText("COLOR: " + colores_array[i]);
                    }
                });

                dialogoColores.create();

                botonFecha.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        dialogoFecha.show();
                    }
                });

                botonHora.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        dialogoHora.show();
                    }
                });

                botonColor.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        dialogoColores.show();
                    }
                });
    }
}
