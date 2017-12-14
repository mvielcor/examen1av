package pmdm.mviel.examen1av;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Botonera.InteraccioAmbBotonera} interface
 * to handle interaction events.
 * Use the {@link Botonera#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Botonera extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private InteraccioAmbBotonera mListener;
    // Afegim els elements del nostre fragment
    private Button btn_dades_Personals, btn_aficions;
    private ImageButton btn_info;

    public Botonera() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Botonera.
     */
    // TODO: Rename and change types and number of parameters
    public static Botonera newInstance(String param1, String param2) {
        Botonera fragment = new Botonera();
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
        View v = inflater.inflate(R.layout.fragment_botonera, container, false);

        btn_dades_Personals = (Button) v.findViewById(R.id.btn_dades_personals);
        btn_aficions = (Button) v.findViewById(R.id.btn_aficions);
        btn_info = (ImageButton) v.findViewById(R.id.btn_info);
        // Listeners per a cada botó amb les accions associades.
        btn_dades_Personals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.carrregaDadesPersonalsFragment();  // Cridem al mètode carrregaDadesPersonalsFragment
                                                            // que s'implementarà en l'Activity que contindrà aquest fragment
            }
        });

        btn_aficions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.carregaAficionsFragment();  // Cridem al mètode carrregaAficionsFragment
                                                        // que s'implementarà en l'Activity que contindrà aquest fragment
            }
        });

        btn_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.carregarSubactivity();      // Cridem al mètode carrregaSubactivity
                                                    // que s'implementarà en l'Activity que contindrà aquest fragment
            }
        });


        return v;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof InteraccioAmbBotonera) {
            mListener = (InteraccioAmbBotonera) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " has d'implementar InteraccioAmbBotonera");
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
    public interface InteraccioAmbBotonera {
        // TODO: Update argument type and name
        void carrregaDadesPersonalsFragment();
        void carregaAficionsFragment();
        void carregarSubactivity();
    }
}
