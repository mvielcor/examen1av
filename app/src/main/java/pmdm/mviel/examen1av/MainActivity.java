package pmdm.mviel.examen1av;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements Botonera.InteraccioAmbBotonera,DadesPersonalsFragment.AccionsDadesPersonals, AficionsFragment.AccionsAficionsFragment {

    // Declarem els atributs d'aquest Activity
    private FragmentManager fm;
    private FragmentTransaction ft;

    private DadesPersonalsFragment dpf;
    private AficionsFragment af;

    private  String nom,edat,sexe;
    private final int CODI_SUBACTIVITY = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dpf = DadesPersonalsFragment.newInstance("","");
        af = AficionsFragment.newInstance("","");

    }

    /**
     * Mètode que comunica el fragment Botonera amb aquest Activity.
     * Aquest mètode carrega en el fragment dinàmic el fragment DadesPersonalsFragment
     */
    @Override
    public void carrregaDadesPersonalsFragment() {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();


        if (fm.findFragmentById(R.id.fragmentDinamic)==null) {
            ft.add(R.id.fragmentDinamic, dpf);
        }else {
            ft.replace(R.id.fragmentDinamic, dpf);
        }

        ft.addToBackStack(null);
        ft.commit();

    }


    @Override
    public void carregaAficionsFragment() {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();

        if (fm.findFragmentById(R.id.fragmentDinamic)==null) {
            ft.add(R.id.fragmentDinamic, af);
        }else {
            ft.replace(R.id.fragmentDinamic, af);
        }

        ft.addToBackStack(null);
        ft.commit();
    }

    @Override
    public void carregarSubactivity() {
        Intent i = new Intent(this,Subactivity.class);
        Bundle dadesAPassarAlSubactivity = new Bundle();
        dadesAPassarAlSubactivity.putString("Nom",this.nom);
        dadesAPassarAlSubactivity.putString("Edat",this.edat);
        dadesAPassarAlSubactivity.putString("Sexe",this.sexe);
        //dadesAPassarAlSubactivity.putString("Lectures",this.lectures);
        //dadesAPassarAlSubactivity.putString("Puntuacio",this.puntuacio);
        i.putExtras(dadesAPassarAlSubactivity);

        startActivityForResult(i,CODI_SUBACTIVITY);  //Cridem al Subactivity
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==CODI_SUBACTIVITY){
            if(resultCode==RESULT_OK){
                fm = getSupportFragmentManager();
                ft = fm.beginTransaction();
                if (fm.findFragmentById(R.id.fragmentDinamic)!=null) {
                    ft.remove(fm.findFragmentById(R.id.fragmentDinamic));

                }
                ft.commit();


            }
        }
    }

    @Override
    public boolean guardarDadesPersonals(String n, String e, String s) {
        this.nom=n;
        this.edat=e;
        this.sexe=s;
        Log.d("Manel","Dades guardades: "+n+","+e+","+s);
        return true;
    }

    @Override
    public void guardarAficions(String media, String punts) {

    }
}
