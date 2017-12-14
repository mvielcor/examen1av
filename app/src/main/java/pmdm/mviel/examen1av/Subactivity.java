package pmdm.mviel.examen1av;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Subactivity extends AppCompatActivity {

    private TextView et_nom,et_edat,et_sexe,et_lectures,et_puntuacio;
    private Button btn_tancar_finestra;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subactivity);

        et_nom = (TextView) findViewById(R.id.tv_nom);
        et_edat = (TextView) findViewById(R.id.tv_edat);
        et_sexe = (TextView) findViewById(R.id.tv_sexe);
        et_lectures = (TextView) findViewById(R.id.tv_lectures);
        et_puntuacio = (TextView) findViewById(R.id.tv_puntuacio);

        btn_tancar_finestra = (Button) findViewById(R.id.btn_tancar_finestra);

        //Posem les dades rebudes des del Bundle
        Bundle dadesRebudes = getIntent().getExtras();
        if(dadesRebudes!=null){
            et_nom.setText( dadesRebudes.getString("Nom"));
            et_edat.setText( dadesRebudes.getString("Edat"));
            et_sexe.setText( dadesRebudes.getString("Sexe"));
           // et_lectures.setText( dadesRebudes.getString("Lectures"));
           // et_puntuacio.setText( dadesRebudes.getString("Puntuacio"));
        }

        btn_tancar_finestra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_OK);
                finish();
            }
        });
    }
}
