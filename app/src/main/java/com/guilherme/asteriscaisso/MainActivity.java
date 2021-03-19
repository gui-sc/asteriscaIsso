package com.guilherme.asteriscaisso;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    StringBuilder asterisco;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextInputEditText txtFrase = findViewById(R.id.txtFrase);
        final TextView lblAsterisco = findViewById(R.id.lblAsterisco);
        Button btnColar = findViewById(R.id.btnColar);
        Button btnAsterisco = findViewById(R.id.btnAsterisco);
        final ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        btnAsterisco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asterisco = new StringBuilder();
                String frase = txtFrase.getText().toString();
                char[] letras = frase.toCharArray();
                for (int i = 0; i < letras.length; i++) {
                    if(String.valueOf(letras[i]).equals(" ")){
                        asterisco.append(" ");
                    }else{
                        asterisco.append("*");
                    }
                }
                lblAsterisco.setText(asterisco.toString());
            }
        });
        btnColar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipData clip = ClipData.newPlainText("asterisco", asterisco.toString());
                clipboard.setPrimaryClip(clip);
                Toast.makeText(MainActivity.this, "Copiado!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
