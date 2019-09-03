package matc89.exercicio2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;

public class OutraActivity extends AppCompatActivity {

    private EditText editText;
    private String nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outra);

        editText = (EditText) findViewById(R.id.editText);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            nome = extras.getString("nome");
            editText.setText(nome);
        }
    }

    public void confirmarTroca(View view){
        Intent dados = new Intent();
        nome = editText.getText().toString();
        dados.putExtra("nome", nome);
        setResult(RESULT_OK, dados);
        finish();
    }

    public void cancelarTroca(View view){
        finish();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putString("textoAlterado",editText.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        editText.setText(savedInstanceState.getString("textoAlterado"));
    }
}
