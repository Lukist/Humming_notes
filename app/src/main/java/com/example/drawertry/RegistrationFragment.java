package com.example.drawertry;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RegistrationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegistrationFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RegistrationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RegistrationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RegistrationFragment newInstance(String param1, String param2) {
        RegistrationFragment fragment = new RegistrationFragment();
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

    private Button btnRegistro;
    private EditText cuilInput, nombreInput, fechaNacimientoInput, mailInput;
    private RadioGroup radioSex;
    private RadioButton radiobtn;

    ModeloClientes cliente;

    DatabaseHelper db;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_registration, container, false);

        btnRegistro = root.findViewById(R.id.btnRegistro);
        cuilInput = root.findViewById(R.id.cuilInput);
        nombreInput = root.findViewById(R.id.nombreInput);
        fechaNacimientoInput = root.findViewById(R.id.fechaInput);
        radioSex = (RadioGroup) root.findViewById(R.id.radioSex);
        mailInput = root.findViewById(R.id.mailInput);


        db = new DatabaseHelper(getContext());

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    radiobtn = (RadioButton) root.findViewById(radioSex.getCheckedRadioButtonId());
                    cliente = new ModeloClientes(-1, cuilInput.getText().toString(), nombreInput.getText().toString(), fechaNacimientoInput.getText().toString(), radiobtn.getText().toString(), mailInput.getText().toString());
                    boolean succes = db.agragarCliente(cliente);
                    Toast.makeText(getContext(), cliente.toString() + succes, Toast.LENGTH_SHORT).show();
                }catch (Exception e) {
                    Toast.makeText(getContext(), "A ocurrido un erro", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return root;
    }
}