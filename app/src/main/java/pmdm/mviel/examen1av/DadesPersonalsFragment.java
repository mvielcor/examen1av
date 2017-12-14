package pmdm.mviel.examen1av;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DadesPersonalsFragment.AccionsDadesPersonals} interface
 * to handle interaction events.
 * Use the {@link DadesPersonalsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DadesPersonalsFragment extends Fragment {

    // Declarem els objectes del fragment
    private Button btn_enviarDades;
    private EditText et_nom, et_edat;
    private RadioButton rb_mascle, rb_femella;

    // Declarem les dades que rebem de l'usuari
    private String nom,edat,sexe;



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private AccionsDadesPersonals mListener;

    public DadesPersonalsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DadesPersonalsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DadesPersonalsFragment newInstance(String param1, String param2) {
        DadesPersonalsFragment fragment = new DadesPersonalsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_dades_personals, container, false);

        //assignem elements del XML a objectes Java
        btn_enviarDades = (Button)v.findViewById(R.id.btnEnviarDades);
        et_edat = (EditText) v.findViewById(R.id.et_edat);
        et_nom = (EditText) v.findViewById(R.id.et_nom);
        rb_mascle = (RadioButton) v.findViewById(R.id.rb_mascle);
        rb_femella = (RadioButton) v.findViewById(R.id.rb_femella);

        //Afegim un Listener
        btn_enviarDades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               comprovaDadesIntroduides();
            }

        });

        return v;
    }

    private void comprovaDadesIntroduides() {
        //Comprovem que no hi haja cap camp buit
        if (String.valueOf(et_edat.getText()).isEmpty() || String.valueOf(et_nom.getText()).isEmpty() || (!rb_femella.isChecked() && !rb_mascle.isChecked())) {
            Toast.makeText(getActivity(), "Et falten dades per introduir", Toast.LENGTH_SHORT).show();
        } else {

            nom = et_nom.getText().toString();
            edat = et_edat.getText().toString();
            sexe = null;
            if (rb_mascle.isChecked()) sexe = "Mascle";
            else sexe = "Femella";

            if (mListener.guardarDadesPersonals(nom,edat,sexe))  // Ací comuniquem les dades del FRagment a l'Activity!!!
                Toast.makeText(getActivity(), "Dades guardades correctament", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(getActivity(), "Error guardant dades", Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof AccionsDadesPersonals) {
            mListener = (AccionsDadesPersonals) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " has d'implementar AccionsDadesPersonals");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface AccionsDadesPersonals {
        // TODO: Update argument type and name
        boolean guardarDadesPersonals(String n,String e,String s);
    }
}
