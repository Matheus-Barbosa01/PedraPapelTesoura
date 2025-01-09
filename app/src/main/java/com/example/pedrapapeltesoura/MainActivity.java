package com.example.pedrapapeltesoura;

import android.graphics.drawable.ShapeDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void selecionarPedra(View view){
        selecionarGanhador("pedra");
    }
    public void selecionarPapel(View view){
        selecionarGanhador("papel");
    }
    public void selecionarTesoura(View view){
        selecionarGanhador("tesoura");
    }

    private String gerarEscolhaAleatoriaApp() {

        String[] opcoes = {"pedra", "papel", "tesoura"};
        int gerarNumero = new Random().nextInt(3);

        ImageView imagemApp = findViewById(R.id.image_app);
        String escolhaApp = opcoes[gerarNumero];
        switch (escolhaApp){
            case "pedra" :
                imagemApp.setImageResource(R.drawable.pedra);
                //System.out.println("o App escolheu pedra");
                    break;
            case "papel":
                imagemApp.setImageResource(R.drawable.papel);
               // System.out.println("o App escolheu papel");
                break;
            case "tesoura":
                imagemApp.setImageResource(R.drawable.tesoura);
                //System.out.println("o App escolheu tesoura");
            break;
        }


        return escolhaApp;
    }

    private void selecionarGanhador(String escolhaUsuario){
        //System.out.println("Foi escolhido:" + escolhaUsuario);

        String escolhaApp = gerarEscolhaAleatoriaApp();
        TextView textoresultado = findViewById(R.id.text_resultado);

        if(
            (escolhaApp == "pedra" && escolhaUsuario == "tesoura") ||
            (escolhaApp == "papel" && escolhaUsuario == "pedra") ||
            (escolhaApp == "tesoura" && escolhaUsuario == "papel")
        ){
            textoresultado.setText("Você perdeu :(");

        }else if (
            (escolhaUsuario == "pedra" && escolhaApp == "tesoura") ||
            (escolhaUsuario == "papel" && escolhaApp == "pedra") ||
            (escolhaUsuario == "tesoura" && escolhaApp == "papel")
        ){
            textoresultado.setText("Você ganhou :)");

        }else{
        textoresultado.setText("você Empatou :|");

        }
    }
}