package br.edu.ifsp.aqa.conversortemperatura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView conversaoTextView;
    private EditText converterEditText;
    private Button converterCelsius;
    private Button converterFahrenheit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        conversaoTextView = findViewById(R.id.saida_conversao);
        converterEditText = findViewById(R.id.edit_text_graus);
        converterCelsius = findViewById(R.id.button_celsius);
        converterFahrenheit = findViewById(R.id.button_fahrenheit);


        converterCelsius.setOnClickListener(this);
        converterFahrenheit.setOnClickListener(this);

    }
@Override
    public void onClick(View v){
        if(v == converterCelsius)
            converterParaCelsius();
        else
            converterParaFahrenheit();
}
    public void converterParaCelsius(){
        double entrada;
        try{
            entrada = Double.valueOf(converterEditText.getText().toString());
        }catch (NumberFormatException ex){
            entrada = 0;
            throw ex;
        }
        entrada = (entrada-32)/1.8;
       conversaoTextView.setText(String.format("%.2f °C",entrada));
    }

    public void converterParaFahrenheit(){
        double entrada;
        try{
            entrada = Double.valueOf(converterEditText.getText().toString());
        }catch (NumberFormatException ex){
            entrada = 0;
            throw ex;
        }
        entrada = 1.8*entrada+32;
        conversaoTextView.setText(String.format("%.2f °F",entrada));
    }

}
