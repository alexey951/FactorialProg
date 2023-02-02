package com.example.factorialprogram;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.factorialprogram.R;

public class MainActivity extends AppCompatActivity {
    EditText number;
    TextView answer;
    Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
    }
    private void initialize() {
        number = (EditText) findViewById(R.id.et_apti_number);
        number.setHint("Введите число для факторизации :P");
        answer = (TextView) findViewById(R.id.tv_apti_answer);
        calculate = (Button) findViewById(R.id.b_apti_calc);
        calculate.setOnClickListener((View.OnClickListener) this);
    }
    private long calcFactorial() {
        long factorial = 1;
        try {
            factorial = Long.parseLong(number.getText().toString());
            for(long i=factorial-1; i>0; i--){
                factorial = i * factorial;
            }
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Неверный ввод", Toast.LENGTH_LONG).show();
        } finally {}

        return factorial;
    }

    public void onClick(View v) {
        answer.setText("Факториал из " + number.getText().toString() + " = : " + calcFactorial());
    }
}