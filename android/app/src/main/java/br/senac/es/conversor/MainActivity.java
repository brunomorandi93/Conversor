package br.senac.es.conversor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
  // é o nome da classe
    int alturaEmCentimetros = 0;
    // declaração da Variavel

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      // é um metodo protegido só quem herda

        setContentView(R.layout.activity_main);
        // metodo que liga a MainActivity.JAVA no activity_main.xml (TELA)

        final TextView txtMetros = (TextView) findViewById(R.id.txtMetros);
        // Instancia de um elemento texto para android

        final TextView txtPes = (TextView) findViewById(R.id.txtPes);

        final SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);

        seekBar.setMax(230);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch (SeekBar seekBar) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                txtPes.setText("Toque em Converter");
             //frase para Converter
            }

            @Override
            public void onProgressChanged (SeekBar seekBar, int progress, boolean fromUser) {

                alturaEmCentimetros = progress;
                //Declarando uma variavel com o valor igual ao progresso.
                String texto = formataValorComDoisDigitos (progress / 100.0);
                texto += "m.";
                txtMetros.setText(texto);

            }
        });

        final Button btnConverter = (Button) findViewById(R.id.btnConverter);
        btnConverter.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double alturaEmPes = alturaEmCentimetros / 30.48;
                String texto = formataValorComDoisDigitos(alturaEmPes);
                texto += " pé(s)";
                txtPes.setText(texto);
            }
        });
    }
    private String formataValorComDoisDigitos(double valor){
        return String.format(Locale.FRANCE, "%.2f", valor);



    }
}
