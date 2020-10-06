package com.ahiralabata.ahirakalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText angka1, angka2;
    TextView total;
    Button tambah, kurang, kali, bagi, bersihkan;
    Double hasil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        angka1 = findViewById(R.id.angka1);
        angka2 = findViewById(R.id.angka2);
        tambah = findViewById(R.id.tambah);
        kurang = findViewById(R.id.kurang);
        kali = findViewById(R.id.kali);
        bagi = findViewById(R.id.bagi);
        bersihkan = findViewById(R.id.bersih);
        total = findViewById(R.id.hasil);

        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitung("+");
            }
        });

        kurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitung("-");
            }
        });

        kali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitung("x");
            }
        });

        bagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitung("/");
            }
        });

        bersihkan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                angka1.setText("");
                angka2.setText("");
                total.setText("0");
                angka1.requestFocus();
            }
        });
    }

    private void hitung(String operator){
        if(angka1.getText().toString().equals("") || angka2.getText().toString().equals("")){
            Toast.makeText(MainActivity.this, "Silakan isi kedua angka", Toast.LENGTH_LONG).show();
        }else{
            if(operator.equals("+")){
                hasil = Double.parseDouble(angka1.getText().toString()) + Double.parseDouble(angka2.getText().toString());
                total.setText(hasil.toString());
            }else if(operator.equals("-")){
                hasil = Double.parseDouble(angka1.getText().toString()) - Double.parseDouble(angka2.getText().toString());
                total.setText(hasil.toString());
            }else if(operator.equals("x")){
                hasil = Double.parseDouble(angka1.getText().toString()) * Double.parseDouble(angka2.getText().toString());
                total.setText(hasil.toString());
            }else {
                hasil = Double.parseDouble(angka1.getText().toString()) / Double.parseDouble(angka2.getText().toString());
                total.setText(hasil.toString());
            }
        }

    }
}