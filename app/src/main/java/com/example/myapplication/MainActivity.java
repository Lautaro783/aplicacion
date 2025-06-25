package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText numero1, numero2;
    Button btnSumar, btnRestar, btnMultiplicar, btnDividir;
    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        numero1 = findViewById(R.id.numero1);
        numero2 = findViewById(R.id.numero2);
        btnSumar = findViewById(R.id.btnSumar);
        btnRestar = findViewById(R.id.btnRestar);
        btnMultiplicar = findViewById(R.id.btnMultiplicar);
        btnDividir = findViewById(R.id.btnDividir);
        resultado = findViewById(R.id.resultado);

        btnSumar.setOnClickListener(v -> realizarOperacion("+"));
        btnRestar.setOnClickListener(v -> realizarOperacion("-"));
        btnMultiplicar.setOnClickListener(v -> realizarOperacion("*"));
        btnDividir.setOnClickListener(v -> realizarOperacion("/"));
    }

    private void realizarOperacion(String operacion) {
        String num1Str = numero1.getText().toString();
        String num2Str = numero2.getText().toString();

        if (num1Str.isEmpty() || num2Str.isEmpty()) {
            resultado.setText(getString(R.string.ingrese_ambos));
            return;
        }

        double num1 = Double.parseDouble(num1Str);
        double num2 = Double.parseDouble(num2Str);
        double res = 0;

        switch (operacion) {
            case "+": res = num1 + num2; break;
            case "-": res = num1 - num2; break;
            case "*": res = num1 * num2; break;
            case "/":
                if (num2 == 0) {
                    resultado.setText(getString(R.string.no_dividir_cero));
                    return;
                }
                res = num1 / num2;
                break;
        }

        resultado.setText(getString(R.string.resultado, res));

    }
}


