package br.edu.ifsp.aqa.conversortemperatura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView celsiusTextView;
    private EditText converterEditText;
    private Button converterButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        celsiusTextView = findViewById(R.id.saida_conversao);
        converterEditText = findViewById(R.id.edit_text_graus);
        converterButton = findViewById(R.id.button_converter);

        converterButton.setOnClickListener(this);

    }
@Override
    public void onClick(View v){
        converterParaCelsius();
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
        celsiusTextView.setText(String.format("%.2f °C",entrada));
    }

}
