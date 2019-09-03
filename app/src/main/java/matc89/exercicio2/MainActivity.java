package matc89.exercicio2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private String nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
    }

    public void trocarUsuario(View view){
        Intent intent = new Intent(this, OutraActivity.class);

        nome = textView.getText().toString();

        if(nome.equals("Oi!"))
            intent.putExtra("nome", "");
        else {
            nome = nome.substring(4,nome.length()-1);
            intent.putExtra("nome", nome);
        }
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent dados){
        if(requestCode==1 && resultCode==RESULT_OK){
            String resultado;
            resultado = dados.getStringExtra("nome");
            if(resultado.isEmpty()){
                textView.setText("Oi!");
            }
            else{
                textView.setText("Oi, "+resultado+"!");
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putString("texto",textView.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        textView.setText(savedInstanceState.getString("texto"));
    }



}
